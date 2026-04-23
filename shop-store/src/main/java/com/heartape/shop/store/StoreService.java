package com.heartape.shop.store;

import java.util.List;

/**
 * @author heartape
 * 门店配置服务
 */
public interface StoreService {

    int create(StoreCreateInfo storeCreateInfo);

    /**
     * 根据ID获取门店信息的方法
     * @param id 存储信息的唯一标识符
     * @return 返回与ID对应的存储信息对象
     */
    Store info(Long id);

    /**
     * 根据ID更新位置信息的方法
     * @param id 位置的唯一标识符，类型为Long
     * @param location 包含新位置信息的Location对象
     * @return 返回一个int值，通常表示操作影响的行数或状态码
     */
    int location(Long id, Location location);

    List<Store> list(Integer page, Integer size);


    /**
     * 根据名称分页查询商店列表
     *
     * @param name 商店名称，用于模糊查询
     * @param page 页码
     * @param size 每页记录数
     * @return 返回指定页码和大小的商店列表
     */
    List<Store> list(String name, Integer page, Integer size);


    /**
     * 根据管理者ID分页查询商店列表
     *
     * @param id 管理者ID，用于筛选管理者名下的门店
     * @param page 页码，用于分页查询
     * @param size 每页大小，用于控制每页返回的记录数
     * @return 返回符合条件的门店列表
     */
    List<Store> list(Long id, String name, Integer page, Integer size);

    /**
     * 根据管理者ID查询门店简单信息列表，用于门店切换
     *
     * @param id 管理者ID，用于筛选特定商店
     * @return 返回Store对象的列表，包含查询到的商店信息
     */
    List<Store> simples(Long id);
}
