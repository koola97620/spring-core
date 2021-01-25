package com.jdragon.springcore;

import com.jdragon.springcore.discount.DiscountPolicy;
import com.jdragon.springcore.discount.FixDiscountPolicy;
import com.jdragon.springcore.discount.RateDiscountPolicy;
import com.jdragon.springcore.member.MemberRepository;
import com.jdragon.springcore.member.MemberService;
import com.jdragon.springcore.member.MemberServiceImpl;
import com.jdragon.springcore.member.MemoryMemberRepository;
import com.jdragon.springcore.order.OrderService;
import com.jdragon.springcore.order.OrderServiceImpl;

/**
 * @author choijaeyong on 2021/01/26.
 * @project spring-core
 * @description
 */
public class AppConfig {

  public MemberService memberService() {
    return new MemberServiceImpl(memberRepository());
  }

  private MemberRepository memberRepository() {
    return new MemoryMemberRepository();
  }

  public OrderService orderService() {
    return new OrderServiceImpl(memberRepository(), discountPolicy());
  }

  public DiscountPolicy discountPolicy() {
    return new RateDiscountPolicy();
    //return new FixDiscountPolicy();
  }

}
