<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="ko">
<head>
  <title>pop games</title>
  <script src="js/jquery-3.2.1.min.js"></script>
  <script src="js/index.js"></script>
  <link rel="shortcut icon" type="image⁄x-icon" href="img/favicon.ico">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
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
<div id="divpop" style="position:absolute;left:580px;top:50px;z-index:200;visibility:hidden;"> 
  <table> 
  <tr> 
      <td> 
      <img src="img/notice1.png">
      </td> 
  </tr> 
  <tr> 
      <form name="notice_form"> 
      <td align=right bgcolor=white style="font-size: 20px;"> 
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
        <li class="title">GOODS</li>
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
        <li class="title">BOARD GAME</li>
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
          <!-- Modal -->

  <div class="modal fade" id="myModal" role="dialog"> <!-- 사용자 지정 부분① : id명 -->

    <div class="modal-dialog">
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <div class="card align-middle" style="width:25rem; border-radius:20px;">
            <div class="card-title" style="margin-top:30px;">
              <h2 class="card-title text-center" style="color:#113366;">로그인 </h2>
            </div>
            <div class="card-body">
              <form class="form-signin" method="POST" onSubmit="logincall();return false">
                <h5 class="form-signin-heading">로그인 정보를 입력하세요</h5>
                <label for="inputEmail" class="sr-only">Your ID</label>
                <input type="text" id="uid" class="form-control" placeholder="Your ID" required autofocus><BR>
                <label for="inputPassword" class="sr-only">Password</label>
                <input type="password" id="upw" class="form-control" placeholder="Password" required><br>
                <div class="checkbox">
                  <label>
                    <input type="checkbox" value="remember-me"> 기억하기
                  </label>
                </div>
                <button id="btn-Yes" class="btn btn-lg btn-primary btn-block" type="submit">로 그 인</button>
              </form>
              
            </div>
          </div>
        
          <div class="modal">
          </div>
            <!-- Optional JavaScript -->
            <!-- jQuery first, then Popper.js, then Bootstrap JS -->
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script> 
        </div>
      </div>
    </div>
  </div>
    <div class="clear"></div>
    <%@ include file="footer.jsp" %>
  </div>
</body>
</html>