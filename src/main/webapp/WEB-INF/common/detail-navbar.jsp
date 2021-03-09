<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<nav style="background-color: #fa0050;">
	<div id="nav-top" class="container">
		<div class="row">
			<div class="col-2">
				<a href="/home.do"> <img class="yogiyo-logo" src="/static/resource/images/logo-yogiyo.png">
				</a>
			</div>
			<div class="col-8">
				<c:if test="${not empty LOGINED_USER }">
					<span class="navbar-text" style="float: right"><strong class="text-white">${LOGINED_USER.name }</strong>님 환영합니다.</span>
				</c:if>
			</div>
			<div class="col-2">
				<c:choose>
					<c:when test="${ empty LOGINED_USER }">
						<a href='loginform.do' class="nav-option btn btn-outline-light outline-text-white btn-block">로그인</a>
					</c:when>
					<c:otherwise>
						<a href='logout.do' class="nav-option btn btn-outline-light outline-text-white btn-block">로그아웃</a>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>

	<form id="form-search" action="list.do">
		<input type="hidden" name="origin" id="origin-addr" value="${origin }" id="o" /> 
		<input type="hidden" name="address" id="short-addr" value="${param.address }" id="a" /> 
		<input type="hidden" name="ctgno" value="${param.ctgno }" id="c" /> 
		<input type="hidden" name="sort" value="${empty param.sort ? 'basic' : param.sort }" id="s" />
		<input type="hidden" name="page" value="${param.page }" id="p" /> 
		<input type="hidden" name="keyword"	value="${param.keyword }" id="k" />
	</form>
	<div id="nav-background" class="container-fluid">
		<div class="row" style="height: 100%; position: relative;">
			<div class="col-md-4"></div>

			<div class="col-md-4"
				style="margin: 0; position: absolute; top: 60%; left: 50%; transform: translate(-50%, -50%);">
				<div class="form-group">
					<div class="cols-sm-10">
						<div class="input-group">
							<span class="input-group-addon">
							<i class="far fa-compass" style='font-size: 40px; color: white' aria-hidden="true"></i>
							</span> 
							<input onclick="sample3_execDaumPostcode()" type="search" value="${param.address }" id="search-addr" class="form-control" name="address" placeholder="건물명, 도로명, 지번으로 검색하세요." />
							<div class="input-group-append">
								<button class="btn btn-warning text-white" type="button" id="btn-search-addr">검색</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-4"></div>
	</div>
	<div id="wrap" style="display: none; border: 1px solid; width: 525px; height: 300px; margin: 5px 0; position: absolute; z-index: 100; top: 229px; left: 656px;">
		<img src="/static/resource/images/close.png" id="btnFoldWrap" style="cursor: pointer; position: absolute; right: 0px; top: -1px; z-index: 101;" onclick="foldDaumPostcode()" alt="접기 버튼">
	</div>
</nav>