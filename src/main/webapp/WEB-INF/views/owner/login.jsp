<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <title>login</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/vue/2.5.15/vue.js"></script>
</head>

<body>

	<div id="checkLogin" class="container border"
		style="margin: 0; position: absolute; top: 50%; left: 50%; transform: translate(-50%, -50%);">
		<form id="join" @submit="login" action="/store/home" method="POST" autocomplete="off">
			<div class="row text-left" style="width: 100%; float: none; margin: 0 auto">
				<div class="col-sm-8">
					<div class="form-group row">
						<label for="staticEmail" class="col-sm-2 col-form-label">Email</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="id" id="id" placeholder="아이디를 입력하세요.">
						</div>
					</div>
					<div class="form-group row">
						<label for="inputPassword" class="col-sm-2 col-form-label">Password</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" name="password" id="password" placeholder="비밀번호를 입력하세요.">
						</div>
					</div>
				</div>


				<div class="col-sm-2">
					<button style="height: 100%;" type="sumit" class="btn btn-outline-dark">로그인</button>
				</div>
			</div>
			
			<div class="row">
				<div class="col-sm-12">
					<label class="col-sm-12 col-form-label">{{status}}</label>
				</div>
			</div>
		</form>

		<div class="row text-left" style="width: 100%; float: none; margin: 0 auto">
			<a href="/owner/joinOwner">회원가입</a>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script type="text/javascript" src="/static/resource/vue/owner/checkLogin.js"></script>
</body>
</html>
