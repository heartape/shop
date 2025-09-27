package com.heartape.shop.inventory;

import java.math.BigDecimal;

/**
 * 门店库存
 */
public class StoreInventory {

    private Long id;

    /**门店id*/
    private Long storeId;

    /**商品id*/
    private Long productId;

    /**库存数量*/
    private BigDecimal count;

}
