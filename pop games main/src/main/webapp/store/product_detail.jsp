<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="ko">
<head>
  <title>pop games</title>
  <script src="../js/jquery-3.2.1.min.js"></script>
  <script src="../js/index.js"></script>
  <link rel="shortcut icon" type="image⁄x-icon" href="../img/favicon.ico">
  <link href="../css/common.css" rel="stylesheet" type="text/css">
  <link href="../css/main.css" rel="stylesheet" type="text/css">
  
</head>
<body>
  <div id="container">
    <a name="top"></a>
    <%@ include file="header.jsp" %>
    <main>
      <div id="content">
        	<section id="right">
                <section id="summary">
                    <h3><span>product_detail</span> - goods</h3>
                    <section id="summary1">
                        <div class="image">
                            <img src="../img/goods/goods1.png">
                        </div>
                    </section>
                    <section id="summary2">
                        <h3>팝콘 키홀더</h3>
                        <div class="item">
                            <ul>
                                <li>
                                    <div class="col1">판매가</div>
                                    <div class="col2">8,900원</div>
                                    <div class="clear"></div>
                                </li>
                                <li>
                                    <div class="col1">배송방법</div>
                                    <div class="col2">택배</div>
                                    <div class="clear"></div>
                                </li>
                                <li>
                                    <div class="col1">배송비</div>
                                    <div class="col2">2,500 (10,000원이상 무료배송)</div>
                                    <div class="clear"></div>
                                </li>
                                <li>
                                    <div class="col1">수량</div>
                                    <div class="col2"><input type="text"></div>
                                    <div class="clear"></div>
                                </li>
                                <li>
                                    <div class="col1">옵션</div>
                                    <div class="col2">
                                        <select>
                                            <option>== 옵션 선택 ==</option>
                                            <option>색상 - 브라운</option>
                                            <option>색상 - 옐로우</option>
                                        </select>
                                    </div>
                                    <div class="clear"></div>
                                </li>
                            </ul>
                        </div>
                        <ul class="buttons">
                            <li><a href="cart.jsp"><img src="../img/cart.png"></a></li>
                            <li><a href="order.jsp"><img src="../img/order.png"></a></li>
                        </ul>
                    </section>
                    <div class="clear"></div>
                </section>
                <section id="explanation">
                    <h3>상품 설명</h3>
                    <div class="detail">
                        <img src="../img/goods/goods_ex1.png">
                        <img src="../img/goods/goods_ex2.png">
                        <img src="../img/goods/goods_ex3.png">
                        <img src="../img/goods/goods_ex4.png">
                        <img src="../img/goods/goods_ex5.png">
                    </div>
                </section>
                <section id="required">
                    <h3>유의 사항</h3>
                    <dl>
                        <dt> ○ 주문 전 참고 사항</dt>
                        <dd>- 본 제품은 어린이 제품이 아닙니다. 만 14세 이상 사용가능합니다.</dd>
                        <dd>- 제조국 : 중국</dd>
                        <dd>- 수입여부 : Y</dd>
                    </dl>
                    <dl>
                        <dt> ○ 배송 </dt>
                        <dd>- 배송 지역 : 전국</dd>
                        <dd>- 배송 비용 : 2,500원 (10,000원 이상 무료배송)</dd>
                        <dd>- 배송 기간 : 2~3일</dd>
                    </dl>
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