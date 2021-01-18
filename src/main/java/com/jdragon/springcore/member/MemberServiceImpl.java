package com.jdragon.springcore.member;

/**
 * @author choijaeyong on 2021/01/19.
 * @project spring-core
 * @description
 */
public class MemberServiceImpl implements MemberService {

  private final MemberRepository memberRepository = new MemoryMemberRepository();

  @Override
  public void join(Member member) {
    memberRepository.save(member);
  }

  @Override
  public Member findMember(Long memberId) {
    return memberRepository.findById(memberId);
  }
}
