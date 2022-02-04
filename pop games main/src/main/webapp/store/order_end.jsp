<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="ko">
<head>
  <title>pop games</title>
  <script src="../js/jquery-3.2.1.min.js"></script>
  <script src="../js/index.js"></script>
  <link rel="shortcut icon" type="image⁄x-icon" href="../img/favicon.ico">
  <link href="../css/common.css" rel="stylesheet" type="text/css">
  <link href="../css/cart.css" rel="stylesheet" type="text/css">
  <link href="../css/order.css" rel="stylesheet" type="text/css">
  
</head>
<body>
  <div id="container">
    <a name="top"></a>
    <%@ include file="header.jsp" %>
    <main>
         <div id="content">
        	<section id="right">
                <div class="cart_top">
                   <h2 id="cart_title"> 주문완료</h2>
                   <h2 id="process"> 01 장바구니 &rang; 02 주문서 작성/결제 &rang; <span>03 주문완료</span></h2>
            </div>
            <div class="order_end"><img src="../img/order_su.png"></div>
            <div class="order_zone_tit">
                <h4>주문요약정보</h4>
            </div>

            <div class="order_table_type">
                <table class="table_left">
                    <colgroup>
                        <col style="width:15%;">
                        <col style="width:85%;">
                    </colgroup>
                    <tbody>
                    <tr>
                        <th>결제수단</th>
                        <td><div class="pay_with_list">
                            <strong>신용카드</strong>
                            <ul>
                                <li>결제금액 : <strong class="deposit_money">21,300원</strong></li>
                                
                            </ul>
                        </div>
                        </td>
                    </tr>
                    <tr>
                        <th>주문번호</th>
                        <td>2201192244001194</td>
                    </tr>
                    <tr>
                        <th>주문일자</th>
                        <td>2022-01-19 22:44:41</td>
                    </tr>
                    <tr>
                        <th>주문상품</th>
                        <td>[팝게임즈 - 굿즈] 팝콘 키홀더 외 1건</td>
                    </tr>
                    <tr>
                        <th>주문자명</th>
                        <td>임애선</td>
                    </tr>
                    <tr>
                        <th>배송정보</th>
                        <td>
                            <p>
                                <strong>임애선</strong> <br />
                                [03730] 서울특별시 서대문구 통일로 395 (홍제 센트럴 IPARK) 11<br />
                                  /    /  010-1111-1111<br />
                                배송요청사항 : 문앞에 두고 가주세요.
                            </p>
                        </td>
                    </tr>
                    <tr>
                        <th>상품 금액</th>
                        <td><strong class="order_payment_sum">18,800원</strong>
                            <span class="add_currency"></span>
                        </td>
                    </tr>
                    <tr>
                        <th>배송비</th>
                        <td>기본배송 2,500원
                            <span class="add_currency"></span>
                        </td>
                    </tr>
                
                    <tr>
                        <th>총 결제금액</th>
                        <td><strong class="order_payment_sum">21,300원</strong>
                            <span class="add_currency"></span>
                        </td>
                    </tr>
                    
                </table>
            </div>
            <!-- //order_info -->
        <ul id="end_buttons">
            <li><a href="../index.jsp"><img src="../img/ok.png"></a></li>
        </ul>
        </div> 
    </div>
        </section>
            <div class="clear"></div> 
        </div> 
        <div class="footer_banner"><img src="../img/footer_banner1.png"></div>
    </main>
    <div class="clear"></div>
    <%@ include file="footer.jsp" %>
  </div>
</body>
</html>