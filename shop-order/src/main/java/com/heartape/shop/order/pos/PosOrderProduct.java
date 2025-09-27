package com.heartape.shop.order.pos;

import com.heartape.shop.product.CurrencyCode;
import com.heartape.shop.product.Product;

import java.math.BigDecimal;

/**
 * 产品
 */
public class PosOrderProduct {

    /**
     * 商品id
     * {@link Product}
     */
    private Long productId;

    private int count;

    /**原价*/
    private BigDecimal originalPrice;

    /**实际售价*/
    private BigDecimal price;

    private CurrencyCode currencyCode;

}
