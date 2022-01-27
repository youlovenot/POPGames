<%@page import="com.springbook.biz.member.impl.MemberDAO"%>
<%@page import="com.springbook.biz.member.impl.MemberDAO_copy"%>
<%@page import="com.springbook.biz.member.MemberVO"%>
<%@page contentType="text/html; charset=UTF-8" %>

<%
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
	if(member != null){
		response.sendRedirect("getNoticeList.jsp");
	} else {
		response.sendRedirect("login.jsp");
	}
%>