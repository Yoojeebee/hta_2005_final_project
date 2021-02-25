<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%><!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title>navbar</title>
<style type="text/css">
#logo {
    text-align: left;
}

.nav-option {
    float: right;
    width: 100%; 
    height: 100%; 
    border: 1px solid white;
}

#nav-top {
    padding-top: 17px; 
    padding-bottom: 17px;
}

.yogiyo-logo {
    width: 90px; 
    height: 100%;
}

#nav-background {
    background-image: url('/static/resource/images/bg-top.png');
    background-repeat: no-repeat; 
    background-size: 100% 100%; 
    overflow: auto; 
    width: 100%; 
    height: 250px;
}
</style>
</head>
<body>
<nav style="background-color: #fa0050;">
    <div id="nav-top" class="container-fluid">
        <div class="row">
            <div class="col-2">
            	<a href="/home.do">
	                <img class="yogiyo-logo" src="/static/resource/images/logo-yogiyo.png">
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
		<input type="hidden" name="keyword" value="${param.keyword }" id="k" />
     </form>
            <div id="nav-background" class="container-fluid">
                <div class="row" style="height: 100%; position: relative;">
                    <div class="col-md-4"></div>
        
                    <div class="col-md-4" style="margin: 0; position: absolute; top: 60%; left: 50%; transform: translate(-50%, -50%);">
                        <div class="form-group">
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="far fa-compass" style='font-size:40px;color:white' aria-hidden="true"></i></span>
                                    <input onclick="sample3_execDaumPostcode()" type="search" value="${param.address }" id="search-addr" class="form-control" name="address"
                                        placeholder="건물명, 도로명, 지번으로 검색하세요." />
                                    <div class="input-group-append">
                                        <button  class="btn btn-warning text-white" type="button" id="btn-search-addr">검색</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-4"></div>
            </div>
        <div id="wrap" style="display:none;border:1px solid;width:525px;height:300px;margin:5px 0;position:absolute; z-index:100; top:229px; left:585px;">
			<img src="/static/resource/images/close.png" id="btnFoldWrap" style="cursor:pointer;position:absolute;right:0px;top:-1px; z-index:101;" onclick="foldDaumPostcode()" alt="접기 버튼">
		</div>
</nav>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript">
	
    // 우편번호 찾기 찾기 화면을 넣을 element
    var element_wrap = document.getElementById('wrap');

    function foldDaumPostcode() {
        // iframe을 넣은 element를 안보이게 한다.
        element_wrap.style.display = 'none';
    }

    function sample3_execDaumPostcode() {
        // 현재 scroll 위치를 저장해놓는다.
        var currentScroll = Math.max(document.body.scrollTop, document.documentElement.scrollTop);
        new daum.Postcode({
            oncomplete: function(data) {
                // 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                   
                
                } 

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                //document.getElementById('sample3_postcode').value = data.zonecode;
				document.getElementById("origin-addr").value = addr;
                
                addr = addr.split(' ').slice(0, 2).join(' ');
				document.getElementById("search-addr").value = addr;
				document.getElementById("short-addr").value = addr;
				
                
                // 커서를 상세주소 필드로 이동한다.
                //document.getElementById("sample3_detailAddress").focus();

                // iframe을 넣은 element를 안보이게 한다.
                // (autoClose:false 기능을 이용한다면, 아래 코드를 제거해야 화면에서 사라지지 않는다.)
                element_wrap.style.display = 'none';

                // 우편번호 찾기 화면이 보이기 이전으로 scroll 위치를 되돌린다.
                document.body.scrollTop = currentScroll;
            },
            // 우편번호 찾기 화면 크기가 조정되었을때 실행할 코드를 작성하는 부분. iframe을 넣은 element의 높이값을 조정한다.
            onresize : function(size) {
                element_wrap.style.height = size.height+'px';
            },
            width : '100%',
            height : '100%'
        }).embed(element_wrap);

        // iframe을 넣은 element를 보이게 한다.
        element_wrap.style.display = 'block';
    }
    
    $("#btn-search-addr").click(function() {
		var address = $("#search-addr").val()
		if (address == '') {
			alert('주소를 입력하세요');
			return false;
		}
		$("#ctg-no").val(1);
		$("#p").val(1);
		$("#form-search").submit();
	});

</script>
</body>
</html>