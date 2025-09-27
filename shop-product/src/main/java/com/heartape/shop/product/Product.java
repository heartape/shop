package com.heartape.shop.product;

/**
 * 产品
 */
public class Product {

    private Long id;

    /**内部唯一编码*/
    private String code;

    private String name;

    /**主图*/
    private Picture picture;

    /**类型，比如定量、称重*/
    private Byte type;

    /**规格*/
    private Short specification;

    /**是否基本售卖单位*/
    private Boolean basic;

    /**是否停售*/
    private String removed;

}
