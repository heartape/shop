package com.heartape.shop.member;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author heartape
 * 会员
 */
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    private Long id;

    /**会员姓名*/
    private String username;

    /**手机号*/
    private String phone;

    /**会员积分*/
    private Integer point;

    /**会员储值*/
    private BigDecimal value;

}
