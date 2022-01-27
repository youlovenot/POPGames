<%@page import="com.springbook.biz.notice.impl.NoticeDAO"%>
<%@page import="com.springbook.biz.notice.NoticeVO"%>
<%@page contentType="text/html; charset=UTF-8"%>

<%
	// 1. 사용자 입력 정보 추출
	String seq = request.getParameter("seq");

	// 2. DB 연동 처리
	NoticeVO vo = new NoticeVO();
	vo.setSeq(Integer.parseInt(seq));
	NoticeDAO noticeDAO = new NoticeDAO();
	noticeDAO.deleteNotice(vo);

	// 3. 화면 네비게이션
	response.sendRedirect("getNoticeList.jsp");
%>