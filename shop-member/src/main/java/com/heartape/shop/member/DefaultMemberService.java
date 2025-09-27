package com.heartape.shop.member;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
public class DefaultMemberService implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public int member(Member member) {
        return this.memberRepository.insert(member);
    }

    @Override
    public Member info(Long id) {
        return this.memberRepository.select(id);
    }

    @Override
    public int rename(Long id, String username) {
        Member member = new Member();
        member.setId(id);
        member.setUsername(username);
        return this.memberRepository.update(member);
    }

    @Override
    public int cancel(Long id) {
        return this.memberRepository.delete(id);
    }

    @Override
    public int point(Long id, Integer point) {
        Member member = new Member();
        member.setId(id);
        member.setPoint(point);
        return this.memberRepository.update(member);
    }

    @Override
    public int point(Long id, BigDecimal amount) {
        Member member = new Member();
        member.setId(id);
        member.setValue(amount);
        return this.memberRepository.update(member);

    }

    @Override
    public int point(Long id, BigDecimal amount, Integer point) {
        Member member = new Member();
        member.setId(id);
        member.setValue(amount);
        member.setPoint(point);
        return this.memberRepository.update(member);
    }

    /**
     * 须开启事务
     */
    @Override
    public int point(Long idAmount, BigDecimal amount, Long idPoint, Integer point) {
        Member memberAmount = new Member();
        memberAmount.setId(idAmount);
        memberAmount.setValue(amount);
        Member memberPoint = new Member();
        memberPoint.setId(idPoint);
        memberPoint.setPoint(point);
        int updateAmount = this.memberRepository.update(memberAmount);
        if (updateAmount == 0) {
            return 0;
        }
        return this.memberRepository.update(memberPoint);
    }
}
