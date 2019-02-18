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

import com.katas.schema.PricePerQuantityUnit;
import com.katas.schema.PriceSchema;
import com.katas.schema.QuantitySchema;

public class Price {

    private Item item;
    private PriceSchema priceSchema;

    public Price(Item item, PriceSchema priceSchema) {
        this.item = item;
        this.priceSchema = priceSchema;
    }

    public Price(Item item, Unit unit, QuantitySchema quantitySchema) {
        this(item, new PricePerQuantityUnit(
                new Quantity(quantitySchema.getQuantity() + quantitySchema.getFreeQuantity(), unit),
                item.getPrice() * quantitySchema.getQuantity()
                )
        );
    }

    public double calculate(double purchaseQuantity) {
        final double quantityNormalPrice = purchaseQuantity % priceSchema.getQuantity().getValue();
        final double quantityDiscountedPrice = (purchaseQuantity - quantityNormalPrice) / priceSchema.getQuantity().getValue();
        return quantityNormalPrice * item.getPrice() + quantityDiscountedPrice * priceSchema.getPrice();
    }
}
