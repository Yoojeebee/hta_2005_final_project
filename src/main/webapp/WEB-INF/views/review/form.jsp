<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title>리뷰 작성하기</title>
<style>
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
      <div class="col-12">
         <div class="card">
            <div class="card-header">${store.name }</div>
            <div class="card-body">
               <div class="card-title">갈릭스테이크 런치세트x1</div> 
               <div class="cart-text"><small class="text-secondary">이 음식점에 대한 상세한 평가를 해주세요.</small></div>
               <form enctype="multipart/form-data" id="review-form" method="post" action="create.do?storeNo=${storeNo}&orderno=${orderNo}" onsubmit="checkReviewForm(event)">
                  <div class="form-group row">
                     <label class="col-sm-1 col-form-label text-right font-weight-bold">맛</label>
                     <div class="col-sm-3 text-left" id="taste-star-box">
                        <span class="star on" data-taste="1">★</span>
                        <span class="star on" data-taste="2">★</span>
                        <span class="star on" data-taste="3">★</span>
                        <span class="star on" data-taste="4">★</span>
                        <span class="star on" data-taste="5">★</span>
                        <input type="hidden" name="tasteScore" id="taste-score" value="5">
                     </div>
                     <label class="col-sm-1 col-form-label text-right font-weight-bold">양</label>
                     <div class="col-sm-3 text-left" id="quantity-star-box">
                        <span class="star on" data-quantity="1">★</span>
                        <span class="star on" data-quantity="2">★</span>
                        <span class="star on" data-quantity="3">★</span>
                        <span class="star on" data-quantity="4">★</span>
                        <span class="star on" data-quantity="5">★</span>
                        <input type="hidden" name="quantityScore" id="quantity-score" value="5">
                     </div>
                     <label class="col-sm-1 col-form-label text-right font-weight-bold">배달</label>
                     <div class="col-sm-3 text-left" id="delivery-star-box">
                        <span class="star on" data-delivery="1">★</span>
                        <span class="star on" data-delivery="2">★</span>
                        <span class="star on" data-delivery="3">★</span>
                        <span class="star on" data-delivery="4">★</span>
                        <span class="star on" data-delivery="5">★</span>
                        <input type="hidden" name="deliveryScore" id="delivery-score" value="5">
                     </div>
                  </div>
                  <div class="form-group row">
                     <div class="col-sm-12">
                        <textarea rows="5" class="form-control" name="contents" id="review-content" placeholder="사진과 함께 리뷰 작성해야 100포인트 적립가능! 음식에 대한 솔직한 리뷰를 남겨주세요.(10자 이상)"></textarea>
                     </div>
                     <div class="col-sm-12" id="text-cnt">
                        0 / 300
                     </div>
                  </div>
                  <div class="form-group row">
                     <div class="col-sm-11">
                        <input type="file" class="form-control"id="review-photo-1" name="reviewPhoto1">
                     </div>
                     <div class="col-sm-1">
                        <button type="button" name="deleteFile" class="btn btn-danger btn-sm">삭제</button>
                     </div>
                  </div>
                  <div class="form-group row">
                     <div class="col-sm-11">
                        <input type="file" class="form-control"id="review-photo-2" name="reviewPhoto2">
                     </div>
                     <div class="col-sm-1">
                        <button type="button" name="deleteFile" class="btn btn-danger btn-sm">삭제</button>
                     </div>
                  </div>
                  <div class="form-group row">
                     <div class="col-sm-11">
                        <input type="file" class="form-control"id="review-photo-3" name="reviewPhoto3">
                     </div>
                     <div class="col-sm-1">
                        <button type="button" name="deleteFile" class="btn btn-danger btn-sm">삭제</button>
                     </div>
                  </div>
                  <div class="col-12 text-right">
		                <a href="main.do" class="btn btn-secondary">취소</a>
		                <input type="submit" class="btn btn-primary" value="리뷰등록" />
		                <input type="hidden" name="storeNo" value="${param.storeNo }"> 
		                <input type="hidden" name="orderInfo" value="${orderInfo }"> 
		          </div>
               </form>
            </div>
         </div>
      </div>      
    </div>
</div>
<script type="text/javascript">
// textarea 글자수 제한
$(document).ready(function(){
    $('#review-content').on('keyup', function(){
        $('#text-cnt').text($(this).val().length + " / 300");

        if($(this).val().length > 300) {
            $(this).val($(this).val().substring(0, 300));
            $('#text-cnt').text("300 / 300");
        }
    });
});

$(function(){
   
   // 맛 별정 결정하기
   $("#taste-star-box span").click(function() {
      // 현재 선택된 span의 data-taste="숫자"값을 조회한다.
      var score = $(this).data('taste');
      // 조회된 숫자값을 히든 필드에 값으로 설정한다.
      $("#taste-score").val(score);
      // 모든 span태그에서 .on를 제거한다.
      $("#taste-star-box span").removeClass("on");
      // 위에서 조회되 숫자값 만큼 별들이 색칠되게 한다.
      for (var i=0; i<score; i++) {
         $("#taste-star-box span").eq(i).addClass("on");
      }
   });
   
   // 양 별점 결정하기
   $("#quantity-star-box span").click(function() {
      var score = $(this).data('quantity');
      $("#quantity-score").val(score);
      $("#quantity-star-box span").removeClass("on");
      for (var i=0; i<score; i++) {
         $("#quantity-star-box span").eq(i).addClass("on");
      }
   });
   
   // 배달 별점 결정하기
   $("#delivery-star-box span").click(function() {
      var score = $(this).data('delivery');
      $("#delivery-score").val(score);
      $("#delivery-star-box span").removeClass("on");
      for (var i=0; i<score; i++) {
         $("#delivery-star-box span").eq(i).addClass("on");
      }
   });
   
});


//리뷰작성체크
function checkReviewForm(event) {
    var form = document.querySelector("review-form");

    if(!document.querySelector("#food-taste-score").value) {
        alert("맛 점수를 평가해주세요.");
        event.preventDefault();
        return;
    }

    if(!document.querySelector("#food-quantity-score").value) {
        alert("양 점수를 평가해주세요.");
        event.preventDefault();
        return;
    }

    if(!document.querySelector("#food-delivery-score").value) {
        alert("배달 점수를 평가해주세요.");
        event.preventDefault();
        return;
    }

    form.submit();
}
</script>
</body>
</html>