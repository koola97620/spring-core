package com.jdragon.springcore.discount;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.jdragon.springcore.member.Grade;
import com.jdragon.springcore.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author choijaeyong on 2021/01/26.
 * @project spring-core
 * @description
 */
class RateDiscountPolicyTest {
  RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

  @Test
  @DisplayName("VIP는 10%할인이 적용되어야 한다.")
  void vip_o() {
    //given
    Member member = new Member(1L, "memberVip", Grade.VIP);
    //when
    int discount = discountPolicy.discount(member, 10000);
    //then
    assertThat(discount).isEqualTo(1000);
  }

  @Test
  @DisplayName("VIP 가 아니면 할인이 적용되지 않아야 한다")
  void vip_x() {
    //given
    Member member = new Member(1L, "memberBASIC", Grade.BASIC);
    //when
    int discount = discountPolicy.discount(member, 10000);
    //then
    assertThat(discount).isEqualTo(0);

  }

}