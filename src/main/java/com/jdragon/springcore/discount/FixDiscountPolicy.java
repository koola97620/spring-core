package com.jdragon.springcore.discount;

import com.jdragon.springcore.member.Grade;
import com.jdragon.springcore.member.Member;

/**
 * @author choijaeyong on 2021/01/19.
 * @project spring-core
 * @description
 */
public class FixDiscountPolicy implements DiscountPolicy {

  private int discountFixAmount = 1000;

  @Override
  public int discount(Member member, int price) {
    if (member.getGrade() == Grade.VIP) {
      return discountFixAmount;
    } else {
      return 0;
    }
  }
}
