<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
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
		<input name="seq" type="hidden" value="${notice.seq }">
		<table>
			<tr>
				<td bgcolor="orange" width="70">제목</td>
				<td align="left"><input name="title" type="text"
										value="${ notice.title }"/></td>
			</tr>
			<tr>
				<td bgcolor="orange">내용</td>
				<td align="left"><textarea name="content" cols="40" rows="10">${ notice.content }</textarea></td>
			</tr>
			<tr>
				<td bgcolor="orange">등록일</td>
				<td align="left">${notice.regDate }</td>
			</tr>
			<tr>
				<td bgcolor="orange">조회수</td>
				<td align="left">${notice.cnt }</td>
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
	<a href="deleteNotice.do?seq=${notice.seq }">글삭제</a>&nbsp;&nbsp;&nbsp;
	<a href="getNoticeList.do">글목록</a>
</center>
</body>
</html>