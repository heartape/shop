package com.heartape.shop.logistics;

import java.util.List;

/**
 * @author heartape
 * 司机服务
 */
public interface DriverService {

    /**
     * 配送司机注册
     */
    int driver(Driver driver);

    /**
     * 配送司机签到
     * @param id 司机id
     */
    int driver(Long id);

    /**
     * 配送司机清单
     * @param warehouse 大仓id
     * @return 配送司机清单
     */
    List<Driver> drivers(Long warehouse);

    /**
     * 配送司机清单
     * @param warehouse 大仓id
     * @param status 司机状态
     * @return 配送司机清单
     */
    List<Driver> drivers(Long warehouse, Integer status);

    /**
     * 分配司机
     * @param id 司机id
     */
    int driver(Long id, Integer status);

    /**
     * 配送司机注销
     * @param id 司机id
     */
    int cancel(Long id);

}
