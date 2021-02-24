<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%><!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title>List</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {font-family: Arial;}

/* Style the tab */
.tab {
  overflow: hidden;
  border: 1px solid #ccc;
  background-color: #f1f1f1;
}

/* Style the buttons inside the tab */
.tab button {
  background-color: inherit;
  border: none;
  outline: none;
  cursor: pointer;
  padding: 14px 16px;
  transition: 0.3s;
  font-size: 17px;
}

/* Change background color of buttons on hover */
.tab button:hover {
  background-color: #ddd;
}

/* Create an active/current tablink class */
.tab button.active {
  background-color: #ccc;
}

/* Style the tab content */
.tabcontent {
  display: none;
  padding: 6px 12px;
  border: 1px solid #ccc;
  border-top: none;
}

.img-thumbnail {
    padding: .25rem;
    background-color: #fff;
    border: 0 !important;
    border-radius: .25rem;
    max-width: 200%;
    height: auto;
}
</style>
</head>
<body>
<div class="row">
	<div class="col-12">
		<%@ include file="../../common/navbar.jsp" %>
	</div>
</div>
<div class="tab text-center">
	<button type="button" class="btn" onclick="toggleShowField()">
    	<i class="fa fa-search" style="font-size:24px"></i>
    </button>
	<button class="tablinks ${param.ctgno eq 1 ? 'active' : '' }" onclick="changeCategory(1)">전체보기</button>
	<button class="tablinks ${param.ctgno eq 2 ? 'active' : '' }" onclick="changeCategory(2)">1인분</button>
	<button class="tablinks ${param.ctgno eq 3 ? 'active' : '' }" onclick="changeCategory(3)">프랜차이즈</button>
	<button class="tablinks ${param.ctgno eq 4 ? 'active' : '' }" onclick="changeCategory(4)">치킨</button>
	<button class="tablinks ${param.ctgno eq 5 ? 'active' : '' }" onclick="changeCategory(5)">한식</button>
	<button class="tablinks ${param.ctgno eq 6 ? 'active' : '' }" onclick="changeCategory(6)">피자/양식</button>
	<button class="tablinks ${param.ctgno eq 7 ? 'active' : '' }" onclick="changeCategory(7)">중국집</button>
	<button class="tablinks ${param.ctgno eq 8 ? 'active' : '' }" onclick="changeCategory(8)">일식/돈까스</button>
	<button class="tablinks ${param.ctgno eq 9 ? 'active' : '' }" onclick="changeCategory(9)">족발/보쌈</button>
	<button class="tablinks ${param.ctgno eq 10 ? 'active' : '' }" onclick="changeCategory(10)">분식</button>
	<button class="tablinks ${param.ctgno eq 11 ? 'active' : '' }" onclick="changeCategory(11)">야식</button>
	<button class="tablinks ${param.ctgno eq 12 ? 'active' : '' }" onclick="changeCategory(12)">카페/디저트</button>
	<button class="tablinks ${param.ctgno eq 13 ? 'active' : '' }" onclick="changeCategory(13)">배달/마트</button>
</div>
<div style="display:none; position:absolute; z-index:100; top:393px; left:10px;" id="box-search">
   <input type="search" class="form-control" id="field-search-keyword" style="width: 350px;">
