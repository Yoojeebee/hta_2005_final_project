<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@include file="../../../common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title>Template</title>
<style>
<%@ include file="../../../../resources/css/pay/success.css" %>
</style>
</head>
<body>
	<div class="container" id="success">
		<div class="row">
			<div class="col-10">
				<div id="pay">주문완료</div>
				<div id="panel-body">
					<div class="col-12">&nbsp;</div>
					<div class="col-12">&nbsp;</div>
					<h2 class="col-12" id="order-msg">
						주문이 <span id="complete">완료</span>되었습니다.
					</h2>
					<div class="col-12">&nbsp;</div>
					<div class="col-12">&nbsp;</div>
					<%-- 여기에 주문안내 추가정보 입력한다. --%>
					<div class="row" id="link-order">
						<div class="col-12">
							<a href="http://localhost/order/list.do">
								상세주문내역을 확인하시려면 여기를 눌러주세요
                            </a>
						</div>
					</div>
					<div class="col-12">&nbsp;</div>
				</div>
			</div>
			<div class="col-10">
				<div id="order-req">배달정보</div>
				<div id="panel-body">
					<div class="row" id="delivery-info">
						<div class="col-2" id="info-title">주문식당</div>
						<div class="col-4">${dto.storeName }</div>
						<div class="col-2" id="info-title">안심번호</div>
						<div class="col-4">${order.safeNum }</div>
					</div>
					<div class="row" id="delivery-info">
						<div class="col-2" id="info-title">결제수단</div>
						<!--
						 paymentMethod가 '1'일때 카드결제, '2'일때 현금결제를 출력 
						 Order테이블의 paymentMethod는 CK제약으로 1 or 2 둘 중 하나만 선택 가능하다.	
						-->
						<c:choose>
							<c:when test="${order.paymentMethod == '1' }">
								<div class="col-4">직접결제 - 신용카드결제</div>
							</c:when>
							<c:otherwise>
								<div class="col-4">직접결제 - 현금결제</div>
							</c:otherwise>
						</c:choose>
						<div class="col-2" id="info-title">주문일시</div>
						<div class="col-4"><fmt:formatDate value="${order.createdDate }"  pattern="yyyy-MM-dd [E] a hh:MM"/> </div>
					</div>
					<div class="row" id="delivery-info">
						<div class="col-2" id="info-title">주문자정보</div>
						<div class="col-4">
							${order.recipientAddress }<br>${order.recipientAddressDetail }
						</div>
						<div class="col-2" id="info-title">요청사항</div>
						<div class="col-4">${order.message }</div>
					</div>
				</div>
			</div>
			<div class="col-10">
				<div id="order-req">주문내역</div>
				<div id="panel-body" class="order-info">
					<!-- 주문한 음식 반복 시작 -->
					<c:forEach var="oid" items="${dtoList }">
					<div class="row">
						<div class="col-10" id="info-item">${oid.storeMenuName }: ${oid.orderItemOptionMenuNames } x ${oid.orderItemAmount }개</div>
						<div class="col-2" id="info-price"> <fmt:formatNumber value="${oid.orderItemPrice }" pattern="#,###" ></fmt:formatNumber>원</div>
					</div>
					</c:forEach>
					<!-- 주문한 음식 반복 끝 -->
					<div class="row">
						<div class="col-10">배달료</div>
						<div class="col-2" id="info-price">&nbsp;&nbsp;<fmt:formatNumber value="${dto.deliveryTip }" pattern="#,###"></fmt:formatNumber>원</div>
					</div>
					<div class="row" id="info-total-price">
						<div class="col-10">총 결제 금액</div>
						<div class="col-2" id="info-price"><fmt:formatNumber value="${dto.totalOrderPrice }" pattern="#,###"></fmt:formatNumber>원</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>