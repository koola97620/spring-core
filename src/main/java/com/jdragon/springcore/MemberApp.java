package com.jdragon.springcore;

import com.jdragon.springcore.member.Grade;
import com.jdragon.springcore.member.Member;
import com.jdragon.springcore.member.MemberService;
import com.jdragon.springcore.member.MemberServiceImpl;

/**
 * @author choijaeyong on 2021/01/19.
 * @project spring-core
 * @description
 */
public class MemberApp {

  public static void main(String[] args) {
    MemberService memberService = new MemberServiceImpl();
    Member member = new Member(1L, "memberA", Grade.VIP);
    memberService.join(member);

    Member findMember = memberService.findMember(1L);
    System.out.println("new member = " + member.getName());
    System.out.println("find Member = " + findMember.getName());


  }

}
