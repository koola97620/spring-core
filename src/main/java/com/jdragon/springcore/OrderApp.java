package com.jdragon.springcore;

import com.jdragon.springcore.member.Grade;
import com.jdragon.springcore.member.Member;
import com.jdragon.springcore.member.MemberService;
import com.jdragon.springcore.member.MemberServiceImpl;
import com.jdragon.springcore.order.Order;
import com.jdragon.springcore.order.OrderService;
import com.jdragon.springcore.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author choijaeyong on 2021/01/20.
 * @project spring-core
 * @description
 */
public class OrderApp {

  public static void main(String[] args) {
//    AppConfig appConfig = new AppConfig();

    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
    MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
    OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

//    MemberService memberService = appConfig.memberService();
//    OrderService orderService = appConfig.orderService();
//    MemberService memberServic = new MemberServiceImpl(null);
//    OrderService orderService = new OrderServiceImpl(null,null);

    Long memberId = 1L;
    Member member = new Member(memberId, "memberA", Grade.VIP);
    memberService.join(member);

    Order order = orderService.createOrder(memberId, "itemA", 10000);
    System.out.println("order = " + order);
    System.out.println("order.calc : " + order.calculatePrice());

  }

}
