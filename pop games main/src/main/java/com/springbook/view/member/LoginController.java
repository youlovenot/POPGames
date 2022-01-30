package com.springbook.view.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springbook.biz.member.MemberVO;
import com.springbook.biz.member.impl.MemberDAO;
import com.springbook.view.controller.Controller;

public class LoginController implements Controller{
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("로그인 처리");
		
		// 1. 사용자 입력 정보 추출
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		// 2. DB 연동 처리
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPassword(password);
		
		MemberDAO memberDAO = new MemberDAO();
		MemberVO member = memberDAO.getMember(vo);
		
		// 3. 화면 네비게이션
		if(member != null) {
			return "getNoticeList.do";
		} else {
			return "login";
		}
	}
	
}
