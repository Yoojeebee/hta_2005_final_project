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
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<title>코멘트작성하기</title>
<style>
.star {
    font-size: 2rem;
    color: orange;
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
<div id="commentform" class="container">
   <div class="row">
      <div class="col-12">
         <div class="card">
            <div class="card-header">{{store.name }}</div>
            <div class="card-body">
               <div class="card-title">사용자가 주문한 메뉴들</div> 
               <div class="cart-text"><small class="text-secondary">이 주문에 대한 리뷰입니다.</small></div>
               <form id="comment-form" method="post" 
               			v-bind:action="'createComment.do?reviewNo=' + review.no +
               			'&ownerNo=' + store.ownerNo + '&storeNo=' + store.no" 
               			onsubmit="checkCommentForm(event)">
                  <div class="form-group row">
                     <label class="col-sm-1 col-form-label text-right font-weight-bold">맛</label>
                     <div class="col-sm-3 text-left" id="taste-star-box">
                        <span v-for="i in review.tasteScore" class="star on">★</span>
	                    <span v-for="x in (5-review.tasteScore)" class="star">★</span>
                     </div>
                     <label class="col-sm-1 col-form-label text-right font-weight-bold">양</label>
                     <div class="col-sm-3 text-left" id="quantity-star-box">
                        <span v-for="i in review.quantityScore" class="star on">★</span>
                        <span v-for="x in (5-review.quantityScore)" class="star">★</span>
                     </div>
                     <label class="col-sm-1 col-form-label text-right font-weight-bold">배달</label>
                     <div class="col-sm-3 text-left" id="delivery-star-box">
                        <span v-for="i in review.deliveryScore" class="star on">★</span>
                        <span v-for="x in (5-review.deliveryScore)" class="star">★</span>
                     </div>
                  </div>
                  <div class="form-group row">
                     <div class="col-sm-12">
                        <textarea rows="5" class="form-control" name="contents" id="review-content" readonly>{{review.contents }}</textarea>
                     </div>
                  </div>
                  <div class="form-group row">
                    <div class="col-sm-12">
                       <textarea rows="5" class="form-control" name="ownerComment" id="review-comment" placeholder="이 리뷰에 대한 댓글을 작성해주세요.(10자 이상)"></textarea>
                    </div>
                    <div class="col-sm-12">
                       <small><span id="text-cnt">0/300</span> 글자</small>
                    </div>
                 </div>
                 <div class="col-12 text-right">
		                <a href="../store/des.do" class="btn btn-secondary">취소</a>
		                <input type="submit" class="btn btn-primary" value="코멘트등록" />
		         </div>
               </form>
            </div>
         </div>
      </div>      
    </div>
</div>
<script type="text/javascript">
// 리뷰정보 나타내기
var app = new Vue({
	el:"#commentform",
	data: {
		store:{},
		review:{}
	},
	created() {
		var self = this;
	    $.getJSON('/api/store.do', {storeNo: '${param.storeNo}'}, function(response) {
	         console.log('가게정보', response)
	         self.store = response
	         console.log(self.store)
	    })
	      
	    $.getJSON('/api/review.do', {reviewNo: '${param.reviewNo}'}, function(response) {
	         console.log('리뷰정보', response)
	         self.review = response
	    })
	}
})

// textarea 글자수 제한
$(document).ready(function(){
    $('#review-comment').on('keyup', function(){
        $('#text-cnt').text($(this).val().length + " / 300");

        if($(this).val().length > 300) {
            $(this).val($(this).val().substring(0, 300));
            $('#text-cnt').text("300 / 300");
        }
    });
});

//코멘트작성체크
function checkCommentForm(event) {
    var form = document.querySelector("comment-form");

    if(!document.querySelector("#review-comment").value) {
        alert("이 리뷰에 대한 코멘트를 작성해주세요.");
        event.preventDefault();
        return;
    }
    
    form.submit();
}
</script>
</body>
</html>