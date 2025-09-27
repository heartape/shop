package com.heartape.shop.payment;

import java.math.BigDecimal;

/**
 * @author heartape
 * 物流支付服务
 */
public interface LogisticsPaymentService {

    /**
     * 冻结资金
     * @param store 门店id
     * @param order 叫货订单id
     * @param fund 冻结资金金额
     */
    int freeze(Long store, Long order, BigDecimal fund);

    /**
     * 扣减资金
     * @param store 门店id
     * @param order 送货订单id
     * @param fund 扣减资金金额
     */
    int deduct(Long store, Long order, BigDecimal fund);

    /**
     * 退还资金
     * @param store 门店id
     * @param order 退货订单id
     * @param fund 退还资金金额
     */
    int refund(Long store, Long order, BigDecimal fund);

}
