<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../../../common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<title>Bootstrap 4 Example</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<style type="text/css">
		.btn-group-xs > .btn, .btn-xs {
		  padding: .45rem .4rem;
		  font-size: .875rem;
		  line-height: .5;
		  border-radius: .2rem;
		}
		#order-hist-head {
		 color: white;
		 font-weight: bold;
		 background-color: #414141;
		}
	</style>
</head>
<body>
<%@ include file="../../../common/navbar.jsp" %>
<div class="container">
	<!-- 주문 내역 시작 -->
	<div class="row mb-3">
	<div class="col-12">&nbsp;</div>
	<div class="col-12">&nbsp;</div>
	<div class="col-12">&nbsp;</div>
		<div class="col-12">
			<div class="card">
				<div class="card-header" id="order-hist-head">주문 내역</div>
				<div class="card-body">
					<table class="table">
						<thead>
							<tr>
								<th>주문번호</th>
								<th>주문일자</th>
								<th>주문내역</th>
								<th>주문금액</th>
								<th>주문상태</th>
								<th>주문주소</th>
								<th>결제방법</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach var="dto" items="${dtoList }">
							<tr>
								<td><a href="detail.do?orderno=${dto.no }">${dto.no }</a></td>
								<td><fmt:formatDate value="${dto.createdDate }" pattern="yyyy-MM-dd"/> </td>
								<c:if test="${dto.count eq 1 }">
									<td><a href="detail.do?orderno=${dto.no }">${dto.storeMenuName }</a></td>
								</c:if>
								<c:if test="${dto.count gt 1 }">
									<td><a href="detail.do?orderno=${dto.no }">${dto.storeMenuName } 외 ${dto.count -1}개</a></td>
								</c:if>
								<td><fmt:formatNumber value="${dto.totalOrderPrice }" pattern="##,###"></fmt:formatNumber>원</td>
								<c:if test="${dto.status eq 'Y'}">
									<td><span class="text-success">결제완료</span></td>
								</c:if>
								<c:if test="${dto.status eq 'N' }">
								<td><span class="text-warning">결제대기</span></td>
								</c:if>
								<td>${dto.recipientAddress }</td>
								<c:if test="${dto.paymentMethod eq '1' }">
									<td>카드결제</td>
								</c:if>
								<c:if test="${dto.paymentMethod eq '2' }">
									<td>현금결제</td>
								</c:if>
							</tr>
						</c:forEach>
						<!-- 주문 상품 정보 반복 끝 -->
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div class="col-12">&nbsp;</div>
		<div class="col-12">&nbsp;</div>
		<div class="col-12">&nbsp;</div>
	</div>
</div>
<%@include file="../../../common/footer.jsp" %>
</body>
</html>