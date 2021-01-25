package com.jdragon.springcore.discount;

import com.jdragon.springcore.member.Grade;
import com.jdragon.springcore.member.Member;

/**
 * @author choijaeyong on 2021/01/26.
 * @project spring-core
 * @description
 */
public class RateDiscountPolicy implements DiscountPolicy {

  private int discountPercent = 10;

  @Override
  public int discount(Member member, int price) {
    if (member.getGrade() == Grade.VIP) {
      return price * discountPercent / 100;
    } else {
      return 0;
    }

  }
}
