package com.jdragon.springcore.order;

import com.jdragon.springcore.discount.DiscountPolicy;
import com.jdragon.springcore.discount.FixDiscountPolicy;
import com.jdragon.springcore.discount.RateDiscountPolicy;
import com.jdragon.springcore.member.Member;
import com.jdragon.springcore.member.MemberRepository;
import com.jdragon.springcore.member.MemoryMemberRepository;

/**
 * @author choijaeyong on 2021/01/19.
 * @project spring-core
 * @description
 */
public class OrderServiceImpl implements OrderService {

  private final MemberRepository memberRepository;
  private final DiscountPolicy discountPolicy;

  public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
    this.memberRepository = memberRepository;
    this.discountPolicy = discountPolicy;
  }

  @Override
  public Order createOrder(Long memberId, String itemName, int itemPrice) {

    Member member = memberRepository.findById(memberId);
    int discountPrice = discountPolicy.discount(member, itemPrice);

    return new Order(memberId,itemName,itemPrice,discountPrice);
  }
}
