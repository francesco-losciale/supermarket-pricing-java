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

public class Price {

    private Item item;
    private PriceSchema priceSchema;

    public Price(Item item, PriceSchema priceSchema) {
        this.item = item;
        this.priceSchema = priceSchema;
    }

    public Price(Item item, QuantitySchema quantitySchema) {
        this(item, new PricePerQuantity(
                quantitySchema.getQuantity() + quantitySchema.getFreeQuantity(),
                item.getPrice() * quantitySchema.getQuantity()
                )
        );
    }

    public double calculate(int purchaseQuantity) {
        final int quantityNormalPrice = purchaseQuantity % priceSchema.getQuantity();
        final int quantityDiscountedPrice = (purchaseQuantity - quantityNormalPrice) / priceSchema.getQuantity();
        return quantityNormalPrice * item.getPrice() + quantityDiscountedPrice * priceSchema.getPrice();
    }
}
