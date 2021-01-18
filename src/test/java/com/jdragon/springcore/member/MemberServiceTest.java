package com.jdragon.springcore.member;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * @author choijaeyong on 2021/01/19.
 * @project spring-core
 * @description
 */
public class MemberServiceTest {

  MemberService memberService = new MemberServiceImpl();
  @Test
  void join() {
    // given
    Member member = new Member(1L, "memberA", Grade.VIP);

    // when
    memberService.join(member);
    Member findMember = memberService.findMember(1L);

    // then
    assertThat(findMember).isEqualTo(member);

  }

}
