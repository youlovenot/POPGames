<%@page import="com.springbook.biz.notice.impl.NoticeDAO"%>
<%@page import="com.springbook.biz.notice.NoticeVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	// 세션에 저장된 글 목록을 꺼낸다.
	NoticeVO notice = (NoticeVO) session.getAttribute("notice");
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세</title>
</head>
<body>
<center>
	<h1>글 상세</h1>
	<a href="logout_proc.jsp">Log-out</a>
	<hr>
	<form action="updateNotice.do" method="post">
		<input name="seq" type="hidden" value="<%= notice.getSeq() %>">
		<table>
			<tr>
				<td bgcolor="orange" width="70">제목</td>
				<td align="left"><input name="title" type="text"
										value="<%= notice.getTitle() %>"/></td>
			</tr>
			<tr>
				<td bgcolor="orange">내용</td>
				<td align="left"><textarea name="content" cols="40" rows="10"><%= notice.getContent() %></textarea></td>
			</tr>
			<tr>
				<td bgcolor="orange">등록일</td>
				<td align="left"><%= notice.getRegDate() %></td>
			</tr>
			<tr>
				<td bgcolor="orange">조회수</td>
				<td align="left"><%= notice.getCnt() %></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="글 수정">
				</td>
			</tr>
		</table>
	</form>
	<hr>
	<a href="insertNotice.jsp">글등록</a>&nbsp;&nbsp;&nbsp;
	<a href="deleteNotice.do?seq=<%= notice.getSeq() %>">글삭제</a>&nbsp;&nbsp;&nbsp;
	<a href="getNoticeList.do">글목록</a>
</center>
</body>
</html>