package com.heartape.shop.store.employee;


import lombok.Getter;
import lombok.Setter;

/**
 * 用于存储门店用户信息
 * 包含用户的基本信息和个人资料
 */
@Getter
@Setter
public class StoreEmployeeCreateInfo {

    /**门店id*/
    private Long storeId;

    /**职位*/
    private Position position;

    /**姓名*/
    private String name;

    /**年龄*/
    private Integer age;

    /**性别*/
    private Boolean gender;

    /**手机号*/
    private String phone;

}
