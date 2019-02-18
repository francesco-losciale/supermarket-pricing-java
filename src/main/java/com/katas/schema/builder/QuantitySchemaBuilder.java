package com.katas.schema.builder;

import com.katas.schema.QuantityFreePerQuantity;
import com.katas.schema.QuantitySchema;

public class QuantitySchemaBuilder {

    private int quantity;
    private int freeQuantity;
    private double price;

    public QuantitySchemaBuilder withQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public QuantitySchemaBuilder withFreeQuantity(int freeQuantity) {
        this.freeQuantity = freeQuantity;
        return this;
    }

    public QuantitySchemaBuilder atPrice(double price) {
        this.price = price;
        return this;
    }

    public QuantitySchema build() {
        return new QuantityFreePerQuantity(quantity, freeQuantity, price);
    }
}
