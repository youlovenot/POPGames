package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;

public class AfterReturningAdvice {
	public void afterLog(JoinPoint jp, Object returnObj) {
		String method = jp.getSignature().getName();
		if(returnObj instanceof MemberVO)
		
		System.out.println("[사후 처리] 비즈니스 로직 수행 후 동작");
	}
}
