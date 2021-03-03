var join = document.join;

// 입력값 확인
function goSubmit() {
    // 이름 체크
    var name = document.getElementById("owner-name").value;
    if(name == "" || name == null) {
        alert("이름을 입력하세요.");
        return;
    }

    // 아이디 체크
    var id = document.getElementById("owner-id").value;
    if(id == "" || id == null) {
        alert("아이디를 입력하세요.");
        return;
    }

    // 비밀번호 체크
    var pwd = document.getElementById("owner-password").value;
    var pwd_confirm = document.getElementById("owner-password-check").value;
    if(pwd == "" || pwd == null) {
        alert("비밀번호를 입력하세요.");
        return;
    }
    if(pwd_confirm == "" || pwd_confirm == null || pwd != pwd_confirm) {
        alert("비밀번호가 일치하지 않습니다");
        return;
    }

    // 이메일 체크
	var emailHead = document.getElementById("email-head").value;
    var email = document.getElementById("email").value;
    if(emailHead == "" || emailHead == null || emailHead == "" || emailHead == null) {
        alert("이메일을 입력하세요.");
        return;
    }
    if(email == "" || email  == null) {
        alert("이메일 주소를 선택하세요.");
        return;
    }
	document.getElementById("email").setAttribute('value', emailHead + email);

    // 전화번호 체크
    var tel = document.getElementById("tel").value;
    var telMiddle = document.getElementById("tel-middle").value;
    var telTail = document.getElementById("tel-tail").value;
    if(tel == "") {
        alert("번호를 선택하세요.");
        return;
    }
    if($('#telBtn').text() == "번호 선택") {
        alert("번호를 선택하세요.");
        return;
    }
    if(telMiddle == "" || telMiddle == null) {
        alert("번호를 입력하세요.");
        return;
    }
    if(telTail == "" || telTail == null) {
        alert("번호를 입력하세요.");
        return;
    }
	document.getElementById("tel").setAttribute('value', tel + telMiddle + telTail);
	    
    // 주소 체크
    var address = document.getElementById("roadAddress").value;
	var detailAddress = document.getElementById("detailAddress").value;
    if(address == "" || address == null) {
        alert("주소를 입력하세요.");
        return;
    }
	detailAddress = " " + detailAddress;
    document.getElementById("address").setAttribute('value', address + detailAddress);

    // 통장 체크
    var bank = document.getElementById("bank").value;
	var bankNumber = document.getElementById("owner-banknumber").value;
    if(bank == "" || bank == null) {
        alert("통장을 선택해주세요.");
        return;
    }
	if(bankNumber == "" || bankNumber == null) {
        alert("통장 번호를 입력해주세요.");
        return;
    }

    // 사업자등록증 체크
    var license = document.getElementById("owner-license").value;
    if(license == "" || license == null) {
        alert("사업자등록 번호를 입력해주세요.")
        return;
    }

	join.submit();

}

function maxCheck(e) {
    if(e.id == "tel-middle" || e.id == "tel-tail") {
        if(e.value.length > e.maxLength){
            e.value = e.value.slice(0, e.maxLength);
        }
    } else if(e.id == "owner-banknumber") {
        if(e.value.length > e.maxLength){
            e.value = e.value.slice(0, e.maxLength);
        }
    } else if(e.id = "owner-license") {
        if(e.value.length > e.maxLength) {
            e.value = e.value.slice(0, e.maxLength);
        }
    }
}