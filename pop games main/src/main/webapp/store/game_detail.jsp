<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="ko">
<head>
  <title>pop games</title>
  <script src="../js/jquery-3.2.1.min.js"></script>
  <script src="../js/index.js"></script>
  <link rel="shortcut icon" type="image⁄x-icon" href="../img/favicon.ico">
  <link href="../css/common.css" rel="stylesheet" type="text/css">
  <link href="../css/goods.css" rel="stylesheet" type="text/css">
  
</head>
<body>
  <div id="container">
    <a name="top"></a>
    <%@ include file="header.jsp" %>
    <main>
       <div id="content">
        	<section id="right">
                <section id="summary">
                    <h3><span>Game</span></h3>
                    <section id="summary1">
                        <div class="image">
                            <img src="../img/flashgame/루미큐브.jfif">
                        </div>
                    </section>
                    <section id="summary2">
                        <h3>루미큐브</h3>
                        <div class="item">
                            <ul>
                                <li>
                                    <div class="col1">게임인원</div>
                                    <div class="col2">2~4명</div>
                                    <div class="clear"></div>
                                </li>
                                <li>
                                    <div class="col1">게임연령</div>
                                    <div class="col2">8세이상</div>
                                    <div class="clear"></div>
                                </li>
                                <li>
                                    <div class="col1">게임시간</div>
                                    <div class="col2">약 20분 내외</div>
                                    <div class="clear"></div>
                                </li>
                            </ul>
                        </div>
                        <ul class="buttons">
                            <li><a href="#"><img src="../img/flashgame/start.png"></a></li>
                        </ul>
                    </section>
                    <div class="clear"></div>
                </section>
                <section id="explanation">
                    <h3>상품 설명</h3>
                    <div class="detail">
                        <img src="../img/flashgame/ex1.jpg">
                        <img src="../img/flashgame/ex2.jfif">
                        <img src="../img/flashgame/ex3.jfif">
                        <img src="../img/flashgame/ex4.png">
                        <img src="../img/flashgame/ex5.png">
                        <img src="../img/flashgame/ex6.png">
                    </div>
                </section>
            </section>
            <div class="clear"></div> 
        </div> 
    </main>
    <div class="clear"></div>
    <%@ include file="footer.jsp" %>
  </div>
</body>
</html>