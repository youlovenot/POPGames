package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

import com.springbook.biz.member.MemberVO;



@Service
@Aspect

public class AfterReturningAdvice {
	
	@AfterReturning(pointcut = "PointcutCommon.getPointcut()", returning = "returnObj")
	public void afterLog(JoinPoint jp, Object returnObj) {
		String method = jp.getSignature().getName();
		
		if(returnObj instanceof MemberVO) {
			MemberVO member = (MemberVO) returnObj;
			if(member.getId().equals("admin")) {
				System.out.println(member.getName() + " 로그인(Admin)");
			}
		}
		
		System.out.println("[사후 처리] " + method +
				"() 메소드 리턴값 : " + returnObj.toString());
	}
}
