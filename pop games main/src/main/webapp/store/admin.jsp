<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="ko">
<head>
  <title>pop games</title>
  <script src="../js/jquery-3.2.1.min.js"></script>
  <script src="../js/index.js"></script>
  <link rel="shortcut icon" type="image⁄x-icon" href="../img/favicon.ico">
  <link href="../css/common.css" rel="stylesheet" type="text/css">
  <link href="../css/admin.css" rel="stylesheet" type="text/css">
   <link href="../css/header.css" rel="stylesheet" type="text/css">
  
</head>
<body>
  <div id="container">
    <a name="top"></a>
     <header>
      <div id="header">
        <div id="header_top">
          <div id="main_logo"><a href="../index.jsp"><img src="../img/main_logo2.png"></a></div>
        <ul id="top_menu">
        <li><a href="#">로그아웃</a></li>
          <li><a href="admin.jsp">회원관리</a></li>
          <li><a href="item_upload.jsp">상품등록</a></li>
          <li><a href="admin.jsp">상품조회</a></li>
          <li><a href="item_upload.jsp">게임등록</a></li>
          <li><a href="admin.jsp">게임조회</a></li>
        </ul>
        </div>
      </div>
    </header>
    <main>
         <ul class="section">
            <li class="title_a">회원관리</li>
          </ul>
          <FORM method="post" name="msgsearch" action="admin.jsp">
            <TABLE class="search">
             <TR>
              <TD class="search_select"> 
               <SELECT name=stype >
                <OPTION value=1 >이름
                <OPTION value=2 >회원ID
               </SELECT>
              </TD>
              <TD class="search_select">
               <INPUT type=text size="17" name="sval" >
              </TD>
              <TD class="search_select"><a href="#" onClick="check();"><img src="../img/serach.gif"></A></TD>
             </TR>
            </TABLE>
            </FORM>
          <table class="table">
            <tr class="tr">
                <th>회원ID</th>
                <th>이름</th>
                <th>Email</th>
                <th>전화번호</th>
                <th>주소</th>
                <th>수정 및 삭제</th>
            </tr>
            <tr class="tr">
                <td>회원ID</td>
                <td>이름</td>
                <td>Email</td>
                <td>전화번호</td>
                <td>주소</td>
                <td>
                    <button>수정</button>
                    <button>삭제</button>
                </td>
            </tr>
            <tr class="tr">
                <td>회원ID</td>
                <td>이름</td>
                <td>Email</td>
                <td>전화번호</td>
                <td>주소</td>
                <td>
                    <button>수정</button>
                    <button>삭제</button>
                </td>
            </tr>
            <tr class="tr">
                <td>회원ID</td>
                <td>이름</td>
                <td>Email</td>
                <td>전화번호</td>
                <td>주소</td>
                <td>
                    <button>수정</button>
                    <button>삭제</button>
                </td>
            </tr>
            <tr class="tr">
                <td>회원ID</td>
                <td>이름</td>
                <td>Email</td>
                <td>전화번호</td>
                <td>주소</td>
                <td>
                    <button>수정</button>
                    <button>삭제</button>
                </td>
            </tr>
            <tr class="tr">
                <td>회원ID</td>
                <td>이름</td>
                <td>Email</td>
                <td>전화번호</td>
                <td>주소</td>
                <td>
                    <button>수정</button>
                    <button>삭제</button>
                </td>
            </tr>
            <tr class="tr">
                <td>회원ID</td>
                <td>이름</td>
                <td>Email</td>
                <td>전화번호</td>
                <td>주소</td>
                <td>
                    <button>수정</button>
                    <button>삭제</button>
                </td>
            </tr>
            <tr class="tr">
                <td>회원ID</td>
                <td>이름</td>
                <td>Email</td>
                <td>전화번호</td>
                <td>주소</td>
                <td>
                    <button>수정</button>
                    <button>삭제</button>
                </td>
            </tr>
            <tr class="tr">
                <td>회원ID</td>
                <td>이름</td>
                <td>Email</td>
                <td>전화번호</td>
                <td>주소</td>
                <td>
                    <button>수정</button>
                    <button>삭제</button>
                </td>
            </tr>
          </table>
    </main>
    <div class="clear"></div>
    <%@ include file="footer.jsp" %>
  </div>
</body>
</html>