package com.heartape.shop.member;

/**
 * @author heartape
 * 会员
 */
public interface MemberRepository {

    int insert(Member member);

    Member select(Long id);

    int update(Member member);

    int delete(Long id);
}
