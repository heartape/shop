package com.heartape.shop.store.employee;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * 用于存储门店用户信息
 * 包含用户的基本信息和个人资料
 */
@Getter
@Setter
@Builder
public class StoreEmployee {

    private Long id;

    /**用户id*/
    private String uid;

    /**门店id*/
    private Long storeId;

    /**职位*/
    private Position position;

    /**姓名*/
    private String name;

    /**年龄*/
    private Integer age;

    /**手机号*/
    private String phone;

    /**邮箱*/
    private String email;

    /**头像*/
    private String avatar;

    /**状态*/
    private Integer status;
}
