<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 목록</title>
</head>
<body>
<center>
	<h1>글 목록</h1>
	<h3>${memberName }님! 환영합니다...<a href="logout.do">Log-out</a></h3>
	
	<!-- 검색 시작 -->
	<form action="getNoticeList.do" method="post">
	<table border="1" cellpadding="0" cellspacing="0" width="700">
		<tr>
			<td align="right">
				<select name="searchCondition">
				<c:forEach items="${conditionMap }" var="option">
					<option value="${option.value }">${option.key }
				</c:forEach>
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
		
		<c:forEach items="${noticeList }" var="notice">
		<tr>
			<td>${notice.seq }</td>
			<td align="left"><a href="getNotice.do?seq=${notice.seq }">
						${notice.title }</a></td>
			<td><fmt:formatDate value="${notice.regDate}" pattern="yyyy-MM-dd"/></td>
			<td>${notice.cnt }</td>
		</tr>
		</c:forEach>
	</table>
	<br>
	<a href="insertNotice.jsp">새글 등록</a>
</center>
</body>
</html>