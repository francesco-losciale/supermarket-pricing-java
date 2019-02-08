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
package com.katas;

public class Quantity {

    private final double quantity;
    private final QuantityUnit quantityUnit;

    public Quantity(double quantity, QuantityUnit quantityUnit) {
        this.quantity = quantity;
        this.quantityUnit = quantityUnit;
    }

    public double getValue() {
        return quantity * quantityUnit.getMultiplier();
    }
}
