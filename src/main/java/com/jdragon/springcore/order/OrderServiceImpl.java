package com.jdragon.springcore.order;

import com.jdragon.springcore.discount.DiscountPolicy;
import com.jdragon.springcore.discount.FixDiscountPolicy;
import com.jdragon.springcore.member.Member;
import com.jdragon.springcore.member.MemberRepository;
import com.jdragon.springcore.member.MemoryMemberRepository;

/**
 * @author choijaeyong on 2021/01/19.
 * @project spring-core
 * @description
 */
public class OrderServiceImpl implements OrderService {

  private final MemberRepository memberRepository = new MemoryMemberRepository();
  private final DiscountPolicy discountPolicy = new FixDiscountPolicy();


  @Override
  public Order createOrder(Long memberId, String itemName, int itemPrice) {

    Member member = memberRepository.findById(memberId);
    int discountPrice = discountPolicy.discount(member, itemPrice);

    return new Order(memberId,itemName,itemPrice,discountPrice);
  }
}
