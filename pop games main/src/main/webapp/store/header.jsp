<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="../css/header.css">
<link href="../css/common.css" rel="stylesheet" type="text/css">
 <script src="../js/jquery-3.2.1.min.js"></script>
 <script> 
    $(document).ready(function(){
      var height = $(".header_bottom").height();
      var num = $(".ul li").length;
      var max = height * num;
      var move = 0;
      function noticeRolling(){
        move += height;
        $(".ul").animate({"top":-move},500,function(){
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
<header>
      <div id="header">
        <div id="header_top">
          <div id="main_logo"><a href="../index.jsp"><img src="../img/main_logo.png"></a></div>
        <ul id="top_menu">
          <li><a href="goods.jsp">GOODS</a></li>
          <li><a href="board_game.jsp">BOARD GAME</a></li>
        </ul>
          <ul id="join_menu" class="navi">
            <li><a href="#" id="loginLabel">로그인</a>
            	<div class="loginbox">
                <form action="login.php" method="post">
                  <p>
                    <label for="logid">ID</label>
                    <input type="text" name="logid" id="logid" />
                  </p>
                  <p>
                    <label for="logpw">PW</label>
                    <input type="password" name="logpw" id="logpw" />
                  </p>
                  <p>
                    <input  class="loginBtn" type="image"  src="../img/loginBtn.png"/>
                  </p>
                  <p class="memberInfo">ID/PW 찾기 | 회원가입 </p>
                </form>
              </div>
            </li>
            <li><a href="cart.jsp">장바구니</a></li>
            <li><a href="#">구매내역</a></li>
          </ul>
        </div> 
        <script type="text/javascript" >
          (function($){
             
           //로그인 버튼	 
            $("#loginLabel").click(function(e) {     
              e.preventDefault();
              if($('.loginbox').css('display')== 'none'){				
                  $('.loginbox').slideDown(); 
              }
              else {
                            $('.loginbox').slideUp();
              }
            });
                   //닫힘버튼
            $(".closeBtn").click(function(e) {
             
                 $('.loginbox').slideUp();
            });				
          })(jQuery);
        </script>
      </div>
      <div class="header_bottom">
        <ul class="ul">
          <li><a href="notice.jsp"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;※공지사항&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 필독!! 설 연휴 배송 공지사항입니다.</a></li>
          <li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;※공지사항 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 배송지연 공지사항입니다.</li>
        </ul>
      </div>
    </header>