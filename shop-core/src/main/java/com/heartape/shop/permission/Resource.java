package com.heartape.shop.permission;

/**
 * 资源接口，定义了资源的基本操作
 * 该接口提供了获取资源ID和资源所有者信息的方法
 */
public interface Resource {

    /**
     * 获取资源的标志
     * @return 资源的标志字符串
     */
    String flag();

    /**
     * 获取资源id
     * @return id
     */
    Long getId();



}
