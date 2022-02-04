<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="ko">
<head>
  <title>pop games</title>
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.1.5.js"></script>
  <script src="../js/jquery-3.2.1.min.js"></script>
  <script src="../js/index.js"></script>
  <link rel="shortcut icon" type="image⁄x-icon" href="../img/favicon.ico">
  <link href="../css/common.css" rel="stylesheet" type="text/css">
  <link href="../css/order.css" rel="stylesheet" type="text/css">
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
                   <h2 id="cart_title"> 주문서 작성/결제</h2>
                   <h2 id="process"> 01 장바구니 &rang; <span>02 주문서 작성/결제</span> &rang; 03 주문완료</h2>
            </div>
                <table>
                    <tr class="title">
                        <th></th>
                        <th>상품명</th>
                        <th>판매가</th>
                        <th>수량</th>
                        <th>배송비</th>
                        <th>합계</th>
                    </tr>
                    <tr class="items">
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
                        <td colspan="6">
                            </td>
                            </tr>
                            <tr class="order_status_box">
                                <td colspan="7">
                                <div class="order_status">
                                <p><span>총 주문 금액</span></p>
                                <div>
                                    <ul>
                                        <li class="col1">[상품 구매 금액]:</li>
                                        <li class="col2">18,800원</li>
                                    </ul>
                                    <ul>
                                        <li class="col1">배송비:</li>
                                        <li class="col2">2,500원</li>
                                    </ul>
                                    <ul>
                                        <li class="col1"><span>총 주문 합계 금액</span></li>
                                        <li class="col2"><span>21,300원</span></li>
                                    </ul>
                                </div>
                            </div>
                        </td>
                    </tr>
                </table>
                <div class="order_info">
                    <div class="order_zone_tit">
                        <h4>주문자 정보</h4>
                    </div>

                    <div class="order_table_type">
                        <table class="table_left">
                            <colgroup>
                                <col style="width:15%;">
                                <col style="width:85%;">
                            </colgroup>
                            <tbody>
                            <tr>
                                <th scope="row"><span class="important">주문하시는 분</span></th>
                                <td><input type="text" name="orderName" id="orderName" value="" data-pattern="gdEngKor" maxlength="20"/>
                                </td>
                            </tr>
                            <tr>
                                <th scope="row">전화번호</th>
                                <td>
                                    <input type="text" id="phoneNum" name="orderPhone" value="" maxlength="20" />
                                </td>
                            </tr>
                            <tr>
                                <th scope="row"><span class="important">휴대폰 번호</span></th>
                                <td>
                                    <input type="text" id="mobileNum" name="orderCellPhone" value="" maxlength="20" />
                                </td>
                            </tr>
                            <tr>
                                <th scope="row"><span class="important">이메일</span></th>
                                <td class="member_email">
                                    <input type="text" name="orderEmail" value="" />

                                    <select id="emailDomain" class="chosen-select">
                                        <option value="self">직접입력</option>
                                        <option value="naver.com">naver.com</option>
                                        <option value="hanmail.net">hanmail.net</option>
                                        <option value="daum.net">daum.net</option>
                                        <option value="nate.com">nate.com</option>
                                        <option value="hotmail.com">hotmail.com</option>
                                        <option value="gmail.com">gmail.com</option>
                                        <option value="icloud.com">icloud.com</option>
                                    </select>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="delivery_info">
                    <div class="order_zone_tit">
                        <h4>배송정보</h4>
                    </div>

                    <div class="order_table_type shipping_info">
                        <table class="table_left shipping_info_table">
                            <colgroup>
                                <col style="width:15%;">
                                <col style="width:85%;">
                            </colgroup>
                            <tbody>
                            <tr>
                                <th scope="row">배송지 확인</th>
                                <td>
                                    <div class="form_element">
                                        <ul>
                                            <li>
                                                <input type="radio" name="shipping" id="shippingNew"/>
                                                <label for="shippingNew" class="choice_s">직접 입력</label>
                                            </li>
                                            <li>
                                                <input type="radio" name="shipping" id="shippingSameCheck"/>
                                                <label for="shippingSameCheck" class="choice_s">주문자정보와 동일</label>
                                            </li>
                                        </ul>
                                        <input type="hidden" class="shipping-delivery-visit" value="n" />
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <th scope="row"><span class="important">받으실분</span></th>
                                <td><input type="text" name="receiverName" data-pattern="gdEngKor" maxlength="20"/></td>
                            </tr>
                            <tr>
                                <th scope="row"><span class="important">받으실 곳</span></th>
                                <td class="member_address">
                                    <div class="address_postcode">
                                        <input type="text" name="receiverZonecode" readonly="readonly" />
                                        <input type="hidden" name="receiverZipcode"/>
                                        <button type="button" class="btn_post_search" onclick="gd_postcode_search('receiverZonecode', 'receiverAddress', 'receiverZipcode');">우편번호검색</button>
                                    </div>
                                    <div class="address_input">
                                        <input type="text" name="receiverAddress" readonly="readonly"/>
                                        <input type="text" name="receiverAddressSub" />
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <th scope="row">전화번호</th>
                                <td>
                                    <input type="text" id="receiverPhone" name="receiverPhone" />
                                </td>
                            </tr>
                            <tr>
                                <th scope="row"><span class="important">휴대폰 번호</span></th>
                                <td>
                                    <input type="text" id="receiverCellPhone" name="receiverCellPhone"/>
                                </td>
                            </tr>
                            <tr>
                                <th scope="row">배송요청사항</th>
                                <td class="td_last_say"><input type="text" name="orderMemo"/></td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <!-- //delivery_info -->
                <div class="payment_progress">
                    <div class="order_zone_tit">
                        <h4>결제수단 선택 / 결제</h4>
                    </div>

                    <div class="payment_progress_list">
                        <div class="js_pay_content">

                            <!-- N : 일반결제 시작 -->
                            <div id="settlekind_general" class="general_payment">
                                <dl>
                                    <dt>일반결제</dt>
                                    <dd>
                                        <div class="form_element">
                                            <ul class="payment_progress_select">
                                                
                                                <li id="settlekindType_pc">
                                                    <input type="radio" id="settleKind_pc" name="settleKind" value="pc"/>
                                                    <label for="settleKind_pc" class="choice_s">신용카드</label>
                                                </li>
                                            </ul>
                                        </div>
                                        <!-- //pay_bankbook_box -->

                                        <!-- 신용카드 컨텐츠 -->
                                        <div class="card" id="settlekind_general_pc"></div>
                                        <!-- //신용카드 컨텐츠 -->
                                    </dd>
                                </dl>
                            </div>
                            <!-- //general_payment -->
                            <!-- N : 일반결제 끝 -->

                        </div>
                        
                    </div>
                    <!-- //payment_progress_list -->
                    <div class="payment_final">
                        <div class="payment_final_total">
                            <dl>
                                <dt>최종 결제 금액</dt>
                                <dd><span><strong id="totalSettlePriceView">15,500</strong>원</span></dd>
                            </dl>
                        </div>
                    </div>
                    <!-- //payment_final -->
                </div>
                <ul id="pay_buttons">
                    <li><button id="check_module" type="button"><a href="#"><img src="../img/paybutton.png"></a></button></li>
                </ul>
                <script>
                    $("#check_module").click(function () {
                    var IMP = window.IMP; 
                    IMP.init('imp48496879');
                    IMP.request_pay({
                    pg: 'inicis', 
                 
                    pay_method: 'card',
                
                    merchant_uid: 'merchant_' + new Date().getTime(),
                
                    name: '주문명:결제',
                
                    amount: 10,
                
                    buyer_email: 'popgames@pop.com',
                    buyer_name: '팝게임즈',
                    buyer_tel: '010-1234-5678',
                    buyer_addr: '서울특별시 강남구 삼성동',
                    buyer_postcode: '123-456',
                    m_redirect_url: 'https://www.yourdomain.com/payments/complete'
                
                    }, function (rsp) {
                    console.log(rsp);
                    if (rsp.success) {
                    var msg = '결제가 완료되었습니다.';
                    msg += '고유ID : ' + rsp.imp_uid;
                    msg += '상점 거래ID : ' + rsp.merchant_uid;
                    msg += '결제 금액 : ' + rsp.paid_amount;
                    msg += '카드 승인번호 : ' + rsp.apply_num;
                    } else {
                    var msg = '결제에 실패하였습니다.';
                    msg += '에러내용 : ' + rsp.error_msg;
                    }
                    alert(msg);
                    });
                    });
                    </script>
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