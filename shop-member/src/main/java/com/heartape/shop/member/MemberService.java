package com.heartape.shop.member;

import java.math.BigDecimal;

/**
 * @author heartape
 * 会员服务
 */
public interface MemberService {

    /**
     * 创建
     * @param member 会员
     */
    int member(Member member);

    /**
     * 查询会员信息
     * @param id 主键
     * @return 积分数
     */
    Member info(Long id);

    /**
     * 重命名
     * @param username 用户名
     */
    int rename(Long id, String username);

    /**
     * 注销会员
     * @param id 请求者id
     */
    int cancel(Long id);

    /**
     * 修改积分
     * @param id 主键
     * @param point 积分数
     */
    int point(Long id, Integer point);

    /**
     * 扣减储值同时未录入会员
     * @param id 储值账户主键
     * @param amount 金额
     */
    int point(Long id, BigDecimal amount);

    /**
     * 扣减储值同时增加积分
     * @param id 储值账户主键
     * @param amount 金额
     * @param point 积分数
     */
    int point(Long id, BigDecimal amount, Integer point);

    /**
     * 扣减储值同时增加积分
     * @param idAmount 储值账户主键
     * @param amount 金额
     * @param idPoint 会员积分主键
     * @param point 积分数
     */
    int point(Long idAmount, BigDecimal amount, Long idPoint, Integer point);

}
