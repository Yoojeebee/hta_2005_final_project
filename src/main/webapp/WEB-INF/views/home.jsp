<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%> <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title>Home</title>
<style>
.card {
	overflow: hidden;
}
.card-body {
	height: 220px;
	padding-bottom: 5px;
	padding-right: 5px;
}
.top-left {
	position: absolute;
	top: 8px;
	left: 16px;
}
.img-thumbnail {
	border: 0 !important;
	position: absolute;
	top: 39px;
    left: 5px;
}
</style>
</head>
<body>
	<%@ include file="../common/navbar.jsp" %>
<div class="container">

	<div class="row mb-3 mt-3" id="category-box">
	<c:forEach var="category" items="${categories }">
        <div class="col-3 mb-2">
            <div class="card">
                <div class="card-body">
                     ${category.name }
                     <br/>  
                     <a href="/list.do?ctgno=${category.no }" data-ctg-no="${category.no }">
	                     <img class="img-thumbnail" src="static/resource/images/category/${category.imgPath }" alt="Card image">
                     </a>                      
                </div>	
            </div>
        </div>
	</c:forEach>
    </div>
</div>
	<%@ include file="../common/footer.jsp" %>
<script type="text/javascript">
	
	
	$("#category-box a").click(function() {
		var address = $("#search-addr").val();
		if (address == "") {
			alert("먼저 주소를 입력하세요");
			return false;
		}
		
		var categoryNo = $(this).data('ctg-no');
		$("#c").val(categoryNo);
		$("#p").val(1);
		$("#form-search").submit();
		
		return false;
	})
</script>
</body>
</html>