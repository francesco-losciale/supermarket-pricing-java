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

@Deprecated
public class PricePerQuantity implements PriceSchema {

    private final Quantity quantity;
    private final double price;

    public PricePerQuantity(Quantity quantity, double price) {
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
