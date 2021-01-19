package com.jdragon.springcore.discount;


import com.jdragon.springcore.member.Member;

/**
 * @author choijaeyong on 2021/01/19.
 * @project spring-core
 * @description
 */
public interface DiscountPolicy {
  int discount(Member member, int price);

}
