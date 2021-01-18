package com.jdragon.springcore.member;

/**
 * @author choijaeyong on 2021/01/19.
 * @project spring-core
 * @description
 */
public interface MemberRepository {
  void save(Member member);
  Member findById(Long memberId);

}
