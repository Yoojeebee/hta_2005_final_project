<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../../../common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title>Template</title>
<style type="text/css">
.btn-group-xs > .btn, .btn-xs {
	padding: .45rem .4rem;
	font-size: .875rem;
	line-height: .5;
	border-radius: .2rem;
}
#total-price {
	color: #ff0055;
	font-weight: bold;
}
#order-info {
	color: white;
	font-weight: bold;
	background-color: rgb(50, 50, 50);
}
#item-head {
	background: rgb(243, 243, 243);
	font-size: 17px;
	font-weight: bold;
}
#item-body {
	background: #fff5e5;
}
</style>
</head>
<body>
<%@ include file="../../../common/navbar.jsp" %>
<div class="container">
	<!-- 주문 상품 정보 시작 -->
	<div class="row mb-3">
	<div class="col-12">&nbsp;</div>
	<div class="col-12">&nbsp;</div>
		<div class="col-12">
			<div class="card">
				<div class="card-header" id="order-info">주문 상세 정보</div>
				<div class="card-body">
					<table class="table table-bordered">
						<colgroup>
							<col width="18%">
							<col width="32%">
							<col width="18%">
							<col width="32%">
						</colgroup>
						<tbody>
							<tr>	
								<th>주문번호</th><td><strong>${order.no }</strong></td>
								<th>주문상태</th>
								<c:if test="${order.status eq 'Y' }">
									<td class="text-success">결제완료</td>
								</c:if>
								<c:if test="${order.status eq 'N' }">
									<td class="text-warning">결제대기</td>
								</c:if>
							</tr>
							<tr>
								<th>주문일자</th>
								<td><fmt:formatDate value="${order.createdDate }" pattern="yyyy-MM-dd HH:mm"/></td>
								<th>주문하신 분</th><td>${userName }</td>
							</tr>
							<tr>
								<!-- 안심번호 있으면 안심번호, 없으면 핸드폰번호 -->
								<th>받으시는 분 연락처</th>
								<c:if test="${empty order.safeNum }">
									<td>${order.recipientTel }</td>
								</c:if>
								<c:if test="${not empty order.safeNum }">
									<td>${order.safeNum }</td>
								</c:if>
								<th>주문한 가게</th>
								<td>${dto.storeName }</td>
							</tr>
							<tr>
								<th>배송주소</th>
								<td colspan="3">${order.recipientAddress }&nbsp;${order.recipientAddressDetail }</td>
							</tr>
							<tr>
								<th>요청사항</th><td>${order.message }</td>
								<th>리뷰쓰기</th>
								<c:if test="${dto.reviewNo eq 0}">
									<td>
										<a href="../review/form.do?storeNo=${dto.storeNo }&orderno=${dto.no}" class="btn btn-outline-primary btn-sm">리뷰작성</a>
									</td>
								</c:if>
								<c:if test="${dto.reviewNo ne 0}">
									<td>
										<a href="" class="btn btn-outline-secondary btn-sm disabled">작성완료</a>
									</td>
								</c:if>
							</tr>
							<tr>
								<th>결제금액</th><td id="total-price"><fmt:formatNumber value="${order.totalOrderPrice }" pattern="##,###"></fmt:formatNumber>원</td>
								<th>결제방법</th>
								<c:if test="${order.paymentMethod eq '1' }">
									<td>(직접결제)카드결제</td>
								</c:if>
								<c:if test="${order.paymentMethod eq '2' }">
									<td>(직접결제)현금결제</td>
								</c:if>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="card-body">
					<table class="table">
						<colgroup>
							<col width="70%">
							<col width="10%">
							<col width="10%">
							<col width="10%">
						</colgroup>
						<thead>
							<tr id="item-head">
								<th>상품명</th>
								<th>가격</th>
								<th>수량</th>
								<th>합계</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach var="dto" items="${dtoList }">
							<tr id="item-body">
								<td>
									${dto.storeMenuName }: ${dto.orderItemOptionMenuNames }
								</td>
								<td><fmt:formatNumber value="${dto.orderItemPrice }" pattern="##,###"></fmt:formatNumber>원</td>
								<td>${dto.orderItemAmount }개</td>
								<td><strong><fmt:formatNumber value="${dto.orderItemPrice*dto.orderItemAmount }" pattern="##,###"></fmt:formatNumber>원</strong></td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div class="col-12">&nbsp;</div>
		<div class="col-12">&nbsp;</div>
	</div>
	<!-- 주문 상품 정보 끝 -->
</div>
<%@include file="../../../common/footer.jsp" %>
</body>
</html> 