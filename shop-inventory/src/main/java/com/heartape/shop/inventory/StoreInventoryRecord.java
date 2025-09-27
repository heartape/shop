package com.heartape.shop.inventory;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 门店库存进出记录
 */
public class StoreInventoryRecord {

    private Long id;

    /**门店id*/
    private Long storeId;

    /**商品id*/
    private Long productId;

    /**库存调整类型（售卖、入库、库存调整）*/
    private Byte type;

    /**是否入库*/
    private Boolean isIn;

    /**库存数量*/
    private BigDecimal count;

    /**创建时间*/
    private LocalDateTime timestamp;

}
