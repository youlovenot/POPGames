<%@page import="com.springbook.biz.notice.impl.NoticeDAO"%>
<%@page import="com.springbook.biz.notice.NoticeVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	// 1. 사용자 입력 정보 추출
	request.setCharacterEncoding("UTF-8");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	
	// 2. DB 연동 처리
	NoticeVO vo = new NoticeVO();
	vo.setTitle(title);
	vo.setContent(content);
	
	NoticeDAO noticeDAO = new NoticeDAO();
	noticeDAO.insertNotice(vo);
	
	// 3. 화면 네비게이션
	response.sendRedirect("getNoticeList.jsp");
%>