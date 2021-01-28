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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author choijaeyong on 2021/01/26.
 * @project spring-core
 * @description
 */

@Configuration
public class AppConfig {

  @Bean
  public MemberService memberService() {
    return new MemberServiceImpl(memberRepository());
  }

  @Bean
  public MemberRepository memberRepository() {
    return new MemoryMemberRepository();
  }

  @Bean
  public OrderService orderService() {
    return new OrderServiceImpl(memberRepository(), discountPolicy());
  }

  @Bean
  public DiscountPolicy discountPolicy() {
    return new RateDiscountPolicy();
    //return new FixDiscountPolicy();
  }

}
