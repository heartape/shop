package com.heartape.shop.logistics;

import java.awt.geom.Point2D;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author heartape
 * 物流配送订单资源
 */
public interface LogisticsService {


    /**
     * 送货订单资源分配
     */
    int distribute(LogisticsResource logisticsResource);

    /**
     * 送货订单运费计算
     */
    BigDecimal cost(List<Point2D.Double> address);

    /**
     * 发车
     */
    int start(Long id);

    /**
     * 送达
     */
    int arrive(Long id);

    /**
     * 签收
     */
    int sign(Long id);

}
