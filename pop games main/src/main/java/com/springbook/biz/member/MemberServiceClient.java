package com.springbook.biz.member;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MemberServiceClient {

	public static void main(String[] args) {
		// 1. Spring 컨테이너를 구동한다.
		AbstractApplicationContext	container =
				new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. Spring 컨테이너로부터 MemberServiceImpl 객체를 Lookup한다.
		MemberService memberService = (MemberService) container.getBean("memberService");
		
		// 3. 로그인 기능 테스트
		MemberVO vo = new MemberVO();
		vo.setId("admin");
		vo.setPassword("admin1234");
		
		MemberVO member = memberService.getMember(vo);
		if(member != null) {
			System.out.println(member.getName() + "님 환영합니다.");
		} else {
			System.out.println("로그인 실패");
		}
		
		// 4. Spring 컨테이너 종료
		container.close();
	}
	
}
