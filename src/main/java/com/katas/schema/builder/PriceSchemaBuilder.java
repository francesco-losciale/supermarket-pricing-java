package com.katas.schema.builder;


import com.katas.model.Quantity;
import com.katas.model.Unit;
import com.katas.model.WeightUnit;
import com.katas.schema.PricePerQuantityUnit;
import com.katas.schema.PriceSchema;

public class PriceSchemaBuilder {

    private Unit unit;
    private double price;
    private double quantity;
    private double quantityFree;


    public PriceSchemaBuilder withQuantity(double quantity) {
        this.quantity = quantity;
        return this;
    }

    public PriceSchemaBuilder unit(Unit unit) {
        this.unit = unit;
        return this;
    }

    public PriceSchemaBuilder withPrice(double price) {
        this.price = price;
        return this;
    }

    public PriceSchema build() {
        return new PricePerQuantityUnit(new Quantity(3, WeightUnit.GRAM), 1.0);
    }
}
