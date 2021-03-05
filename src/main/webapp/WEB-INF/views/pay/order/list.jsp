<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--ㅑ<%include file="" %>--%>
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
	</style>
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col-12">
			<!-- 이자리에 navbar.jsp를 인클루드한다. -->
		</div>
	</div>
	<!-- 주문 내역 시작 -->
	<div class="row mb-3">
		<div class="col-12">
			<div class="card">
				<div class="card-header font-weight-bold">주문 내역</div>
				<div class="card-body">
					<table class="table">
						<thead>
							<tr>
								<th>주문번호</th>
								<th>주문일자</th>
								<th>주문내역</th>
								<th>주문금액</th>
								<th>주문상태</th>
								<th>주문자</th>
								<th>수령자</th>
							</tr>
						</thead>
						<tbody>
						<%
							for(OrderDto2 orderDto : orderDtoList) {
								int orderNo = orderDto.getOrderNo();
								//OrderItemDto oid = orderDao.getOrderItemDto(orderNo); 
								
						%>
							<tr>
								<td><a href="detail.do?orderno="></a></td>
								<td><%=orderDto.getOrderCreatedDate() %></td>
								<td>
								<% 
								if(orderDto.getOrderAmount() > 1) {
								%>
									<a href="detail.jsp?orderno=<%=orderDto.getOrderNo() %>"><%=orderDto.getWineName()%> 외 <%=orderDto.getOrderAmount() - 1 %>종</a>
								<%
								} if(orderDto.getOrderAmount() == 1) {
								%>
									<a href="detail.jsp?orderno=<%=orderDto.getOrderNo() %>"><%=orderDto.getWineName()%></a>
								<%
								}
								%>
								</td>
								<td><%=df.format(orderDto.getTotalPaymentPrice()) %>원</td>
								<td><span class="text-success"><%=orderDto.getOrderStatus() %></span></td>
								<td><%=loginedUserName %></td>
								<td><%=orderDto.getRecipientName() %></td>
							</tr>
						
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<!-- 주문 상품 정보 끝 -->
	
	<div class="row">
		<div class="col-12 mt-3">
			<!-- 이자리에 footer를 include한다. -->
		</div>
	</div>
</div>
</body>
</html>