<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>register</title>
</head>
<body>
	<div class="row">
      <div class="col-12">
         <%@ include file="../common/navbar.jsp" %>
      </div>
   </div>
   
<div class="container">
	<c:if test="${param.error eq 'mismatch' }">
   	<div class="row">
   		<div class="col-12">
        	<div class="alert alert-danger">
           		<strong>오류</strong> 비밀번호가 일치하지 않습니다.
         	</div>
      </div>
   	</div>
	</c:if>
	<div class="row m-3">
		<div class="col-8 offset-2">
	    	<div class="card  w3-container   w3-light-grey w3-text-red w3-margin p-3" style="width: 800px;">
		  		<form id="user-form" class="p-3" method="post" action="register.do" enctype="multipart/form-data" onsubmit="checkUserForm(event)" >
					<h2 class="w3-center">회원가입</h2>
						<div class="form-row">
							<div class="form-group col-12">
						  		<div class="w3-col" style="width:50px"><i class="w3-xxlarge fa fa-user"></i></div>
							    	<div class="w3-rest">
							      		<input class="w3-input w3-border" id="user-name" name="name" type="text" placeholder="Name">
							    	</div>
							</div>
						</div>
						<div class="form-row">
							<div class="form-group col-10">
					  			<div class="w3-col" style="width:50px"><i class=" fab fa-keybase" style='font-size:40px'></i></div>
					    			<div class="w3-rest">
					      				<input class="w3-input w3-border" id="user-id" name="id" type="text" placeholder="id">
					    			</div>
							</div>
							<div class="form-group col-2 mt-1">
		               			<button onclick="checkMyId()" class="btn btn-outline-danger btn-sm form-control" >아이디 중복체크</button>
		           			</div>
	          			</div>
	           			<div class="form-row">
			   				<div class="form-group col-12">
				  				<div class="w3-col" style="width:50px"><i class="fas fa-key" style='font-size:40px'></i></div>
				    				<div class="w3-rest">
				      					<input class="w3-input w3-border" id="user-password" name="password" type="password" placeholder="Password">
				    				</div>
							</div>
			  			</div>
						<div class="form-row">
							<div class="form-group col-12">
				  				<div class="w3-col" style="width:50px"><i class="far fa-keyboard" style='font-size:40px'></i></div>
				    				<div class="w3-rest">
				      					<input class="w3-input w3-border" id="user-password2" name="password2" type="password" placeholder="Password Check">
				   					</div>
								</div>
						</div>				
						<div class="form-row">
							<div class="form-group col-12">
				  				<div class="w3-col" style="width:50px"><i class="fas fa-at"  style='font-size:40px'></i></div>
				   					<div class="w3-rest">
				      					<input class="w3-input w3-border" id="user-email" name="email" type="text" placeholder="Email">
				    				</div>
							</div>
						</div>
						<div class="form-row">
							<div class="form-group col-12">
						  		<div class="w3-col" style="width:50px"><i class="fas fa-phone" style='font-size:40px'></i></div>
						    		<div class="w3-rest">
						      			<input class="w3-input w3-border" id="user-tel" name="tel" type="text" placeholder="Tel">
						    		</div>
							</div>
						</div>				
						<div class="form-row">
							<div class="form-group col-12">
						  		<div class="w3-col" style="width:50px"><i class="fas fa-birthday-cake" style='font-size:40px'></i></div>
							    <div class="w3-rest">
							    	<input class="w3-input w3-border" id="user-birth" name="birth" type="date" placeholder="Birth">
							    </div>
							</div>
						</div>
						<div class="text-right">
							<input type="submit" class="btn btn-outline-primary" value="회원가입" />
							<a href="home.do" class="btn btn-outline-danger">취소</a>
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
	function checkMyId() {
	    var myId = document.getElementById('user-id').value;
	    console.log("입력한 아이디", myId);
	    
	    // ajax 엔진 객체 생성
	    var xhr = new XMLHttpRequest();
	    
	    // ajax 엔진 객체의 readyState 상태가 변할 때
	    xhr.onreadystatechange = function() {            // 콜백함수, 특정상황이 됐을 때 실행되는 함수
	       if (xhr.readyState == 4) {                  //           특정상황 = 특정 이벤트 발생시
	          alert(xhr.responseText);               //           개발자가 임의의 시간에 실행하는 함수가 아니다.
	       }                                    //           자바스크립트 엔진이 자발적으로 실행하는 함수다.
	    }
	    
	    // ajax 엔진 객체 초기화
	    xhr.open("GET", "checkUserId.do?userId=" + myId);   // onreadystatechange 이벤트 발생
	    // 서버로 HTTP 요청 보내기
	    xhr.send();                                 // onreadystatechange 이벤트 발생
	    
	    //var msg = xhr.responseText;
	    //console.log("응답메세지: " + msg);
	 }
	
	   function checkUserForm(event) {
	      var form = document.querySelector("#user-form");
	      
	      if (!document.querySelector("#user-name").value) {
	         alert("이름은 필수입력값입니다.");
	         event.preventDefault();
	         return;
	      }
	      if (!document.querySelector("#user-id").value) {
	         alert("아이디은 필수입력값입니다.");
	         event.preventDefault();
	         return;
	      }
	      var password = document.querySelector("#user-password").value;
	      var confirmPassword = document.querySelector("#user-password2").value;
	      if (!password) {
	         alert("비밀번호는 필수입력값입니다.");
	         event.preventDefault();
	         return;
	      }
	      if (!confirmPassword) {
	         alert("비밀번호는 필수입력값입니다.");
	         event.preventDefault();
	         return;
	      }
	      if (password != confirmPassword) {
	         alert("비밀번호가 일치하지 않습니다.");
	         event.preventDefault();
	         return;
	      
	      }
	      if (!document.querySelector("#user-tel").value) {
	         alert("전화번호는 필수입력값입니다.");
	         event.preventDefault();
	         return;
	      }
	      if (!document.querySelector("#user-email").value) {
	         alert("이메일은 필수입력값입니다.");
	         event.preventDefault();
	         return;
	      }
	   }
</script>
</body>
</html>