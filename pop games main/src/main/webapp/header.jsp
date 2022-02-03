<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" type="text/css" href="css/header.css">
<link href="css/common.css" rel="stylesheet" type="text/css">
 <script src="js/jquery-3.2.1.min.js"></script>
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
          <div id="main_logo"><a href="index.jsp"><img src="img/main_logo2.png"></a></div>
        <ul id="top_menu">
          <li><a href="store/gameList.jsp">GAME</a></li>
          <li><a href="store/goods.jsp">GOODS SHOP</a></li>
          <li><a href="store/board_game.jsp">BOARD GAME SHOP</a></li>
          
        </ul>
          <ul id="join_menu" class="navi">
          <c:if test="${member == null }">    <!-- 로그인 X -->
            <li><a href="store/login.jsp">로그인</a></li>
            <li><a href="store/cart.jsp">장바구니</a></li>
            <li><a href="#">구매내역</a></li>
           </c:if>
           <c:if test="${member != null }">
	           <c:if test="${id == admin }">
	           		<li><a href="store/admin.jsp">관리자페이지</a></li>
	           </c:if>
           	<li><a href="store/login.jsp">로그아웃</a></li>
            <li><a href="store/cart.jsp">장바구니</a></li>
            <li><a href="#">구매내역</a></li>
           </c:if>
           
          </ul>
          
        </div> 
      </div>
      <div class="header_bottom">
        <ul class="ul">
          <li><a href="store/notice.jsp"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;※공지사항&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 필독!! 설 연휴 배송 공지사항입니다.</a></li>
          <li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;※공지사항 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 배송지연 공지사항입니다.</li>
        </ul>
      </div>
    </header>