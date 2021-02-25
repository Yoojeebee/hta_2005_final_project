<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
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
<title>리뷰</title>
</head>
<body>
<div class="container">
	<ul class="nav nav-tabs">
		<li class="nav-item"><a class="nav-link active" data-toggle="tab" href="#Store">메뉴</a></li>
		<li class="nav-item"><a class="nav-link"  data-toggle="tab" href="#Review">클린리뷰</a></li>
		<li class="nav-item"><a class="nav-link"  data-toggle="tab" href="#Info">정보</a></li>
	</ul>
   
	<div class="tab-content">
		<div class="tab-pane container active" id="Store">
        	<h3>메뉴</h3>
        	<p>가게의 각종 메뉴 목록</p>
    	</div>
    <div class="tab-pane container fade" id="Review">
    	<div class="row">
        	<div class="col-5 text-right pb-2">
                  <div>
                      <strong class="display-3">${store.avg }</strong>
                  </div>
                  <div id="avg-star-box">
                  	<c:forEach begin="1" end="${store.avg }" >
                        <span class="star on">★</span>
                  	</c:forEach>
                  	<c:forEach begin="1" end="${5 - store.avg}">
                        <span class="star">★</span>
                  	</c:forEach>
                  </div>
              </div>
              <div class="col-7 pt-3">
                  <table>
                      <tr>
                          <td>맛</td>
                          <td>
                              <div id="taste-star-box">
                                  <c:forEach begin="1" end="${store.taste }" >
				                      <span class="star on">★</span>
				                  </c:forEach>
				                  <c:forEach begin="1" end="${5 - store.taste}">
				                      <span class="star">★</span>
				                  </c:forEach>
                              </div>
                          </td>
                      </tr>
                      <tr>
                          <td>양</td>
                          <td>
                              <div id="quantity-star-box">
                                  <c:forEach begin="1" end="${store.quality }" >
				                      <span class="star on">★</span>
				                  </c:forEach>
				                  <c:forEach begin="1" end="${5 - store.quality}">
				                      <span class="star">★</span>
				                  </c:forEach>
                              </div>
                          </td>
                      </tr>
                      <tr>
                          <td>배달</td>
                          <td>
                              <div id="delivery-star-box">
                                  <c:forEach begin="1" end="${store.delivery }" >
				                      <span class="star on">★</span>
				                  </c:forEach>
				                  <c:forEach begin="1" end="${5 - store.delivery}">
				                      <span class="star">★</span>
				                  </c:forEach>
                              </div>
                          </td>
                	  </tr>
            	</table>
        	</div>
        </div>
        <div class="row mt-3 d-flex justify-content-between p-3">
           	 <div>
                 리뷰 <strong>${store.reviewAcc }</strong>개 사장님댓글 <strong>${store.ownerAcc}</strong>개
             </div>
             <!--사진리뷰만 보여주는 토글버튼-->
             <div class="toggleBG" id="btn-photoReview"><button class="toggleFG"></button></div>
        </div>
        <div class="row mt-3 d-flex justify-content-between p-3">
             <!-- 임시로 링크 설정 -->
       		<div class="col-12 text-center mb-3">
                 <a href="form.do?storeNo=${param.storeNo }" class="btn btn-outline-primary btn-sm">리뷰작성</a>
             </div>
        </div>
        <div id="box-section">
	        <c:forEach var="review" items="${reviews }">
	        	<div class="row border my-3 p-3 section" >
		            <div class="col-12 mb-3">
		            	<div class="text-left pb-2">
		                	<strong>${review.userNo }</strong>님 <small style="color:gray"><fmt:formatDate value="${review.reviewCreatedDate }"/></small>
		                </div>
		                <div class="text-right pb-2">
	                   		<a href="commentform.do?storeNo=${param.storeNo }&reviewNo=${review.no}&ownerNo=${store.ownerNo}" class="btn btn-outline-primary btn-sm">코멘트작성</a>
	                   		<a href="delete.do?storeNo=${param.storeNo }&reviewNo=${review.no}" class="btn btn-outline-primary btn-sm">리뷰삭제</a>
		                </div>
					</div>
					<div class="col-3 mb-3">
	                    <div id="avg-star-box">
	                    	<c:forEach begin="1" end="${review.avgScore }">
	                    		<span class="star on">★</span>
	                    	</c:forEach>
	                    	<c:forEach begin="1" end="${5 - review.avgScore }">
	                    		<span class="star">★</span>
	                    	</c:forEach>
	                    </div>
	                </div>
	                <div class="col-7">
	                    <small style="color:gray">맛</small>
	                    <span>★</span><strong class="text-warning">${review.tasteScore }</strong>
	                    <small style="color:gray">양 </small>          
	                    <span>★</span><strong class="text-warning">${review.quantityScore }</strong>
	                    <small style="color:gray">배달 </small>          
	                    <span>★</span><strong class="text-warning">${review.deliveryScore }</strong>
	                </div>
	                <c:if test="${not empty review.photo1}">
		                <div class="col-12 mb-3">
		                    <img src="/static/resource/images/${review.photo1 }" alt="리뷰사진1" style="max-width: 100%;">
		                </div>
	                </c:if>
	                <c:if test="${not empty review.photo2}">
		                <div class="col-12 mb-3">
		                    <img src="/static/resource/images/${review.photo2 }" alt="리뷰사진2" style="max-width: 100%;">
		                </div>
	                </c:if>
	                <c:if test="${not empty review.photo3}">
		                <div class="col-12 mb-3">
		                    <img src="/static/resource/images/${review.photo3 }" alt="리뷰사진3" style="max-width: 100%;">
		                </div>
	                </c:if>
	                <div class="col-12 mb-3">
	                    <small style="color: #e5b996">
	                        사용자가 주문한 메뉴 목록이 쭉 보인다
	                        <button class="btn btn-primary btn-sm"><i class="fa fa-angle-down"></i></button>
	                        <button class="btn btn-primary btn-sm"><i class="fa fa-angle-up"></i></button>
	                    </small>
	                </div>
	                <div class="col-12 mb-3">
	                    ${review.contents }
	                </div>
	                <c:if test="${not empty review.ownerComment}">
		                <div class="col-12 mb-3">
		                    <div class="text-left pb-2">
		                        <strong>사장님</strong><small>${review.ownerReviewCreatedDate }</small>
		                        <p>${review.ownerReviewCreatedDate }</p>
		                        <div>
		                            ${review.ownerComment }
		                        </div>
		                    </div>
		                </div>
	                </c:if>
	            </div>
			</c:forEach>
		</div>
		<!-- 페이지처리 -->
		<p>${page }</p>
              <div class="row">
                 <div class="col-12">
                    <ul class="pagination justify-content-center">
                         <li class="page-item ${pageNo gt 1 ? '' : 'disabled' }">
                            <a class="page-link" href="main.do?storeno=${param.storNo }&picture=${empty param.picture ? 'A' : param.picture }&pageno=${pageNo - 1 }">이전</a>
                         </li>
                         <c:forEach var="num" begin="${page.beginPage }" end="${page.endPage }">
                            <li class="page-item ${num eq page.pageNo ? 'active' : '' }">
                               <a class="page-link" href="main.do?storeno=${param.storeNo }&picture=${empty param.picture ? 'A' : param.picture }&pageno=${num }">${num }</a>
                            </li>
                         </c:forEach>
                         <li class="page-item ${page.pageNo lt page.totalPages ? '' : 'disabled' }">
                            <a class="page-link" href="main.do?storeno=${param.storeNo }&picture=${empty param.picture ? 'A' : param.picture }&pageno=${page.pageNo + 1 }&">다음</a>
                         </li>
                    </ul>
                 </div>
              </div> 
    	</div>
    	
   		<div class="tab-pane container fade" id="Info">
	    	<h3>정보</h3>
	    	<p>오픈시간: 09:00 am ~ 23:00 pm</p>
		</div>
   </div>
</div>
<script type="text/javascript">
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