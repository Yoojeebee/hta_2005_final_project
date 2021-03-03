<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file = "../../common/taglib.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>

<head>
    <title>Detail</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="/static/resource/css/store/manage.css" />
    <style>
        .nav-item {
            width: 33.3%;
            /*border-bottom: 2px solid grey;*/
        }
        .nav-link {
            color: black;
        }
        .nav-link:hover {
            color: black;
        }
        .nav-tabs .nav-link {
            border: 0;
        }

        .navbar-nav > li {
            float: left;
            position: relative;
        }
        .navbar-light .navbar-nav .active a::after {
            border-bottom: 5px solid #5bc0eb;
            bottom: -10px;
            content: " ";
            left: 0;
            position: absolute;
            right: 0;
        }

        .menu {
            width: 100%;
            background-color: white;
            border: 1px solid grey;
        }
        .menu:focus {
            border: 1px solid grey;
            outline: none;
        }
    </style>
    <!-- 리뷰스타일 -->
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
</head>

<body>

	<div class="container">
	    <div class="row">
	        <div class="col-md-8">
	            <ul class="list-group">
	                <li class="list-group-item" style="text-align: left;">가게 이름</li>
	
	                <li class="list-group-item">
	                    <div class="row">
	                        <div class="col-md-12">
	                            <div style="width: 80px; height: 80px; float: left; border: 1px solid black; overflow: hidden;">
	                                <img src="/static/images/store/${store.thumbnail}" style="width: 100%; height: 100%; object-fit: fill;">
	                            </div>
	
	                        </div>
	                    </div>
	                </li>
	            </ul>
	        </div>
	    </div>
	</div>

<br/>

	<%--  내비바  --%>
	<div class="container">
	    <div class="row">
	        <div class="col-md-8">
	            <!-- Nav tabs -->
	            <div style="width:100%; border-top: 2px solid #d9d9d9; border-left: 2px solid #d9d9d9; border-right: 2px solid #d9d9d9;">
	                <ul class="nav nav-tabs" role="tablist">
	                    <li class="nav-item" style="border-right: 2px solid #d9d9d9;">
	                        <a class="nav-link active" data-toggle="tab" href="#menu1">메뉴</a>
	                    </li>
	                    <li class="nav-item" style="border-right: 2px solid #d9d9d9;">
	                        <a class="nav-link" data-toggle="tab" href="#menu2">클린리뷰</a>
	                    </li>
	                    <li class="nav-item">
	                        <a class="nav-link" data-toggle="tab" href="#menu3">정보</a>
	                    </li>
	                </ul>
	            </div>

				<!-- Tab panes -->
				<div class="tab-content" style="border: 2px solid #d9d9d9;">
					<div id="menu1" class="container tab-pane active" style="padding: 0;">
				    	<c:forEach var="item" items="${menu}" varStatus="status">
							<%@ include file="storeMenu.jsp"%>
							<%@ include file="storeMenuUpdate.jsp"%>
						</c:forEach>
					</div>

					<%--   혜영씨 공간 시작! 리뷰추가 02-25  --%>
					<div id="menu2" class="container tab-pane fade">
						<br>

					</div>
					<%--   혜영씨 공간 끝!   --%>

					<div id="menu3" class="container tab-pane fade">
						<br>
						<h3>Menu 2</h3>
						<p>Sed ut perspiciatis unde omnis iste natus error sit
							voluptatem accusantium doloremque laudantium, totam rem aperiam.</p>
					</div>
				</div>
			</div>
	    </div>
	</div>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" ></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" ></script>
	<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>

</body>

</html>
