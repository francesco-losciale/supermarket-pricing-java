package com.katas;

public class QuantitySchemaBuilder {

    private int quantity;
    private int freeQuantity;
    private double price;

    public QuantitySchemaBuilder quantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public QuantitySchemaBuilder plusFreeQuantity(int freeQuantity) {
        this.freeQuantity = freeQuantity;
        return this;
    }

    public QuantitySchemaBuilder price(double price) {
        this.price = price;
        return this;
    }

    public QuantitySchema build() {
        return new QuantityFreePerQuantity(quantity, freeQuantity, price);
    }
}
