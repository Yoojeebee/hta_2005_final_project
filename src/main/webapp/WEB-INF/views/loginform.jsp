<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
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
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
<title>login</title>
</head>
<body>
	<div class="row">
		<div class='col-12'>
			<%@ include file="../common/navbar.jsp" %>
		</div>
	</div>
<div class="container">
	<c:if test="${param.error eq 'empty' }">
	<div class="row">
		<div class="col-6 offset-3">
			<div class="alert alert-danger">
				<strong>오류</strong> 아이디와 비밀번호는 필수 입력값입니다.
			</div>
		</div>
	</div>
	</c:if>
	<c:if test="${param.error eq 'notfound' or param.error eq 'mismatch' }">
	<div class="row">
		<div class="col-6 offset-3">
			<div class="alert alert-danger">
				<strong>오류</strong> 아이디 혹은 비밀번호가 올바르지 않습니다.
			</div>
		</div>
	</div>
	</c:if>
	<c:if test="${param.error eq 'deny' }">
	<div class="row">
		<div class="col-6 offset-3">
			<div class="alert alert-danger">
				<strong>오류</strong> 로그인이 필요한 서비스에 접속을 시도하였습니다.
			</div>
		</div>
	</div>
	</c:if>
	
	<div class="row m-3">
	   <div class="col-8 offset-2">
	      <div class="card  w3-container  w3-light-grey w3-text-red w3-margin p-3">
			<form id="user-form" class="p-3" method="post" action="login.do" enctype="multipart/form-data" onsubmit="checkLoginForm(event)" >
				<h2 class="w3-center">로그인</h2>
				<div class="form-row">
					<div class="form-group col-12">
					  <div class="w3-col" style="width:50px"><i class=" fab fa-keybase" style='font-size:40px'></i></div>
					    <div class="w3-rest">
					      <input class="w3-input w3-border" id="user-id" name="id" type="text" placeholder="id">
					    </div>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-12">
					  <div class="w3-col" style="width:50px"><i class="fas fa-key" style='font-size:40px'"></i></div>
					    <div class="w3-rest">
					      <input class="w3-input w3-border" id="user-password" name="password" type="password" placeholder="Password">
					    </div>
					</div>
				</div>
				<div class="text-right">
					<a href="form.do" class="btn btn-outline-success">회원가입</a>
					<a href="home.do" class="btn btn-outline-danger">취소</a>
					<input type="submit" class="btn btn-outline-primary" value="로그인" />
				</div>
			</form>
		</div>
	</div>
</div>
</div>
   <div class="row">
      <div class="col-12">
         <%@ include file="../common/footer.jsp" %>
      </div>
   </div>
<script type="text/javascript">
	function checkLoginForm(event) {
		var form = document.querySelector("user-form");

		if (!document.querySelector("#user-id").value) {
			alert("아이디은 필수입력값입니다.");
			event.preventDefault();
			return;
		}


		if (!document.querySelector("#user-password").value) {
			alert("비밀번호는 필수입력값입니다.");
			event.preventDefault();
			return;
		}

		form.submit();
	}
</script>
</body>
</html>