<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="ko">
<head>
  <title>pop games</title>
  <script src="js/jquery-3.2.1.min.js"></script>
  <script src="js/index.js"></script>
  <link rel="shortcut icon" type="image⁄x-icon" href="../img/favicon.ico">
  <script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
  <link href="../css/common.css" rel="stylesheet" type="text/css">
  <link href="../css/find_id.css" rel="stylesheet" type="text/css">
  <script> 
    $(document).ready(function(){
      var height = $(".header_bottom").height();
      var num = $(".ul li").length; 
      var max = height * num;
      var move = 0;
      function noticeRolling(){
        move += height;
        $(".ul").animate({"top":-move},1000,function(){
          if(move >= max){
            $(this).css("top",0);
            move = 0;
          };
    
        });
      };
      noticeRollingOff = setInterval(noticeRolling,2000);
      $(".ul").append($(".ul li").first().clone());
    
    });
    </script>
</head>
<body>
  
  <div id="container">
    <a name="top"></a>
    <%@ include file="header.jsp" %>
    <main class="main">
      <ul class="section_name">
        <li class="title">ID/PW 찾기</li>
      </ul>
      <div id="wrapper">
        <!-- content-->
        <div id="content">
            <!-- ID -->
            <div>
                <span class="box int_id">
                    <input type="text" id="id" class="int" maxlength="20" placeholder="이름">
                </span>
                <span class="error_next_box"></span>
            </div>
            <!-- PW1 -->
            <div>
                <span class="box int_pass">
                    <input type="text" id="pswd1" class="int" maxlength="20" placeholder="이메일주소">
                </span>
                <span class="error_next_box"></span>
            </div>
            
            <!-- JOIN BTN-->
            <div class="btn_area">
                <button type="button" id="btnJoin">
                    <span>ID/PW 찾기</span>
                </button>
            </div>
            <ul class="find_wrap" id="find_wrap">
                <li class="go_login"><a target="_blank" href="login.jsp" class="go_login">로그인 하러가기</a>
                </li>
    
            </ul>
        </div> 
        <!-- content-->
    </div> 
    </main>
  </div>
</body>
</html>