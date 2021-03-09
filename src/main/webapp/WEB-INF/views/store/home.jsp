<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file = "../../common/taglib.jsp" %>
<!DOCTYPE html>
<html>

<head>
    <title>login</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/vue/2.5.15/vue.js"></script>
</head>

<body>

	<nav>
		<div class="container-fluid" style="height: 70px; border: 1px solid grey; line-height: 70px;">
            <div class="row">
                <div class="col-lg-6" style="float: left; text-align: left;">
                    <img style="background: url('/static/images/img-nav-owners-v2.png') no-repeat -25px -8px;
                    width: 133px;
                    height: 17px; border: 0px;" />
                    <c:choose>
                        <c:when test="${no eq null}" >
                            <a href="/store/manage/joinStore">가게 생성</a>
                        </c:when>

                        <c:otherwise>
                            <a href="/store/manage/menu/menu?storeNo=${no}">내 메뉴 관리</a>
                            <a href="/store/manage/menugroup/group?storeNo=${no}">내 메뉴 그룹 관리</a>
                        </c:otherwise>
                    </c:choose>
                </div>
                <div class="col-lg-6" style="float: right; text-align: right">
                    <a href="/owner/logout">로그아웃</a>
                </div>
            </div>
        </div>
	</nav>

    <%--  옵션 메뉴 그룹 추가  --%>
    <%--    <div class="container">--%>
    <%--        <div class="row">--%>
    <%--            <div class="col-12">--%>
    <%--                <%@ include file="../sideMenuGroup.jsp" %>--%>
    <%--            </div>--%>
    <%--        </div>--%>
    <%--    </div>--%>
	
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>