</div>
<div class="container">
	<div class="row mt-3">
    	<div class="col-12">
        	<select onchange="changeSort()" name="selBox" class="form-control float-right" id="select-sort" style="width: 200px;">
              <option value="basic" ${empty param.sort or param.sort eq 'basic' ? 'selected' : '' }>기본 정렬순</option>   
              <option value="review" ${param.sort eq 'review' ? 'selected' : '' }>리뷰 많은순</option>
              <option value="minPrice" ${param.sort eq 'minPrice' ? 'selected' : '' }>최소주문금액순</option>
			</select>
        </div>
    </div>
    
    <div class="row mt-2">
    	<div class="col-12">
        	<div class="card">
    			<div style="display:none;" class="card-header">우리동네 플러스</div>
                <div class="card-body">
                	<div class="row p-1">
		                <c:forEach var="store" items="${stores}">
	                    	<div class="col-6 ">
                    			<a href="/des.do?storeNo=${store.no }">
	                        	<div class="row p-2 border m-2">
	                            	<div class="col-2 border p-3">
	                            		<img class="img-thumbnail" src="static/resource/images/${store.thumbnail }">
	                            	</div>
	                                <div class="col-10 p-3">
	                                	<h5>${store.name }</h5>
	                                	<div><span style="color: orange;">★</span> ${store.avg } ㅣ 리뷰 ${store.reviewAcc } ㅣ 사장님 댓글 ${store.ownerAcc }</div>
	                                    <div><span style="color: red;">요기서 결제</span> ㅣ ${store.minPrice }원</div>
	                                </div>
	                            </div>
                        	</a>
	                        </div>
		                </c:forEach>
                    </div>
                </div>
  			</div>
        </div>
    </div>
    
    <div class="row mt-2">
    	<div class="col-12">
        	<div class="card">
    			<div style="display:none;" class="card-header">슈퍼레드위크 추천</div>
    				<div class="card-body">
	                	<div class="row p-1">
		    				<c:forEach var="store" items="${stores}">
		                    	<div class="col-6 ">
                          		<a href="/des.do?store=${store.no }">
		                        	<div class="row p-2 border m-2">
		                            	<div class="col-2 border p-3">
		                            		<img class="img-thumbnail" src="static/resource/images/${store.thumbnail }">
		                            	</div>
		                                <div class="col-10 p-3">
		                                	<h5>${store.name }</h5>
		                                	<div><span style="color: orange;">★</span> ${store.avg } ㅣ 리뷰 ${store.reviewAcc } ㅣ 사장님 댓글 ${store.ownerAcc }</div>
		                                    <div><span style="color: red;">요기서 결제</span> ㅣ ${store.minPrice }원</div>
		                                </div>
		                            </div>
                                </a>
		                        </div>
		                	</c:forEach>
	                    </div>
  				</div>
        	</div>
    	</div>
    </div>
        <div class="row mt-2">
    	<div class="col-12">
        	<div class="card">
    			<div style="display:none;" class="card-header">요기요 등록 음식점</div>
                    <div class="card-body">
                	<div class="row p-1">
	                    <c:forEach var="store" items="${stores}">
	                    	<div class="col-6 ">
                       		<a href="/des.do?store=${store.no }">
	                        	<div class="row p-2 border m-2">
	                            	<div class="col-2 border p-3">
	                            		<img class="img-thumbnail" src="static/resource/images/${store.thumbnail }">
	                             	</div>
	                                <div class="col-10 p-3">
	                                	<h5>${store.name }</h5>
	                                	<div><span style="color: orange;">★</span> ${store.avg } ㅣ 리뷰 ${store.reviewAcc } ㅣ 사장님 댓글 ${store.ownerAcc }</div>
	                                    <div><span style="color: red;">요기서 결제</span> ㅣ ${store.minPrice }원</div>
	                                </div>
	                            </div>
                            </a>
	                        </div>
	                   </c:forEach>                
                    </div>
  				</div>
        	</div>
    	</div>
    </div>
    
	<c:if test="${page.totalPages ne 0 }">
	    <div class="row mt-2">
			<div class="col-12">
				<ul class="pagination justify-content-center">
			  		<li class="page-item ${pageNo gt 1 ? '' : 'disabled' }">
			  			<a onclick="changePage(event, ${pageNo - 1 })" class="page-link" href="#">이전</a>
			  		</li>
			  		<c:forEach var="num" begin="${page.beginPage }" end="${page.endPage }">
				  		<li class="page-item ${num eq page.pageNo ? 'active' : '' }">
				  			<a onclick="changePage(event, ${num })" class="page-link" href="#">${num }</a>
				  		</li>
			  		</c:forEach>
			  		<li class="page-item ${page.pageNo lt page.totalPages ? '' : 'disabled' }">
			  			<a onclick="changePage(event, ${page.pageNo + 1 })" class="page-link" href="#">다음</a>
			  		</li>
				</ul>
			</div>
		</div>
	</c:if>
</div>


<script type="text/javascript">
/*
	function changeAddress() {
		// 주소 입력칸의 값을 읽어서 input의 adderss을 설정
		// form-list의 모든 입력값을 제출한다.
		var address = $("#field-keyword").val();
		if (address == "") {
			alert("주소를 입력하세요");
			return false;
		}
		$("#a").val(address);
		$("#p").val(1);
		$("#form-search").submit();
	}
*/
	
	function changeCategory(ctgno) {
		// 전달받은 no를 숨겨진 input의 ctgno값을 설정
		// form-list의 모든 입력값을 제출한다.
		$("#c").val(ctgno);
		$("#p").val(1);
		$("#form-search").submit();
	}
	function changeSort() {
		// select의 현재 선택된 값을 읽어서 숨겨진 input에 sort값을 설정
		// form-list의 모든 입력값을 제출한다.
		var sort = $("#select-sort").val();
		
		$("#s").val(sort);
		$("#p").val(1);
		$("#form-search").submit();
	}
	function changePage(event, page) {
		// 전달받은 page 값을 읽어서 input에 page값을 설정
		// form-list의 모든 입력값을 제출한다.
		event.preventDefault();
		$("#p").val(page);
		$("#form-search").submit();
	}
	
	function toggleShowField() {
		$("#box-search").toggle();
	}
	
	$('#field-search-keyword').keyup(function(event) {
		if (event.which == 13) {
			var keyword = $(this).val();
			if (keyword == "") {
				alert('키워드를 입력하세요');
				return false;
			}
			
			$("#k").val(keyword);
			$("#form-search").submit();
		}
	})

</script>
</body>
</html>