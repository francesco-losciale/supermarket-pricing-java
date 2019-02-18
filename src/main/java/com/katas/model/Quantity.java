/*------------------------------------------------------------------------------
 *******************************************************************************
 * COPYRIGHT Ericsson 2018
 *
 * The copyright to the computer program(s) herein is the property of
 * Ericsson Inc. The programs may be used and/or copied only with written
 * permission from Ericsson Inc. or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the
 * program(s) have been supplied.
 *******************************************************************************
 *----------------------------------------------------------------------------*/
package com.katas.model;

public class Quantity {

    private final double quantity;
    private final Unit unit;

    public Quantity(double quantity) {
        this.unit = null;
        this.quantity = quantity;
    }

    public Quantity(double quantity, Unit unit) {
        this.quantity = quantity;
        this.unit = unit;
    }

    public double getValue() {
        if (unit != null) {
            return unit.multiply(quantity);
        } else {
            return quantity;
        }
    }
}
