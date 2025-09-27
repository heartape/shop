package com.heartape.shop.product;

import java.math.BigDecimal;

/**
 * 商品零售价
 */
public class RetailPrice {

    private Long id;

    /**
     * 商品id
     */
    private Long productId;

    /**门店id*/
    private Long storeId;

    private PriceType priceType;

    /**指导价*/
    private BigDecimal guidePrice;

    /**价格*/
    private BigDecimal price;

    /**副价格*/
    private BigDecimal sidePrice;

    private CurrencyCode currencyCode;

}
