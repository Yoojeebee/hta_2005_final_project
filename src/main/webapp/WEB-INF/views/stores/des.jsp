<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file = "../../common/taglib.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>

<head>
    <title>Detail</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="/resources/css/manage.css" />
    <link rel="stylesheet" href="/resources/css/owner.css" />
    <link rel="stylesheet" href="/static/resources/css/pay/cart.css" />
    <style>
        .nav-item {
            width: 33.3%;
            /*border-bottom: 2px solid grey;*/
        }
        .nav-link {
            color: black;
        }
        .nav-link:hover {
            color: black;
        }
        .nav-tabs .nav-link {
            border: 0;
        }

        .navbar-nav > li {
            float: left;
            position: relative;
        }
        .navbar-light .navbar-nav .active a::after {
            border-bottom: 5px solid #5bc0eb;
            bottom: -10px;
            content: " ";
            left: 0;
            position: absolute;
            right: 0;
        }

        .menu {
            width: 100%;
            background-color: white;
            border: 1px solid grey;
        }
        .menu:focus {
            border: 1px solid grey;
            outline: none;
        }
    </style>
    <!-- 리뷰스타일 -->
    <style type="text/css">
   .toggleBG{background: hsl(0, 100%, 90%); width: 70px; height: 30px; border: 1px solid hsl(0, 100%, 90%); border-radius: 15px;}
   .toggleFG{background: #fffff0; width: 30px; height: 30px; border: none; border-radius: 15px; position: relative; left: 0px;}
   
   span {
      color: orange;
   }
   .star {
       font-size: 2rem;
       cursor: pointer;
   }
   .star:not(.on) {
       color: #ccc;
   }
   .star.on {
       color: orange;
   }
   </style>
</head>

<body>

<div class="container">
    <div class="row">
        <div class="col-md-8">
            <ul class="list-group">
                <li class="list-group-item" style="text-align: left;">가게 이름</li>

                <li class="list-group-item">
                    <div class="row">
                        <div class="col-md-12">
                            <div style="width: 80px; height: 80px; float: left; border: 1px solid black; overflow: hidden;">
                                <img src="/static/images/store/${store.thumbnail}" style="width: 100%; height: 100%; object-fit: fill;">
                            </div>

                        </div>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</div>

<br/>

<%--  내비바  --%>
<div class="container">
    <div class="row">
        <div class="col-md-8">
            <!-- Nav tabs -->
            <div style="width:100%; border-top: 2px solid #d9d9d9; border-left: 2px solid #d9d9d9; border-right: 2px solid #d9d9d9;">
                <ul class="nav nav-tabs" role="tablist">
                    <li class="nav-item" style="border-right: 2px solid #d9d9d9;">
                        <a class="nav-link active" data-toggle="tab" href="#menu1">메뉴</a>
                    </li>
                    <li class="nav-item" style="border-right: 2px solid #d9d9d9;">
                        <a class="nav-link" data-toggle="tab" href="#menu2">클린리뷰</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" data-toggle="tab" href="#menu3">정보</a>
                    </li>
                </ul>
            </div>

            <!-- Tab panes -->
            <div class="tab-content" style="border: 2px solid #d9d9d9;">
                <div id="menu1" class="container tab-pane active" style="padding: 0;">
					<c:forEach var="item" items="${menu}" varStatus="status">
						<%@ include file="storeMenu.jsp"%>
					</c:forEach>
				</div>

                <%--   혜영씨 공간 시작! 리뷰추가 02-25  --%>
                <div id="menu2" class="container tab-pane fade"><br>
                   <div class="row">
                    <div class="col-5 text-right pb-2">
                           <div>
                               <strong class="display-3">{{store.avg }}</strong>
                           </div>
                           <div id="avg-star-box">
                                 <span v-for="i in store.avg" class="star on">★</span>
                                 <span v-for="x in (5-store.avg)"class="star">★</span>
                           </div>
                     </div>
                      <div class="col-7 pt-3">
                         <table>
                             <tr>
                                 <td>맛</td>
                                 <td>
                                     <div id="taste-star-box">
	                                      <span v-for="i in store.taste" class="star on">★</span>
	                                      <span v-for="x in (5-store.taste)" class="star">★</span>
                                     </div>
                                 </td>
                             </tr>
                             <tr>
                                 <td>양</td>
                                 <td>
                                     <div id="quantity-star-box">
                                         <span v-for="i in store.quality" class="star on">★</span>
                                     	 <span v-for="x in (5-store.quality)" class="star">★</span>
                                     </div>
                                 </td>
                             </tr>
                             <tr>
                                 <td>배달</td>
                                 <td>
                                     <div id="delivery-star-box">
                                        <span v-for="i in store.delivery" class="star on">★</span>
                                     	<span v-for="x in (5-store.delivery)" class="star">★</span>
                                     </div>
                                  </td>
                            </tr>
                        </table>
                    </div>
                 </div>
                 <div class="row mt-3 d-flex justify-content-between p-3">
                     <div>
                         리뷰 <strong>{{store.reviewAcc }}</strong>개 사장님댓글 <strong>{{store.ownerAcc}}</strong>개
                     </div>
                     <!--사진리뷰만 보여주는 토글버튼-->
                     <div class="toggleBG" id="btn-photoReview"><button class="toggleFG"></button></div>
                 </div>
                 <div class="row mt-3 d-flex justify-content-between p-3">
                     <!-- 주문한 내역이 있으면 리뷰작성을 할 수 있다 -->
                      <div class="col-12 text-center mb-3">
                         <a href="../review/form.do?storeNo=${param.storeNo }&orderno=${param.oredrNo}" class="btn btn-outline-primary btn-sm">리뷰작성</a>
                     </div>
                 </div>
                    <div class="row mt-3 d-flex justify-content-between p-3">
                        <div id="box-section" class="col-12">
                            <div v-for="review in reviews" class="row border my-3 p-3 section" >
                                <div class="col-12 mb-3">
                                    <div class="text-left pb-2">
                                        <strong>{{review.userId }}</strong>님 <small style="color:gray">{{review.reviewCreatedDate }}</small>
                                    </div>
                                    <div class="text-right pb-2">
                                        <!-- 사장은 본인 가게의 리뷰에만 코멘트를 작성할 수 있다 -->
                                        <a v-if="store.ownerNo == '${OWNER_NO  }'" 
                                           v-bind:href="'../review/commentform.do?storeNo=${param.storeNo }&ownerNo=${OWNER_NO }&reviewNo=' + review.no"
                                           class="btn btn-outline-primary btn-sm">코멘트작성</a>
                                        <!-- 본인이 작성한 리뷰만 삭제할 수 있다, 사장 코멘트가 달려있을 경우 삭제 불가 -->
                                        <a v-if="review.userNo == '${LOGINED_USER.no }'" 
                                           v-bind:href="'/review/delete.do?storeNo=${param.storeNo }&reviewNo=' + review.no" 
                                           class="btn btn-outline-primary btn-sm">리뷰삭제</a>
                                    </div>
                                </div>
                                <div class="col-5 mb-3">
                                    <div id="avg-star-box">
                                        <span v-for="i in review.avgScore" class="star on">★</span>
                                        <span v-for="x in (5-review.avgScore)" class="star">★</span>
                                    </div>
                                </div>
                                <div class="col-7 mb-3">
                                    <small style="color:gray">맛</small>
                                    <span>★</span><strong class="text-warning">{{review.tasteScore }}</strong>
                                    <small style="color:gray">양 </small>          
                                    <span>★</span><strong class="text-warning">{{review.quantityScore }}</strong>
                                    <small style="color:gray">배달 </small>          
                                    <span>★</span><strong class="text-warning">{{review.deliveryScore }}</strong>
                                </div>
                                <div v-if="review.photo1" class="col-12 mb-3">
                                    <img :src="'/static/resource/images/' + review.photo1" alt="리뷰사진1" style="max-width: 100%;">
                                </div>
                                <div v-if="review.photo2" class="col-12 mb-3">
                                    <img :src="'/static/resource/images/' + review.photo2" alt="리뷰사진2" style="max-width: 100%;">
                                </div>
                                <div v-if="review.photo3" class="col-12 mb-3">
                                    <img :src="'/static/resource/images/' + review.photo3" alt="리뷰사진3" style="max-width: 100%;">
                                </div>
                                <div class="col-12 mb-3">
                                    <small style="color: #e5b996">
                                        {{review.orderInfo}}
                                    </small>
                                </div>
                                <div class="col-12 mb-3">
                                    {{review.contents }}
                                </div>
                                <div v-if="review.ownerComment" class="col-12 mb-3">
                                	<div class="card-body border">
	                                    <div class="text-left pb-2">
	                                        <strong>사장님  </strong><small>{{review.ownerReviewCreatedDate }}</small>
	                                        <div>
	                                            {{review.ownerComment }}
	                                        </div>
	                                    </div>
	                                </div>
                                </div>
                            </div>
                        </div>
                        <!-- 페이지처리 -->
                        <div class="row m-3">
                            <div class="col-12 text-center" align="center">
                                    <button @click="moreReview()" :disabled="currentPage == pagination.totalPages" class="btn btn-outline-primary center">더보기</button>
                            </div>
                        </div>
                    </div> 
                </div>
                <%--   혜영씨 공간 끝!   --%>

                <div id="menu3" class="container tab-pane fade"><br>
                    <h3>Menu 2</h3>
                    <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam.</p>
                </div>
            </div>
        </div>
        
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
					<div class="col-12 cart-item" v-show="isShowCartList()" v-for="dto in cartItemDtos" :key="dto.no">
						<input type="hidden" name="no" value="dto.no" />
						<div>{{dto.storeMenuName}}: {{dto.optionMenuNames}}</div>
						<div>
							<!-- 취소버튼 onclick이벤트 구현-->
							<button @click="deleteCartItem(dto.no)" type="button" class="cart-item-1 btn btn-light border btn-sm">X</button>
							<!-- 수량조절 - + 버튼을 누르면 해당 메뉴 가격도 증가한다.-->
							<input class="cart-item-2" v-bind:value="dto.price | currency" readonly>원
							<button type="button" @click="plusCount(dto.no)" class="cart-item-3 btn btn-link float-right">
								<i class="fa fa-plus-square-o"></i>
							</button>
							<input class="cart-item-4 float-right" v-model="dto.amount" maxlength="3" size="3" readonly>
							<!-- 수량조절 - + 버튼을 누르면 해당 메뉴 가격도 증가한다.-->
							<button type="button" @click="minusCount(dto.no)"
								class="cart-item-5 btn btn-link float-right">
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
				<div class="cart-minimum col-12">
					<div class="text-right">최소주문금액:&nbsp;&nbsp;&nbsp;{{minPrice |
						currency}}원 이상</div>
				</div>
			</div>
			<div class="cart-price row">
				<div class="cart-price-1 col-12">
					<!-- 위의 수량증감버튼을 누르면 아래 합계금액도 자동으로 변화한다.-->
					<div class="cart-price-2 totalPrice">
						합계: <input class="totalPrice" v-bind:value="totalPrice | currency" readonly disabled maxlength=8 size=5>원
					</div>
				</div>
			</div>
			<div class="row cart-order">
				<!--  if(totalCartPrice == 0)일 경우 :disabled 처리를 한다 -->
				<button @click="toOrderForm()" :disabled="totalCartPrice == 0" type="button" class="col-12 order-btn btn btn-lg">주문하기</button>
			</div>
		</div>
			
		</div>
		
		<c:forEach var="item" items="${menu}" varStatus="status">
			<%@ include file="storeMenuUpdate.jsp"%>
		</c:forEach>
						
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" ></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<!-- 리뷰 -->
<script type="text/javascript">
//리뷰 페이징처리
var app = new Vue({
   el:"#menu2",
   data: {
      currentPage:1,
      pagination: {},
      store:{},
      reviews:[]
   },
   methods: {
      moreReview() {
         var self = this
         self.currentPage = self.currentPage + 1
         $.getJSON('/api/reviews.do', {storeNo: '${param.storeNo}', page:self.currentPage}, function(responseData) {
            var reviewArray = responseData.reviews
            for (var i=0; i<reviewArray.length; i++) {
               self.reviews.push(reviewArray[i]);
            }
         })
      }
   },
   created() {
      var self = this;
      $.getJSON('/api/store.do', {storeNo: '${param.storeNo}'}, function(responseData) {
         self.store = responseData
      })
      
      $.getJSON('/api/reviews.do', {storeNo: '${param.storeNo}', page:self.currentPage}, function(responseData) {
         self.reviews = responseData.reviews
         self.pagination = responseData.pagination
      })
   }
   
})


//토글버튼
$(document).on('click', '.toggleBG', function () {
    var toggleBG = $(this);
    var toggleFG = $(this).find('.toggleFG');
    var left = toggleFG.css('left');
    if(left == '40px') {
        toggleBG.css('background', 'hsl(0, 100%, 90%)');
        toggleActionStart(toggleFG, 'TO_LEFT');
    }else if(left == '0px') {
        toggleBG.css('background', '#ff748c');
        toggleActionStart(toggleFG, 'TO_RIGHT');
    }
});
 
// 토글 버튼 이동 모션 함수
function toggleActionStart(toggleBtn, LR) {
    // 0.01초 단위로 실행
    var intervalID = setInterval(
        function() {
            // 버튼 이동
            var left = parseInt(toggleBtn.css('left'));
            left += (LR == 'TO_RIGHT') ? 5 : -5;
            if(left >= 0 && left <= 40) {
                left += 'px';
                toggleBtn.css('left', left);
            }
        }, 10);
    setTimeout(function(){
        clearInterval(intervalID);
    }, 201);
   
   // 사진리뷰만 보이기, 모두 보이기
   $('#box-section div.section:not(:has(img))').toggle()
    
}


</script>

</body>

</html>