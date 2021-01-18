package com.jdragon.springcore.member;

/**
 * @author choijaeyong on 2021/01/19.
 * @project spring-core
 * @description
 */
public interface MemberService {
  void join(Member member);
  Member findMember(Long memberId);

}
