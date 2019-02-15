package com.katas;


public class PriceSchemaBuilder {

    private Unit unit;
    private double price;
    private double quantity;
    private double quantityFree;


    public PriceSchemaBuilder quantity(double quantity) {
        this.quantity = quantity;
        return this;
    }

    public PriceSchemaBuilder unit(Unit unit) {
        this.unit = unit;
        return this;
    }

    public PriceSchemaBuilder price(double price) {
        this.price = price;
        return this;
    }

    public PriceSchema build() {
        return new PricePerQuantityUnit(new Quantity(3, WeightUnit.GRAM), 1.0);
    }
}
