package com.heartape.shop.product;

import java.util.List;

/**
 * 产品
 */
public class ProductDetail {

    private Long id;

    /**
     * 商品id
     * {@link Product}
     */
    private Long productId;

    /**条形码*/
    private String barCode;

    /**详图*/
    private List<Picture> pictures;

}
