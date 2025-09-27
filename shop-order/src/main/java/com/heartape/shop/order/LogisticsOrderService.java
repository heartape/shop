package com.heartape.shop.order;

import java.util.List;

/**
 * @author heartape
 * 物流订单服务
 */
public interface LogisticsOrderService {

    /**
     * 暂存叫货订单
     * @param storePurchaseOrder 物流叫货订单
     */
    Long save(StorePurchaseOrder storePurchaseOrder);

    /**
     * 门店叫货订单列表
     * @param store 门店id
     * @param status 订单状态
     */
    List<SimpleStorePurchaseOrder> purchaseOrders(Long store, Integer status);

    /**
     * 门店叫货订单
     * @param id 门店叫货订单id
     */
    StorePurchaseOrder purchaseOrder(Long id);

    /**
     * 提交叫货订单
     * @param storePurchaseOrder 物流叫货订单
     */
    int purchase(StorePurchaseOrder storePurchaseOrder);

    /**
     * 叫货订单分仓
     * @param store 门店id
     */
    int distribute(Long store);

    /**
     * 查找预分配送货订单
     * @param store 门店id
     * @param warehouse 大仓id
     */
    List<WarehouseDistributionOrder> preDistribution(Long store, Long warehouse);

    /**
     * 查找配货订单
     * @param store 门店id
     * @param warehouse 大仓id
     * @param status 配货订单状态
     */
    List<WarehouseDistributionOrder> distribution(Long store, Long warehouse, Integer status);

    /**
     * 提交配货订单
     * @param warehouseDistributionOrder 送货订单
     */
    int distribution(WarehouseDistributionOrder warehouseDistributionOrder);

    /**
     * 配货订单列表
     * @param warehouse 大仓id
     * @param status 订单状态
     */
    List<SimpleWarehouseDistributionOrder> deliveryOrders(Long warehouse, Integer status);

    /**
     * 配货订单列表
     * @param warehouse 大仓id
     * @param driver 司机id
     * @param status 订单状态
     */
    List<SimpleWarehouseDistributionOrder> deliveryOrders(Long warehouse, Long driver, Integer status);

    /**
     * 配货订单
     * @param id 配货订单id
     */
    WarehouseDistributionOrder deliveryOrder(Long id);

    /**
     * 创建物流配送订单
     */
    int logistics(LogisticsOrder logisticsOrder);

    /**
     * 装车
     * @param id 物流配送订单id
     */
    int load(Long id, Long warehouseDistributionOrder);

    /**
     * 发车
     * @param id 物流配送订单id
     */
    int start(Long id);

    /**
     * 送达
     * @param id 物流配送订单id
     */
    int arrive(Long id);

    /**
     * 签收
     * @param id 物流配送订单id
     */
    int sign(Long id);

    /**
     * 提交退货订单
     * @param refundLogisticsOrder 退货订单
     */
    int refund(RefundLogisticsOrder refundLogisticsOrder);

    /**
     * 审核退货订单
     * @param id 退货订单id
     * @param result 结果
     * @param message 信息
     */
    RefundLogisticsOrder refund(Long id, Integer result, String message);

}
