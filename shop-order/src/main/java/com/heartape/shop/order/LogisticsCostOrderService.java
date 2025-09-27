package com.heartape.shop.order;

import java.util.List;

/**
 * @author heartape
 * 物流订单运费服务
 */
public interface LogisticsCostOrderService {

    /**
     * 创建运费订单
     */
    int create(LogisticsCostOrder logisticsCostOrder);

}
