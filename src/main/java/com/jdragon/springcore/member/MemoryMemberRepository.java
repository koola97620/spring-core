package com.jdragon.springcore.member;

import java.util.HashMap;
import java.util.Map;

/**
 * @author choijaeyong on 2021/01/19.
 * @project spring-core
 * @description
 */
public class MemoryMemberRepository implements MemberRepository {

  private Map<Long, Member> store = new HashMap<>();

  @Override
  public void save(Member member) {
    store.put(member.getId(), member);
  }

  @Override
  public Member findById(Long memberId) {
    return store.get(memberId);
  }
}
