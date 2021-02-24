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
<style>
</style>
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
										<!-- 단비가 session에 저장한 위치주소명을 아래 value에 입력한다 -->
											<input type="text" v-model="originAddress" class="form-control" 
											id="address" disabled="disabled" readonly="readonly"/>
										</div>
										<div class="col-sm-2"></div>
										<div class="col-sm-10">
											<!-- 상세주소 입력칸이 공백("")일 경우 alert창을 통해 경고를 준다..?!-->
											<input type="text" class="form-control"
												placeholder="(필수)상세주소 입력 - 여기 작업 필요" name="address-detail"
												id="address-detail" v-model="detail"/>
											<!-- 휴대전화번호 입력칸이 공백("")이거나 숫자가 아닐경우 
                                                alert을 통해 경고를 준다?!..input박스에 효과 주는방법-->
										</div>
										<label class="col-sm-2 control-label" id="add-tel">
											<strong>휴대전화번호</strong>
										</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" placeholder="(필수)휴대전화 번호 입력 - 여기 작업 필요" 
												v-model="tel" id="address-tel"/>
										</div>
										<div class="col-sm-2"></div>
										<div class="col-sm-10">
											<input type="checkbox" id="safe-num" v-model="safeNum">
											<small><strong>안심번호 사용</strong></small>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="col-12">
							<div id="order-req">주문시 요청사항</div>
							<div id="panel-body">
								<textarea id="comment-box" name="comment-box" maxlength="100" v-model="message" rows="3"
									placeholder="코로나19 예방을 위해 비대면 배달 권장드립니다. 요기서 결제 선택 후, '문 앞 배달'을 요청사항에 남겨주세요"></textarea>
							</div>
						</div>
						<div class="col-sm-12">
							<div id="pay-method">결제수단 선택</div>
							<div id="panel-body">
								<strong>요기서결제</strong>
								<span id="web-prepay"> 
									<small>웹에서미리 결제</small>
								</span>
								<div id="pay-warning">
									<small>* 현재 탈세를 위해 현금결제를 권장하고 있습니다.</small>
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
								<strong>직접결제</strong> 
								<span id="web-prepay"> <small>음식받고	직접 결제</small></span>
								<div id="pay-warning"></div>
								<div class="row pay-method-row">
									<button @click="putPayMethod('1')" type="button" class="col-5 btn btn-pay">
										<i class="fa fa-credit-card"> 카드결제</i>
									</button>
									<button @click="putPayMethod('2')" type="button" class="col-5 btn btn-pay">
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
						<div class="col-12 store-name">{{storeName}}</div>
						<div class="cart-item" v-for="dtoAndSb in dtoAndOptionSbList" :key="dtoAndSb.cartItemDto.no">
							<ul class="list-group order-list">
								<!-- 주문리스트 -->
								<li class="cart-item-1 row">
									<div class="col-9">{{dtoAndSb.cartItemDto.storeMenu.name}},
									{{dtoAndSb.optionMenuNames}} x{{dtoAndSb.cartItemDto.amount}}개</div>
									<div class="col-3">{{dtoAndSb.cartItemDto.cartItemPrice}}원</div>
								</li>
								<!-- 주문리스트 반복 끝-->
								<!-- 배달료 -->
								<li class="cart-item-1 row" v-show="isShowDeliveryTip">
									<div class="col-9">배달료</div>
									<div class="col-3">{{deliveryTip}}원</div>
								</li>
								<!-- 배달료 끝 -->
							</ul>
						</div>
					</div>
					<!-- 총 결제금액 -->
					<div class="cart-price row">
						<div class="cart-price-1 col-8">
							<strong>총 결제 금액</strong>
						</div>
						<div class="cart-price-1 col-4">
							<strong>{{1000000}} 원</strong>
						</div>
					</div>
					<div><small>이용약관, 개인정보 수집 및 이용, 개인정보 제3자 제공 , 전자금융거래 이용약관,
					 만 14세 이상 이용자 내용 확인하였으며 결제에 동의합니다.</small></div>
					<!-- 총 결제금액 끝 -->
					<div class="row cart-order">
						<button @click="insertOrder()" type="button" class="col-12 order-btn btn btn-lg">결제하기</a>
					</div>
				</div>
			</div>
		</form>
	</div>
<script>

	var app = new Vue({
		el:'#order-form',
		data: {
			dtoAndOptionSbList: 
                [{cartItemDto: {no:1, amount:2, cartItemPrice:100, storeMenu:{name:"로제 쉬림프파스타", price:35000}, store:{name:'연우식탁', minPrice:50000}, optionMenuList:[{},{}], 
                delivery:{}, cartItemPrice:10000, optionMenuNames:"가나,다라,마바사" }, optionMenuNames:'양배추절임, 사이드디쉬B set, 하이네켄'}],
            cartItemDtos: [],
            totalCartPrice: 0,
            minPrice: 50000,
            deliveryTip: 5000,
			storeName: '연우식탁-수유점',
			originAddress: '서울시 강북구 수유동 777',
			address: '',
			detail: '',
			tel: '',
			message: '',
			payMethod: '',
			safeNum: false
		},
		methods: {
			isShowDeliveryTip: function () {
                if (app.deliveryTip > 0) {
                    return true;
                } else {
                    return false;
                }
            },
			putPayMethod: function(payMethod) {
				app.payMethod = payMethod;
				//console.log(app.payMethod);
			},
			insertOrder: function() {
				if(app.address == "" || app.detail== "" 
				|| app.tel == "" || app.payMethod == ""){
					alert("배달정보와 결제수단은 필수 입력사항입니다.");
					return false; //insert.do로 넘어가지않게 하는 작업. break?
				} else {
					axios.post("http://localhost/api/order/insert.do", app.data)
					.then(function(response) {
						//값이 잘 전달되었는지 확인하고, success가 true를 반환하면 주문성공 페이지를 요청하는 요청핸들러메소드를 연결한다.
						if(response.data.success){
							location.href="http://localhost/order/confirmOrder.do"
						} else {
							alert("오류가 발생하였습니다.");
						}
					})
				}
			}

		},
		filter: {
			// currency: function (value) {
            //       return value.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
            // }
		},
		cretaed() {
			axios.get("http://localhost/api/cart/items.do")
				.then(function (response) {
                    app.dtoAndOptionSbList = response.data.dtoAndOptionSbList;
                    app.cartItemDtos = response.data.cartItemDtos;
                    app.totalCartPrice = response.data.totalCartPrice;
                    app.minPrice = response.data.minPrice;
                    app.deliveryTip = response.data.deliveryTip;
					app.storeName = response.data.storeName;
					app.originAddress = response.data.originAddress;
				})
		}
	
	});

</script>
</body>
</html>