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
  
</head>
<body>
  <div id="container">
    <a name="top"></a>
    <%@ include file="header.jsp" %>
    <main>
         <div id="content">
        	<section id="right">
                <div class="cart_top">
                   <h2 id="cart_title"> 장바구니</h2>
                   <h2 id="process"> <span>01 장바구니</span> &rang; 02 주문서 작성/결제 &rang; 03 주문완료</h2>
            </div>
                <table>
                    <tr class="title">
                        <th>선택</th>
                        <th></th>
                        <th>상품명</th>
                        <th>판매가</th>
                        <th>수량</th>
                        <th>배송비</th>
                        <th>합계</th>
                    </tr>
                    <tr class="items">
                        <td class="col1"><input type="checkbox"></td>
                        <td class="col2" id="left">
                            <img src="../img/goods/goods1.png">
                            
                        </td>
                        <td class="coladd"><div">팝콘 키홀더</div></td>
                        <td class="col3">8,900원</td>
                        <td class="col4">
                            1개
                            <button>수량변경</button>
                        </td>
                        <td class="col6">2,500원</td>
                        <td class="col7">11,400원</td>
                    </tr>
                    <tr class="items">
                        <td class="col1"><input type="checkbox"></td>
                        <td class="col2" id="left">
                            <img src="../img/goods/goods2.png">
                        </td>
                        <td class="coladd"><div">팝콘 마스크 스트랩</div></td>
                        <td class="col3">9,900원</td>
                        <td class="col4">
                            1개
                            <button>수량변경</button>
                        </td>
                        <td class="col6">2,500원</td>
                        <td class="col7">12,400원</td>
                    </tr>
                    <tr class="total_price">
                        <td colspan="7">
                            </td>
                            </tr>
                            <tr class="order_status_box">
                                <td colspan="7">
                                <div class="order_status">
                                <p><span>총 주문 금액</span></p>
                                <div>
                                    <ul>
                                        <li class="col1">[상품 구매 금액]:</li>
                                        <li class="col2">19,000원</li>
                                    </ul>
                                    <ul>
                                        <li class="col1">배송비:</li>
                                        <li class="col2">3,000원</li>
                                    </ul>
                                    <ul>
                                        <li class="col1"><span>총 주문 합계 금액</span></li>
                                        <li class="col2"><span>21,000원</span></li>
                                    </ul>
                                </div>
                            </div>
                        </td>
                    </tr>
                </table>
                <ul id="order_buttons">
                    <li><a href="../index.jsp"><img src="../img/shopping.png"></a></li>
                    <li><a href="order.jsp"><img src="../img/select_order.png"></a></li>
                    <li><a href="order.jsp"><img src="../img/all_order.png"></a></li>
                </ul>
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