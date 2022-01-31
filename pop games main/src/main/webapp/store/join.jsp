<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="ko">
<head>
  <title>pop games</title>
  <script src="js/jquery-3.2.1.min.js"></script>
  <script src="js/index.js"></script>
  <link rel="shortcut icon" type="image⁄x-icon" href="../img/favicon.ico">
  <link href="../css/common.css" rel="stylesheet" type="text/css">
  <link href="../css/join.css" rel="stylesheet" type="text/css">
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
        <li class="title">회원가입</li>
      </ul>
<!-- wrapper -->
<div id="wrapper">
    <!-- content-->
    <div id="content">
        <!-- ID -->
        <div>
            <h3 class="join_title">
                <label for="id">아이디</label>
            </h3>
            <span class="box int_id">
                <input type="text" id="id" class="int" maxlength="20">
            </span>
            <span class="error_next_box"></span>
        </div>
        <!-- PW1 -->
        <div>
            <h3 class="join_title"><label for="pswd1">비밀번호</label></h3>
            <span class="box int_pass">
                <input type="text" id="pswd1" class="int" maxlength="20">
                <span id="alertTxt">사용불가</span>
                <img src="../img/m_icon_pass.png" id="pswd1_img1" class="pswdImg">
            </span>
            <span class="error_next_box"></span>
        </div>
        <!-- PW2 -->
        <div>
            <h3 class="join_title"><label for="pswd2">비밀번호 재확인</label></h3>
            <span class="box int_pass_check">
                <input type="text" id="pswd2" class="int" maxlength="20">
                <img src="../img/m_icon_check_disable.png" id="pswd2_img1" class="pswdImg">
            </span>
            <span class="error_next_box"></span>
        </div>
        <!-- NAME -->
        <div>
            <h3 class="join_title"><label for="name">이름</label></h3>
            <span class="box int_name">
                <input type="text" id="name" class="int" maxlength="20">
            </span>
            <span class="error_next_box"></span>
        </div>
        <!-- EMAIL -->
        <div>
            <h3 class="join_title"><label for="email">이메일</label></h3>
            <span class="box int_email">
                <input type="text" id="email" class="int" maxlength="100">
            </span>
            <span class="error_next_box">이메일 주소를 다시 확인해주세요.</span>    
        </div>
        <!--Address-->
        <div>
            <h3 class="join_title"><label for="address">주소</label></h3>
            <span class="s_box int_address">
                <input type="text" id="zipcode">-<input type="text" id="zipcode" >
                <button>우편번호검색</button>
            </span> 
            <span class="box int_address">
                <input type="text" id="email" class="int" maxlength="100">
            </span>  
            <span class="box int_address">
                <input type="text" id="email" class="int" maxlength="100" placeholder="나머지주소">
            </span> 
        </div>
        <!-- MOBILE -->
        <div>
            <h3 class="join_title"><label for="phoneNo">휴대전화</label></h3>
            <span class="box int_mobile">
                <input type="tel" id="mobile" class="int" maxlength="16" placeholder="전화번호 입력">
            </span>
            <span class="error_next_box"></span>    
        </div>
        <!-- JOIN BTN-->
        <div class="btn_area">
            <button type="button" id="btnJoin">
                <span>가입하기</span>
            </button>
        </div>
    </div> 
    <!-- content-->
</div> 
<!-- wrapper -->
    </main>
  </div>
</body>
</html>