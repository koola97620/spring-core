package com.jdragon.springcore.beanfind;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.jdragon.springcore.AppConfig;
import com.jdragon.springcore.member.MemberService;
import com.jdragon.springcore.member.MemberServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author choijaeyong on 2021/01/29.
 * @project spring-core
 * @description
 */
class ApplicationContextBasicFindTest {
  AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
  
  @Test
  @DisplayName("빈 이름으로 조회")
  void findBeanByName() {
    MemberService memberService = ac.getBean("memberService", MemberService.class);
    System.out.println("memberService = " + memberService);
    System.out.println("memberService.getClass() = " + memberService.getClass());
    assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
  }

  @Test
  @DisplayName("빈 이름없이 타입으로 조회")
  void findBeanByType() {
    MemberService memberService = ac.getBean(MemberService.class);
    assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
  }

  @Test
  @DisplayName("구체 타입으로 조회")
  void findBeanByName2() {
    // 구현에 의존했기 때문에 좋은 코드는 아니다.
    // 역할(MemberService)에 의존하자.
    MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);
    System.out.println("memberService = " + memberService);
    System.out.println("memberService.getClass() = " + memberService.getClass());
    assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
  }

  @Test
  @DisplayName("빈 이름으로 조회 x")
  void findBeanByNameX() {
    // ac.getBean("xxxx", MemberService.class);
    assertThatThrownBy(() -> ac.getBean("xxxx", MemberService.class));
  }

}
