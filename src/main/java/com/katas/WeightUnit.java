package com.katas;


public class WeightUnit extends Unit {

    final static public Unit KILO = new Unit(1000);
    final static public Unit HECTO = new Unit(100);
    final static public Unit DEKA = new Unit(10);
    final static public Unit GRAM = new Unit(1);
    final static public Unit DECI = new Unit(0.1);
    final static public Unit CENTI = new Unit(0.01);
    final static public Unit MILLI = new Unit(0.001);

    private WeightUnit(double multiplier) {
        super(multiplier);
    }

}
