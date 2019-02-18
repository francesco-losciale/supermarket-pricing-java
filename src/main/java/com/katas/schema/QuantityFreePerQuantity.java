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

public class QuantityFreePerQuantity implements QuantitySchema {

    private final int quantity;
    private final int freeQuantity;

    public QuantityFreePerQuantity(int quantity, int freeQuantity, double price) {
        this.quantity = quantity;
        this.freeQuantity = freeQuantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getFreeQuantity() {
        return freeQuantity;
    }

}
