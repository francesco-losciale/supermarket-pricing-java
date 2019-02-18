package com.katas.model;


public class Unit {

    private double multiplier;

    protected Unit(double multiplier) {
        this.multiplier = multiplier;
    }

    public double multiply(double quantity) {
        return quantity * multiplier;
    }
}
