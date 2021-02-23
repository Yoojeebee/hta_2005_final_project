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
<title>Template</title>
</head>
<body>
	<div class="row">
      <div class="col-12">
         <%@ include file="../common/navbar.jsp" %>
      </div>
   </div>
<div class="container">
   <div class="row">
      <div class="col-12">
         <div class="alert alert-danger">
            <strong>오류</strong> 비밀번호가 일치하지 않습니다.
         </div>
      </div>
   </div>
   <div class="row">
      <div class="col-12">
         <div class="alert alert-danger">
            <strong>오류</strong> 이미 사용중인 아이디입니다.
         </div>
      </div>
   </div>
   
   <div class="row">
      <div class="col-12">
         <div class="card">
            <form id="user-form" method="post" action="register.do" enctype="multipart/form-data" onsubmit="checkUserForm(event)">
            <div class="card-header"><h4>회원가입 폼</h4></div>
            <div class="card-body">
               <div class="form-row">
                  <div class="form-group col-12">
                     <label>이름</label>
                     <input type="text" class="form-control" name="name" id="user-name"/>
                  </div>
               </div>
               <div class="form-row">
                  <div class="form-group col-10">
                     <label>아이디</label>
                     <input type="text" class="form-control" name="id" id="user-id"/>
                  </div>
                  <div class="form-group col-2">
                     <label>&nbsp;</label>
                     <button onclick="checkMyId()" class="btn btn-outline-danger btn-sm form-control" >아이디 중복체크</button>
                  </div>
               </div>
               <div class="form-row">
                  <div class="form-group col-12">
                     <label>비밀번호</label>
                     <input type="password" class="form-control" name="password" id="user-password" />
                  </div>
               </div>
               <div class="form-row"></div>
                  <div class="form-group col-12">
                     <label>비밀번호 확인</label>
                     <input type="password" class="form-control" name="password2" id="user-password2"/>
                  </div>
               <div class="form-row">
                  <div class="form-group col-12">
                     <label>전화번호</label>
                     <input type="text" class="form-control" name="tel" id="user-tel"/>
                  </div>
               </div>
               <div class="form-row">
                  <div class="form-group col-12">
                     <label>이메일</label>
                     <input type="text" class="form-control" name="email" id="user-email" />
                  </div>
               </div>
               <div class="form-row">
                  <div class="form-group col-12">
                     <label>생일</label>
                     <input type="date" class="form-control" name="birth" id="user-birth" />
                  </div>
               </div>
               <div class="form-row">
                  <div class="text-right">
                     <a href="home.do" class="btn btn-outline-success">취소</a>
                     <input type="submit" class="btn btn-outline-danger" value="회원가입" />
                  </div>
               </div>
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