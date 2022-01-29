<%@page import="com.springbook.biz.notice.NoticeVO"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<%
	// 세션에 저장된 글 목록을 꺼낸다.
	List<NoticeVO> noticeList = (List) session.getAttribute("noticeList");
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 목록</title>
</head>
<body>
<center>
	<h1>글 목록</h1>
	<h3>테스트님 환영합니다...<a href="logout.do">Log-out</a></h3>
	
	<!-- 검색 시작 -->
	<form action="getNoticeList.jsp" method="post">
	<table border="1" cellpadding="0" cellspacing="0" width="700">
		<tr>
			<td align="right">
				<select name="searchCondition">
				<option value="TITLE">제목
				<option value="CONTENT">내용
				</select>
				<input name="searchKeyword" type="text">
				<input type="submit" value="검색">
			</td>
		</tr>
	</table>
	</form>
	<!-- 검색 종료 -->
	
	<table border="1" cellpadding="0" cellspacing="0" width="700">
		<tr>
			<th bgcolor="orange" width="100">번호</th>
			<th bgcolor="orange" width="200">제목</th>
			<th bgcolor="orange" width="150">등록일</th>
			<th bgcolor="orange" width="100">조회수</th>
		</tr>
		
		<% for(NoticeVO notice : noticeList) { %>
		<tr>
			<td><%= notice.getSeq() %></td>
			<td align="left"><a href="getNotice.do?seq=<%=notice.getSeq()%>">
						<%= notice.getTitle() %></a></td>
			<td><%= notice.getRegDate() %></td>
			<td><%= notice.getCnt() %></td>
		</tr>
		<% } %>
	</table>
	<br>
	<a href="insertNotice.jsp">새글 등록</a>
</center>
</body>
</html>