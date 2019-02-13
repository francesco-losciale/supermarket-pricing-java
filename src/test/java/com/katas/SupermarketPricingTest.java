package com.katas;

import org.junit.Test;

import junit.framework.TestCase;

public class SupermarketPricingTest extends TestCase {

    @Test
    public void testSpecialPricingThreeForDollar() throws Exception {
        // three for a dollar, what is the price of 4 or 5?
        final double normalItemPrice = 15.99;
        final Price price = new Price(new Item(normalItemPrice), new PricePerQuantityUnit(new Quantity(3, WeightUnit.GRAM), 1.0));
        assertEquals(price.calculate(4), 1 + normalItemPrice);
        assertEquals(price.calculate(5), 1 + normalItemPrice * 2);
        assertEquals(price.calculate(6), 2D);
        assertEquals(price.calculate(7), 2 + normalItemPrice);
        assertEquals(price.calculate(8), 2 + normalItemPrice * 2);
    }

    @Test
    public void testSpecialPricingBuyTwoGetOneFree() throws Exception {
        // buy two, get one free, so does the third item have a price?
        // !! this is a different scenario, you are not buying thow to get one free,
        // !! but you're actually buying two and "surprisingly" getting one free.
        final double normalItemPrice = 15.99;
        final Price price = new Price(new Item(normalItemPrice), WeightUnit.GRAM, new QuantityFreePerQuantity(2, 1, normalItemPrice));
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
        assertEquals(quantity(1, WeightUnit.KILO), quantity(1000, WeightUnit.GRAM));
        assertEquals(quantity(1, WeightUnit.HECTO), quantity(100, WeightUnit.GRAM));
        assertEquals(quantity(1, WeightUnit.KILO), quantity(10, WeightUnit.HECTO));
    }

    @Test
    public void testSpecialPriceHectoPriceBasedOnKiloPrice() throws Exception {
        // 20 euro per Kilo, how much 150 grams?
        final double pricePerKilo = 15.99;
        final Price price = new Price(new Item(pricePerKilo), new PricePerQuantityUnit(
                new Quantity(1),
                pricePerKilo)
        );
        assertEquals(price.calculate(0.400), pricePerKilo * 0.400);
        assertEquals(price.calculate(0.413), pricePerKilo * 0.413);
    }

    private double quantity(int quantity, Unit unit) {
        return new Quantity(quantity, unit).getValue();
    }

}
