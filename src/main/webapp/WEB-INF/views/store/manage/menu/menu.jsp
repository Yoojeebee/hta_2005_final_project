<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../../../common/taglib.jsp"%>
<!DOCTYPE html>
<html>

<head>
	<title>Menu</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" href="/static/resource/css/store/manage.css" />
	<style>
	.menu {
		width: 100%;
		height: 100%;
		background-color: white;
		border: 1px solid grey;
	}
	
	.menu:focus {
		border: 1px solid grey;
		outline: none;
	}
	</style>
</head>

<body>

	<div class="container">
		<div class="row">
			<div class="col-12">
				<h1>${name}</h1>
			</div>
		</div>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-12">
				<h1>메인 메뉴</h1>
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#myModal">메뉴 추가</button>
			</div>
		</div>
		<hr />
	</div>

	<%--  메뉴 추가  --%>
	<div class="container">
		<xdiv class="row">
		<div class="col-12">
			<%@ include file="menuAdd.jsp"%>
		</div>
		</xdiv>
	</div>

	<%-- 가게 메뉴 출력 및 업데이트 --%>
	<c:forEach var="item" items="${menu}" varStatus="status">
		<%@ include file="storeMenu.jsp"%>
		<%@ include file="storeMenuUpdate.jsp"%>
	</c:forEach>
	<br />

	<div class="container">
		<div class="row">
			<div class="col-12">
				<h1>옵션 메뉴</h1>
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#modalOpt">사이드 메뉴 추가</button>
				<hr />
			</div>
		</div>
	</div>

	<%-- 옵션 메뉴 추가 --%>
	<div class="container">
		<div class="row">
			<div class="col-12">
				<%@ include file="optionMenuAdd.jsp"%>
			</div>
		</div>
	</div>

	<c:forEach var="opt" items="${optionMenu}">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <ul class="list-group">
                        <button type="button" class="menu" style="width: auto; border: 0;">

                            <li class="list-group-item" style="text-align: left;">${opt.optionName}</li>

                            <li class="list-group-item">
                                <div class="row">
                                    <div class="col-md-12">
                                        <div style="width: 80px; height: 80px; float: left; border: 1px solid black; overflow: hidden;">
                                            <img src="/static/resource/images/store/${ownerNo}/${storeNo}/optionMenu/${opt.optionThumbnail}" style="width: 100%; height: 100%; object-fit: fill;">
                                        </div>

                                        <p>${opt.optionPrice}</p>
                                    </div>
                                </div>
                            </li>

                        </button>
                    </ul>
                </div>
            </div>
        </div>
    </c:forEach>



	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/vue/2.5.15/vue.js"></script>
	<script type="text/javascript" src="/static/resource/javascript/store/menu.js"></script>
</body>

</html>

