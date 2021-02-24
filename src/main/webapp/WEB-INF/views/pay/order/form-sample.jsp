<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/vue/2.5.15/vue.js"></script>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<!-- 부트스트랩 -->
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel="stylesheet"	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"	crossorigin="anonymous">
<!-- 아이콘 사용관련-->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"rel="stylesheet">
<link rel="stylesheet"	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">
<link rel="stylesheet"	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- CSS 스타일시트 -->
<link rel="stylesheet" href="/resources/templates/css/order.css">
<title>Template</title>
</head>
<body>
	<div class="container" id="order-form">
		<form method="post" action="insert.do">
			<div class="row">
				<div class="col-8">
					<div class="row">
						<div class="col-12">
							<div id="pay">결제하기</div>
							<div id="delivery-info">배달정보</div>
							<!-- collapse로 접히는 창을 구현한다. -->
							<div id="panel-body">
								<div class="form-horizontal">
									<div class="form-group row">
										<label class="col-sm-2 control-label" id="add"> <strong>주소</strong>
										</label>
										<div class="col-sm-10">
											<input type="text" value="여기 작업 필요" name="address"
												class="form-control" id="address" disabled="disabled"
												readonly="readonly" />
										</div>
										<div class="col-sm-2"></div>
										<div class="col-sm-10">
											<!-- 상세주소 입력칸이 공백("")일 경우 alert창을 통해 경고를 준다..?!-->
											<input type="text" class="form-control"
												placeholder="(필수)상세주소 입력 - 여기 작업 필요" name="address-detail"
												id="address-detail" />
											<!-- 휴대전화번호 입력칸이 공백("")이거나 숫자가 아닐경우 alert을 통해 경고를 준다?!..input박스에 효과 주는방법-->
										</div>
										<label class="col-sm-2 control-label" id="add-tel"> <strong>휴대전화번호</strong>
										</label>
										<div class="col-sm-10">
											<input type="text" class="form-control"
												placeholder="(필수)휴대전화 번호 입력 - 여기 작업 필요" name="address-tel"
												id="address-tel" />
										</div>
										<div class="col-sm-2"></div>
										<div class="col-sm-10">
											<input type="checkbox" id="safe-num"> <small>
												<strong>안심번호 사용</strong>
											</small>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="col-12">
							<div id="order-req">주문시 요청사항</div>
							<div id="panel-body">
								<textarea id="comment-box" name="comment-box" maxlength="100"
									placeholder="코로나19 예방을 위해 비대면 배달 권장드립니다. 요기서 결제 선택 후, '문 앞 배달'을 요청사항에 남겨주세요"></textarea>
							</div>
						</div>
						<div class="col-sm-12">
							<div id="pay-method">결제수단 선택 (현장 결제는 지원하지 않습니다)</div>
							<div id="panel-body">
								<strong>요기서결제</strong> <span id="web-prepay"> <small>웹에서
										미리 결제</small>
								</span>
								<div id="pay-warning">
									<small>* 현재 신용카드 결제기능만 지원하고 있습니다.</small>
								</div>
								<div class="row pay-method-row">
									<button type="button" class="col-5 btn btn-pay" disabled>
										<i class="fa fa-apple"> 애플페이</i>
									</button>
									<button type="button" class="col-5 btn btn-pay" disabled>
										<i class="fa fa-envira"> 네이버페이</i>
									</button>
									<button type="button" class="col-5 btn btn-pay" disabled>
										<i class="fa fa-smile-o"> 스마일페이</i>
									</button>
									<button type="button" class="col-5 btn btn-pay" disabled>
										<i class="fa fa-paper-plane-o"> 페이팔</i>
									</button>
								</div>
								<strong>현금결제</strong>
								<span id="web-prepay">
									<small>음식받고	직접 결제</small>
								</span>
								<div id="pay-warning"></div>
								<div class="row pay-method-row">
									<button type="button" class="col-5 btn btn-pay">
										<i class="fa fa-credit-card"> 카드결제</i>
									</button>
									<button type="button" class="col-5 btn btn-pay">
										<i class="fa fa-money"> 현금결제</i>
									</button>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-4">
					<div class="row">
						<div class="col-12 cart-head">
							<span class="cart-head-1">주문내역</span>
						</div>
						<div class="col-12 store-name">연우식탁-수유점</div>
						<div class="cart-item">
							<ul class="list-group order-list">
								<li class="cart-item-1 row">
									<div class="col-9">아망드 쇼콜라(다크), 유리병 포장, 2구박스1개 x 3개</div>
									<div class="col-3">25,000 원</div>
								</li>
								<li class="cart-item-1 row">
									<div class="col-9">아망드 쇼콜라(다크), 유리병 포장, 2구박스1개 x 3개</div>
									<div class="col-3">25,000 원</div>
								</li>
								<li class="cart-item-1 row">
									<div class="col-9">아망드 쇼콜라(다크), 유리병 포장, 2구박스1개 x 3개</div>
									<div class="col-3">25,000 원</div>
								</li>
								<li class="cart-item-1 row">
									<div class="col-9">배달료</div>
									<div class="col-3">2,000 원</div>
								</li>
							</ul>
						</div>
					</div>
					<div class="cart-price row">
						<div class="cart-price-1 col-9">
							<strong>총 결제 금액</strong>
						</div>
						<div class="cart-price-1 col-3">
							<strong>100,000원</strong>
						</div>
					</div>
					<div class="row cart-order">
						<div class="col-12 text-center">
							<a href="" class="order-btn">주문하기</a>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
</body>
</html>