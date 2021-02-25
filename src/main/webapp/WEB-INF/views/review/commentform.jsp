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
<title>코멘트작성하기</title>
<style>
.star {
    font-size: 2rem;
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
               <div class="card-title">사용자가 주문한 메뉴들</div> 
               <div class="cart-text"><small class="text-secondary">이 주문에 대한 리뷰입니다.</small></div>
               <form id="comment-form" method="post" 
               			action="createComment.do?reviewNo=${review.no }&ownerNo=${store.ownerNo}&storeNo=${store.no}" 
               			onsubmit="checkCommentForm(event)">
               			<p>${store.ownerNo}</p>
                  <div class="form-group row">
                     <label class="col-sm-1 col-form-label text-right font-weight-bold">맛</label>
                     <div class="col-sm-3 text-left" id="taste-star-box">
                        <c:forEach begin="1" end="${review.tasteScore }" >
	                        <span class="star on">★</span>
	                    </c:forEach>
	                    <c:forEach begin="1" end="${5 - review.tasteScore}">
	                        <span class="star">★</span>
                  		</c:forEach>
                     </div>
                     <label class="col-sm-1 col-form-label text-right font-weight-bold">양</label>
                     <div class="col-sm-3 text-left" id="quantity-star-box">
                        <c:forEach begin="1" end="${review.quantityScore }" >
	                        <span class="star on">★</span>
	                    </c:forEach>
	                    <c:forEach begin="1" end="${5 - review.quantityScore}">
	                        <span class="star">★</span>
                  		</c:forEach>
                     </div>
                     <label class="col-sm-1 col-form-label text-right font-weight-bold">배달</label>
                     <div class="col-sm-3 text-left" id="delivery-star-box">
                        <c:forEach begin="1" end="${review.deliveryScore }" >
	                        <span class="star on">★</span>
	                    </c:forEach>
	                    <c:forEach begin="1" end="${5 - review.deliveryScore}">
	                        <span class="star">★</span>
                  		</c:forEach>
                     </div>
                  </div>
                  <div class="form-group row">
                     <div class="col-sm-12">
                        <textarea rows="5" class="form-control" name="contents" id="review-content" readonly>${review.contents }</textarea>
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
		                <a href="main.do" class="btn btn-secondary">취소</a>
		                <input type="submit" class="btn btn-primary" value="코멘트등록" />
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