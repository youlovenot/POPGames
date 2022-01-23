<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="ko">
<head>
  <title>pop games</title>
  <script src="../js/jquery-3.2.1.min.js"></script>
  <script src="../js/index.js"></script>
  <link rel="shortcut icon" type="image⁄x-icon" href="../img/favicon.ico">
  <link href="../css/common.css" rel="stylesheet" type="text/css">
  <link href="../css/notice.css" rel="stylesheet" type="text/css">
  
</head>
<body>
  <div id="container">
    <a name="top"></a>
    <%@ include file="header.jsp" %>
    <main>
       <ul class="section_name">
        <li class="title">설 명절 배송일정 공지사항</li>
      </ul>
      <div class="notice">
        <img src="../img/notice2.png">
      </div>
      <ul id="notice_ex">
        <li>CJ 대한통운 파업으로 인한 배송지연이 있을 수 있습니다. </li>
        <li>일부 지역의 경우 배송 불가 지역이 있을 수 있으니</li>
        <li>고객센터로 문의 주시기 바랍니다.<br>감사합니다.</li>
      </ul>
    </main>
    <div class="clear"></div>
    <%@ include file="footer.jsp" %>
  </div>
</body>
</html>