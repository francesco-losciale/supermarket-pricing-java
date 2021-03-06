package com.katas;

import org.junit.Test;

import com.katas.model.*;
import com.katas.schema.PriceSchema;
import com.katas.schema.QuantitySchema;
import com.katas.schema.builder.PriceSchemaBuilder;
import com.katas.schema.builder.QuantitySchemaBuilder;

import junit.framework.TestCase;

public class SupermarketPricingTest extends TestCase {

    @Test
    public void testSpecialPricingThreeForDollar() throws Exception {
        // three for a dollar, what is the atPrice of 4 or 5?
        final double normalItemPrice = 15.99;
        final PriceSchema priceSchema = new PriceSchemaBuilder().withQuantity(3).withPrice(1.0).build();
        final Price price = new Price(new Item(normalItemPrice), priceSchema);
        assertEquals(price.calculate(4), 1 + normalItemPrice);
        assertEquals(price.calculate(5), 1 + normalItemPrice * 2);
        assertEquals(price.calculate(6), 2D);
        assertEquals(price.calculate(7), 2 + normalItemPrice);
        assertEquals(price.calculate(8), 2 + normalItemPrice * 2);
    }

    @Test
    public void testSpecialPricingBuyTwoGetOneFree() throws Exception {
        // buy two, get one free, so does the third item have a atPrice?
        // !! this is a different scenario, you are not buying thow to get one free,
        // !! but you're actually buying two and "surprisingly" getting one free.
        final double normalItemPrice = 15.99;
        final QuantitySchema quantitySchema = new QuantitySchemaBuilder().withQuantity(2).withFreeQuantity(1).atPrice(normalItemPrice).build();
        final Price price = new Price(new Item(normalItemPrice), WeightUnit.GRAM, quantitySchema);
        // TODO throw exception if you buy 2 - you can get one free!
        assertEquals(price.calculate(3), normalItemPrice * 2);
        assertEquals(price.calculate(4), normalItemPrice * 2 + normalItemPrice);
        assertEquals(price.calculate(5), normalItemPrice * 2 + normalItemPrice * 2);
        // TODO throw exception if you buy 5 - you can get one free!
        assertEquals(price.calculate(6), normalItemPrice * 2 + normalItemPrice * 2);
    }

    @Test
    public void testQuantityOnScale() throws Exception {
        // Create an abstraction on Quantity from int to different measurement systems
        assertEquals(newQuantity(1, WeightUnit.KILO), newQuantity(1000, WeightUnit.GRAM));
        assertEquals(newQuantity(1, WeightUnit.HECTO), newQuantity(100, WeightUnit.GRAM));
        assertEquals(newQuantity(1, WeightUnit.KILO), newQuantity(10, WeightUnit.HECTO));
    }

    @Test
    public void testSpecialPriceHectoPriceBasedOnKiloPrice() throws Exception {
        // 20 euro per Kilo, how much 150 grams?
        final double pricePerKilo = 15.99;
        final PriceSchema priceSchema = new PriceSchemaBuilder().withQuantity(1).unit(WeightUnit.KILO).withPrice(pricePerKilo).build();
        final Price price = new Price(new Item(pricePerKilo), priceSchema);
        assertEquals(price.calculate(0.400), pricePerKilo * 0.400);
        assertEquals(price.calculate(0.413), pricePerKilo * 0.413);
    }

    // TODO Look how you created Quantity(double withQuantity, Unit unit)! Actually a withQuantity is not associated to
    // TODO only one unit, but more than one (ie. 1 kilo of pasta is associated to 10 hecto).
    // TODO Actually the withQuantity has necessarily a unit initially to be created with.
    private double newQuantity(int quantity, Unit unit) {
        return new Quantity(quantity, unit).getValue();
    }

}
