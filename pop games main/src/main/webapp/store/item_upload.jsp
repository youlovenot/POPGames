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
          <li><a href="admin.html">회원관리</a></li>
          <li><a href="item_upload.html">상품등록</a></li>
          <li><a href="admin.html">상품조회</a></li>
          <li><a href="item_upload.html">게임등록</a></li>
          <li><a href="admin.html">게임조회</a></li>
        </ul>
        </div>
      </div>
    </header>
    <main class="main">
        <ul class="section">
            <li class="title_a">상품등록</li>
          </ul>
          <div id="content">
            <section id="main_top">
                  <section id="right">
                      <section id="summary1">
                          <div class="image">
                              <img src="../img/goods/goods1.png">
                              <button class="btn" id="btn_product_update">이미지 파일</button>
                          </div>
                      </section>
                      <section id="summary2">
                        <form action="/admin/product/update" method="post">
                          <table class="item_upload_table">
                            <tr>
                              <td class="title">상품명</td>                          </tr>
                          <tr>
                            <td><input name="productId" value="" readonly></td>
                          </tr>
                          <tr>
                            <td class="title">상품가격</td>
                        </tr>
                        <tr>
                          <td><input name="productId" value="" readonly></td>

                        </tr>
                        <tr>
                          <td class="title">재고</td>
                      </tr>
                      <tr>
                        <td><input name="productId" value="" readonly></td>

                      </tr>
                      <tr>
                        <td class="title">상품정보</td>
                    </tr>
                    <tr>
                      <td><input name="productId" value="" readonly></td>
                    </tr>
                    <tr>
                      <td class="title">상품등록일</td>
                  </tr>
                  <tr>
                    <td><input name="productId" value="" readonly></td>

                  </tr>
                  </table>
                          <div class="btns">
                            <button class="btn" id="btn_product_update">등록</button>
                            <button class="btn" id="btn_product_update">수정</button>
                            <button class="btn" id="btn_product_back">삭제</button>
                          </div>
                        </form>
                      </section>
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