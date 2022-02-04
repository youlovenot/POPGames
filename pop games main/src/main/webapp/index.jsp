<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="ko">
<head>
  <title>pop games</title>
  <script src="js/jquery-3.2.1.min.js"></script>
  <script src="js/index.js"></script>
  <link rel="shortcut icon" type="image⁄x-icon" href="img/favicon.ico">
  <link href="css/common.css" rel="stylesheet" type="text/css">
  <link href="css/main.css" rel="stylesheet" type="text/css">
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
  <!-- POPUP --> 
<div id="divpop" style="position:absolute;left:370px;top:50px;z-index:200;visibility:hidden;"> 
  <table> 
  <tr> 
      <td> 
      <img src="img/notice1.png">
      </td> 
  </tr> 
  <tr> 
      <form name="notice_form"> 
      <td align=right bgcolor=white style="font-size: 14px;"> 
          <input type="checkbox" name="chkbox" value="checkbox">오늘 하루 이 창을 열지 않음 
          <a href="javascript:closeWin();"><B>[닫기]</B></a> 
      </td> 
      </tr> 
      </form> 
  </table> 
  </div> 
  <script language="Javascript"> 
  cookiedata = document.cookie;    
  if ( cookiedata.indexOf("maindiv=done") < 0 ){      
      document.all['divpop'].style.visibility = "visible"; 
      } 
      else { 
          document.all['divpop'].style.visibility = "hidden"; 
  } 
  </script>
  <div id="container">
    <a name="top"></a>
    <%@ include file="header.jsp" %>
    <main>
      <div class="banner">
        <ul class="slider_container">
          <li class="slider"><img src="img/banner_4.png"></li>
          <li class="slider"><img src="img/banner_1.png"></li>
          <li class="slider"><img src="img/banner_2.png"></li>
          <li class="slider"><img src="img/banner_3.png"></li>
        </ul>
      </div>
      <a class="prev" onclick="plusSlides(-1, 0)">&lang;</a>
      <a class="next" onclick="plusSlides(1, 0)">&rang;</a>
		<ul class="section_name">
        <li class="title">GAME</li>
        <li><a id="more_items" href="store/gameList.jsp">
          <div class="plus">더보기 +</div>
        </a></li>
      </ul>

      <div id="panorama_items">
        <div class="item_box">
          <ul>
            <a href="store/game_detail.jsp">
              <li><img src="img/flashgame/루미큐브.jpg"></li>
              <li>루미큐브 </li>
              <li>장르 : 보드/경쟁</li>
            </a>
          </ul>
        </div>
        <div class="item_box">
          <ul>
            <a href="store/game_detail.jsp">
              <li><img src="img/flashgame/스네이크게임.jpg"></li>
              <li>스네이크게임</li>
              <li>장르 : 아케이드</li>
            </a>
          </ul>
        </div>
        <div class="item_box">
          <ul>
            <a href="store/game_detail.jsp">
              <li><img src="img/flashgame/루미큐브.jpg"></li>
              <li>루미큐브 </li>
              <li>장르 : 보드/경쟁</li>
            </a>
          </ul>
        </div>
        <div class="item_box">
          <ul>
            <a href="store/game_detail.jsp">
              <li><img src="img/flashgame/루미큐브.jpg"></li>
              <li>루미큐브 </li>
              <li>장르 : 보드/경쟁</li>
            </a>
          </ul>
        </div>
      </div>
      <div class="clear"></div>
      <ul class="section_name">
        <li class="title">GOODS SHOP</li>
        <li><a id="more_items" href="store/goods.jsp">
          <div class="plus">더보기 +</div>
        </a></li>
      </ul>

      <div id="panorama_items">
        <div class="item_box">
          <ul>
            <a href="store/product_detail.jsp">
              <li><img src="img/goods/goods1.png"></li>
              <li>팝콘 키홀더 </li>
              <li>8,900원</li>
            </a>
          </ul>
        </div>
        <div class="item_box">
          <ul>
            <a href="store/product_detail.jsp">
              <li><img src="img/goods/goods12.png"></li>
              <li>팝콘모양 오프너</li>
              <li>8,000원</li>
            </a>
          </ul>
        </div>
        <div class="item_box">
          <ul>
            <a href="store/product_detail.jsp">
              <li><img src="img/goods/goods13.png"></li>
              <li>팝콘 에어팟 케이스</li>
              <li>18,000원</li>
            </a>
          </ul>
        </div>
        <div class="item_box">
          <ul>
            <a href="store/product_detail.jsp">
              <li><img src="./img/goods/goods10.png"></li>
              <li>팝콘 포켓 패브릭 포스터</li>
              <li>24,000원</li>
            </a>
          </ul>
        </div>
      </div>
      <div class="clear"></div>
      <ul class="section_name">
        <li class="title">BOARD GAME SHOP</li>
        <li><a id="more_items" href="store/board_game.jsp">
          <div class="plus">더보기 +</div>
        </a></li>
      </ul>
      <div id="panorama_items">
        <div class="item_box">
          <ul>
            <a href="store/product_detail.jsp">
              <li><img src="img/boardgame/boardgame1.png"></li>
              <li>13일의 금요일 </li>
              <li>15,000원</li>
            </a>
          </ul>
        </div>
        <div class="item_box">
          <ul>
            <a href="store/product_detail.jsp">
              <li><img src="img/boardgame/boardgame2.png"></li>
              <li>할리갈리 카카오프렌즈</li>
              <li>24,000원</li>
            </a>
          </ul>
        </div>
        <div class="item_box">
          <ul>
            <a href="store/product_detail.jsp">
              <li><img src="img/boardgame/boardgame3.png"></li>
              <li>스플렌더</li>
              <li>43,000원</li>
            </a>
          </ul>
        </div>
        <div class="item_box">
          <ul>
            <a href="store/product_detail.jsp">
              <li><img src="img/boardgame/boardgame4.png"></li>
              <li>루미큐브 (타일주머니 증정)</li>
              <li>55,000원</li>
            </a>
          </ul>
        </div>
      </div>
      <div class="footer_banner"><img src="img/footer_banner1.png"></div>
      <a href=""></a>
    </main>
         
    <div class="clear"></div>
    <%@ include file="footer.jsp" %>
  </div>
</body>
</html>