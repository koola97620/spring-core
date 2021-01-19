package com.jdragon.springcore.order;

import static org.assertj.core.api.Assertions.assertThat;

import com.jdragon.springcore.member.Grade;
import com.jdragon.springcore.member.Member;
import com.jdragon.springcore.member.MemberService;
import com.jdragon.springcore.member.MemberServiceImpl;
import org.junit.jupiter.api.Test;

/**
 * @author choijaeyong on 2021/01/20.
 * @project spring-core
 * @description
 */
public class OrderServiceTest {

  MemberService memberService = new MemberServiceImpl();
  OrderService orderService = new OrderServiceImpl();

  @Test
  public void createOrder() {
    Long memberId = 1L;
    Member member = new Member(memberId, "memberA", Grade.VIP);
    memberService.join(member);

    Order order = orderService.createOrder(memberId, "itemA", 10000);
    assertThat(order.getDiscountPrice()).isEqualTo(1000);
  }

}
