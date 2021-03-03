<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file = "../../../../common/taglib.jsp" %>
<!DOCTYPE html>
<html>

<head>
    <title>메뉴 그룹 관리</title>
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
                <h1>이름: ${name}</h1>
            </div>
        </div>
    </div>

    <div class="container">
        <div class="row">
            <div class="col-12">
                <h1>그룹 메뉴</h1>
                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#menuGroup">
                    메뉴 그룹 추가
                </button>
                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#sideMenuGroup">
                    사이드 메뉴 그룹 추가
                </button>
            </div>
        </div>
        <hr/>
    </div>

    <%-- 메뉴 그룹 추가 --%>
    <div class="container">
        <div class="row">
            <div class="col-12">
            	<%@ include file="menuGroup.jsp" %>
            </div>
        </div>
    </div>

    <%-- 사이드 메뉴 그룹 추가 --%>
    <div class="container">
        <div class="row">
            <div class="col-12">
            	<%@ include file="sideMenuGroup.jsp" %>
            </div>
        </div>
    </div>

	<c:if test="${groupSize >= 1}">
	    <c:forEach var="group" items="${menuGroup}" begin="0" end="${groupSize - 1}" varStatus="status" step="1">
	        <div class="container">
	            <div class="row">
	                <div class="col-12">
	                    <h1>${groupName[status.index]}</h1>
	                </div>
	            </div>
	        </div>
	        <c:forEach var="item" items="${menuGroup}">
	            <c:if test="${groupNo[status.index] eq item.groupNo}">
	                <%@ include file="storeMenu.jsp" %>
	                <%@ include file="storeMenuUpdate.jsp" %>
	            </c:if>
	        </c:forEach>
	    </c:forEach>
    </c:if>
    
    <c:if test="${optionGroupSize >= 1}">
    	<c:forEach var="group" items="${optionMenuGroup}" begin="0" end="${optionGroupSize - 1}" varStatus="status" step="1">
			<div class="container">
				<div class="row">
					<div class="col-12">
						<h1>${optionGroupName[status.index]}</h1>
					</div>
				</div>
			</div>
			<c:forEach var="item" items="${optionMenuGroup}">
	            <c:if test="${optionGroupNo[status.index] eq item.groupNo}">
	                <%@ include file="optionMenuGroup.jsp" %>
	            </c:if>
	        </c:forEach>
		</c:forEach>
    </c:if>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/vue/2.5.15/vue.js"></script>
    <script type="text/javascript" src="/static/resource/javascript/store/menu.js"></script>
</body>

</html>
