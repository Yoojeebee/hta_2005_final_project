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
#complete {
	color: #ff0055;
}

#order-msg {
	font-weight: bold;
	color: #414141;
	text-align: center;
}

#panel-body {
	padding: 15px;
	border: solid 1px lightgrey;
	margin: 0;
}

#pay {
	background-color: rgb(36, 35, 35);
	color: white;
	padding: 12px;
}

#order-req {
	background-color: rgba(226, 226, 226, 0.986);
	padding: 12px;
	border: 1px solid lightgrey;
}

#info-title {
	font-weight: bold;
}

#delivery-info {
	padding-top: 5px;
	padding-bottom: 5px;
}

.order-info {
	background: #fff5e5;
}

#link-order {
	text-align: center;
	font-size: 18px;
	text-decoration: underline;
}
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
							<a href="http://localhost/order/detail.do">
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
						<c:when test=""></c:when>
						<div class="col-4">직접결제 - 신용카드결제</div>
						<div class="col-2" id="info-title">주문일시</div>
						<div class="col-4">2021-07-07 21:05</div>
					</div>
					<div class="row" id="delivery-info">
						<div class="col-2" id="info-title">주문자정보</div>
						<div class="col-4">
							서울시 강북구 인수동<br>긴코만숀 욘마루이치고
						</div>
						<div class="col-2" id="info-title">요청사항</div>
						<div class="col-4">문앞에 놓고 벨튀해주세요. 감사합니다아아아아아아아아아</div>
					</div>
				</div>
			</div>

			<!-- <div class="col-10">
				<div id="order-req">주문내역</div>
				<div id="panel-body" class="order-info">
					주문한 음식 반복 시작
					<div class="row">
						<div class="col-9" id="info-item">토마토 해물 파스타: extra seafood x 1개</div>
						<div class="col-3" id="info-price"> 15,800원</div>
					</div>
					주문한 음식 반복 끝
					<div class="row">
						<div class="col-9">배달료</div>
						<div class="col-3" id="info-price"> 5,000원</div>
					</div>
					<div class="row" id="info-total-price">
						<div class="col-9">총 결제 금액</div>
						<div class="col-3" id="info-price"> 20,800원</div>
					</div>
				</div>
			</div> -->
		</div>
	</div>
</body>
</html>