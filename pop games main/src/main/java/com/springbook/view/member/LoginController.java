package com.springbook.view.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springbook.biz.member.MemberVO;
import com.springbook.biz.member.impl.MemberDAO;

@Controller
public class LoginController {
	
	@RequestMapping(value="/test/login.do", method=RequestMethod.GET)
	public String loginView(@ModelAttribute("member") MemberVO vo) {
		System.out.println("로그인 화면으로 이동");
		vo.setId("test");
		vo.setPassword("test123");
		return "login.jsp";
	}
	
	@RequestMapping(value="/test/login.do", method=RequestMethod.POST)
	public String login(MemberVO vo, MemberDAO memberDAO, HttpServletResponse response, HttpSession session) throws IOException {
		if(vo.getId()==null||vo.getId().equals("")) {
			throw new IllegalArgumentException("아이디는 반드시 입력해야 합니다.");
		}
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		MemberVO member = memberDAO.getMember(vo);
		System.out.println("로그인 인증 처리...");
		if(member != null) {
			session.setAttribute("memberName", member.getName());
			return "redirect:getNoticeList.do";
		}
		else {
			out.println("<script>alert('로그인 정보를 확인해주세요.');</script>");
			out.flush();
			return "login.jsp";
		}
	}
	
}
