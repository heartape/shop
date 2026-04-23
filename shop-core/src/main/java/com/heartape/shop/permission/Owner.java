package com.heartape.shop.permission;

/**
 * Owner接口，定义了所有者应具备的基本行为
 * 该接口主要用于标识系统中的所有者对象
 */
public interface Owner {

    /**
     * 获取所有者的标志
     * @return 所有者的标志字符串
     */
    String flag();

    /**
     * 获取用户id的方法
     * @return 用户id
     */
    Long getId();

}
