<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@include file="../../../common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<title>Bootstrap Card</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1 shrink-to-fit=no">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/vue/2.5.15/vue.js"></script>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link rel="stylesheet"	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
<%@include file="../../../../resources/css/pay/cart.css" %>
</style>
</head>
<body>
    <div class="container" id="cart-list">
        <div class="row">
            <div class="col-8">이곳은 가게상세페이지입니다.</div>
            <div class="col-4">
                <div class="row cart">
                    <div class="col-12 cart-head">
                        <span class="cart-head-1">주문표</span>
                        <!-- 전체삭제버튼 onclick이벤트 구현-->
                        <button type="button" class="cart-head-2 btn btn-dark btn-sm float-right" data-toggle="modal" data-target="#delAllConfirm">
                            <i class="material-icons">delete</i>
                        </button>
                    </div>
                    <!-- cartItemDtos가 비어있는 경우-->
                    <div class="col-12 cart-list" v-show="!isShowCartList()">
                        <div>주문표에 담긴 메뉴가 없습니다.</div>
                    </div>
                    <!-- cartItemDtos가 비어있지 않은 경우 -->
                    <div class="col-12 cart-item" v-show="isShowCartList()"  v-for="dto in cartItemDtos"
                    :key="dto.no">
                    <input type="hidden" name="no" value="dto.no"/>
                    <div>{{dto.storeMenuName}}: {{dto.optionMenuNames}}</div>
                    <div>
                        <!-- 취소버튼 onclick이벤트 구현-->
                        <button @click="deleteCartItem(dto.no)" type="button" class="cart-item-1 btn btn-light border btn-sm">X</button>
                        <!-- 수량조절 - + 버튼을 누르면 해당 메뉴 가격도 증가한다.-->
                        <input class="cart-item-2" v-bind:value="dto.price | currency"  readonly>원
                        <button type="button" @click="plusCount(dto.no)" class="cart-item-3 btn btn-link float-right">
                            <i class="fa fa-plus-square-o"></i>
                        </button>                                       
                        <input class="cart-item-4 float-right" v-model="dto.amount" maxlength="3" size="3" readonly>
                        <!-- 수량조절 - + 버튼을 누르면 해당 메뉴 가격도 증가한다.-->
                        <button type="button" @click="minusCount(dto.no)" class="cart-item-5 btn btn-link float-right">
                            <i class="fa fa-minus-square-o"></i>
                        </button>
                    </div>
                </div>
                <!-- 주문표 목록 끝 -->
            </div>
            <!-- if(deliveryFee > 0)이면 이 정보를 화면에 출력한다.-->
            <div class="cart-price row" v-show="isShowDeliveryTip()">
                <div class="delivery-fee col-12">
                    <div class="text-right">배달요금 {{deliveryTip | currency}}원 별도</div>
                </div>
            </div>
            <!-- if(app.minPrice > app.totalCartPrice면 이 정보를 화면에 출력한다.-->
            <div class="cart-price row" v-show="isShowMinPrice()">
                <div class="cart-minimum col-12" >
                    <div class="text-right">최소주문금액:&nbsp;&nbsp;&nbsp;{{minPrice | currency}}원 이상</div>
                </div>
            </div>
            <div class="cart-price row">
                <div class="cart-price-1 col-12">
                    <!-- 위의 수량증감버튼을 누르면 아래 합계금액도 자동으로 변화한다.-->
                    <div class="cart-price-2 totalPrice">
                        합계: <input class="totalPrice" v-bind:value="totalPrice | currency" readonly disabled
                                maxlength=8 size=5 >원
                    </div>
                </div>
            </div>
            <div class="row cart-order">
                <!--  if(totalCartPrice == 0)일 경우 :disabled 처리를 한다 -->
                <button @click="toOrderForm()" :disabled="totalCartPrice == 0" type="button" class="col-12 order-btn btn btn-lg">주문하기</button>
            </div>
        </div>
    </div>
    <div class="modal" id="delAllConfirm">
        <div class="modal-dialog">
            <div class="modal-content">
                <!-- Modal Header -->
                <div class="modal-header cart-head modal-head">
                    <h4 class="modal-title cart-head-1">요기요</h4>
                </div>

                <!-- Modal body -->
                <div class="modal-body">주문메뉴를 모두 삭제하시겠습니까?</div>

                <!-- Modal footer -->
                <div class="modal-footer modal-foot">
                    <button type="button" class="btn btn-outline-danger" data-dismiss="modal">취소</button>
                    <button @click="deleteAllCartItem()" type="button" class="btn btn-danger">확인</button>
                </div>
            </div>
        </div>
    </div>
</div>
<script>

    var app = new Vue({
        el: '#cart-list',
        data: { 
            // '주문상세' 모달창에서 메뉴와 옵션을 선택하면 값이 동기화되는 객체
            cartForm: {
                amount: 0,
                storeNo: 0,
                menuNo: 0,
            //  선택된 옵션메뉴들의 정보들을 담는 List<OptionMenuForm> 
                optionMenuForm: []
            },
            // created로 RestController의 item.do를 요청했을때 받아오는 값들
            //  - 주문표에 표현할 정보들이다.
            cartItemDtos: [],
            totalCartPrice: 0, 
            minPrice: 0,
            deliveryTip: 0,
            storeName: '',
			originAddress: ''
        },
        computed: {
            totalPrice: function() {
                var totalPrice = 0;
                for (var i=0; i < this.cartItemDtos.length; i++) {
                    var dto = this.cartItemDtos[i];
                    totalPrice += dto.price;
                }
                return totalPrice;
            }
        },
        methods: {
            insert: function() {
                axios.post("http:/localhost/cart/items/insert.do", app.cartForm);
            },
            isShowMinPrice: function () {
                // 최소주문가격이 합계보다 크면 true,  작으면 false를 반환
                if (this.minPrice > this.totalCartPrice) {
                    return true;
                } else {
                    return false;
                }
            },

            isShowDeliveryTip: function () {
                if (this.deliveryTip > 0) {
                    return true;
                } else {
                    return false;
                }
            },

            isShowCartList: function () {
                if (this.cartItemDtos.length > 0) {
                    return true;
                } else {
                    return false;
                }
            },

            findCartItem: function (no) {
                var foundCartItem;
                for (var i = 0; i < this.cartItemDtos.length; i++) {
                    var cartItemDto = this.cartItemDtos[i];
                    if (cartItemDto.no == no) {
                        foundCartItem = cartItemDto;
                        break;
                    }
                }
                return foundCartItem;
            },
           
            // 주문표의 하나의 주문아이템에 대한 수량변경 함수(update메서드 호출)
            plusCount: function (cartItemNo) {
                var item = app.findCartItem(cartItemNo);
                item.amount = item.amount + 1;
                item.price = item.price + (item.price/(item.amount-1));
                axios.post("http://localhost/api/cart/items/update.do", item);
            },

            minusCount: function (cartItemNo) {
                var item = app.findCartItem(cartItemNo);
                if(item.amount > 1){
                item.amount = item.amount - 1;
                item.price = item.price - (item.price/(item.amount+1));
                axios.post("http://localhost/api/cart/items/update.do", item);
                }
            },

            deleteCartItem: function (cartItemNo) {
                axios
                    .delete("http://localhost/api/cart/items/delete.do/"+ cartItemNo)
                    .then(function (response) {
                        var foundCartItemIndex = -1;
                        for (var i = 0; i < app.cartItemDtos.length; i++) {
                            var cartItemDto = app.cartItemDtos[i];
                            if (cartItemDto.no == cartItemNo) {
                                foundCartItemIndex = i;
                                break;
                            }
                        }
                        if (foundCartItemIndex != -1) {
                            app.cartItemDtos.splice(foundCartItemIndex, 1);
                            // 배열.splice(index, howmany, item, item, ....) index: 삭제시작 위치 howmany : 삭제할 개수
                        }
                    })
			},
			deleteAllCartItem: function() {
                axios
                    .delete("http://localhost/api/cart/items/deleteAll.do")
                    .then(function(response) {
                        app.cartItemDtos.splice(0, app.cartItemDtos.length);
                        $("#delAllConfirm").modal("hide");
                    })
            },
            toOrderForm: function(){
                location.href = "http://localhost/order/form.do";
            }
        },
		filters: {
			currency: function (value) {
                  return value.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
            }
		},
		
        created() {

            axios
                .get("http://localhost/api/cart/items.do")
                .then(function (response) {
                    app.cartItemDtos = response.data.cartItemDtos;
                    app.totalCartPrice = response.data.totalCartPrice;
                    app.minPrice = response.data.minPrice;
                    app.deliveryTip = response.data.deliveryTip;
                    app.storeName = response.data.storeName;
			        app.originAddress = response.data.originAddress;
                   // console.log(app.totalCartPrice);
                })
        }
        
    });
</script>
</body>

</html>