package com.heartape.shop.product;

import java.math.BigDecimal;

/**
 * 组合产品
 * @author heartape
 */
public class GroupProduct {

    private Long id;

    /**
     * 商品id
     * {@link Product}
     */
    private Long productId;

    /**仓库id*/
    private Long warehouseId;

    /**价格*/
    private BigDecimal price;

    private CurrencyCode currencyCode;

    /**规格*/
    private Float specification;

    /**是否可用*/
    private Boolean available;

}
