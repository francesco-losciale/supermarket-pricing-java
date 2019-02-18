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
package com.katas.schema;

import com.katas.model.Quantity;

public class PricePerQuantityUnit implements PriceSchema {

private final Quantity quantity;
    private double price;

    public PricePerQuantityUnit(Quantity quantity, double price) {
        this.quantity = quantity;
        this.price = price;
    }

    public Quantity getQuantity() {
        return this.quantity;
    }

    public double getPrice() {
        return this.price;
    }
}
