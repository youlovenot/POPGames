<%@page import="com.springbook.biz.notice.impl.NoticeDAO"%>
<%@page import="com.springbook.biz.notice.NoticeVO"%>
<%@page contentType="text/html; charset=UTF-8"%>

<%
	// 1. 사용자 입력 정보 추출
	request.setCharacterEncoding("UTF-8");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	String seq = request.getParameter("seq");

	// 2. DB 연동 처리
	NoticeVO vo = new NoticeVO();
	vo.setTitle(title);
	vo.setContent(content);
	vo.setSeq(Integer.parseInt(seq));
	NoticeDAO noticeDAO = new NoticeDAO();
	noticeDAO.updateNotice(vo);

	// 3. 화면 네비게이션
	response.sendRedirect("getNoticeList.jsp");
%>