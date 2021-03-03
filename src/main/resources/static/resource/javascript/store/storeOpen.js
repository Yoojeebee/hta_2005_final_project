const join = document.join;

function setThumbnail(event) {
    const reader = new FileReader();

    reader.onload = function(source) {
        const src_value = document.querySelector("div#image_container img");
        if(src_value != null) {
            src_value.setAttribute("src", source.target.result);
            return;
        } else {
            const img = document.createElement("img");
            img.setAttribute("src", source.target.result);
            img.setAttribute("width", "300px");
            img.setAttribute("height", "300px");
            document.querySelector("div#image_container").appendChild(img);
        }
    };

    reader.readAsDataURL(event.files[0]);
}

function btnChange(event) {
    if(event.className == "btn btn-outline-dark") {
        event.className = "btn btn-dark";
    } else if(event.className == "btn btn-dark") {
        event.className = "btn btn-outline-dark";
    }
}

function checkNum(event) {
    if(event.keyCode<48 || event.keyCode>57){
        event.value = "";
        event.returnValue=false;
    }
}

function maxCheck(e) {
    if(e.id == "tel-middle" || e.id == "tel-tail") {
        if(e.value.length > e.maxLength){
            e.value = e.value.slice(0, e.maxLength);
        }
    }
}

function goSubmit() {
    // 아이디 체크
    if(check.isOk.value == false) {
        alert("아이디가 중복되거나 체크를 하지 않은 아이디 입니다.");
        return;
    }

    // 가게 이미지 체크
    if(document.querySelector("div#image_container img") == null) {
        alert("가게 이미지를 넣어주세요.");
        return;
    }

    // 가게 오픈 시간 체크
    // const open = document.getElementById("open");
    // open.setAttribute("value", open.toString());
    //
    // // 가게 닫는 시간 체크
    // const closed = document.getElementById("closed");
    // closed.setAttribute("value", open.toString());

    // 현장 결제 체크
    const place = document.getElementById("place");
    if(place.className == "btn btn-outline-dark") {
        document.getElementsByName('place')[0].setAttribute('value', 'N');
    } else {
        document.getElementsByName('place')[0].setAttribute('value', 'Y');
    }

    // 카드 결제 체크
    const card = document.getElementById("card");
    if(card.className == "btn btn-outline-dark") {
        document.getElementsByName('card')[0].setAttribute('value', 'N');
    } else {
        document.getElementsByName('card')[0].setAttribute('value', 'Y');
    }

    // 전화 번호 체크
    const tel = document.getElementById("tel");
    const telMiddle = document.getElementById("tel-middle");
    const telTail = document.getElementById("tel-tail");
    if(tel.value == "") {
        alert("번호를 선택하세요.");
        return;
    }
    if(telMiddle.value == "") {
        alert("번호를 입력하세요.");
        return;
    }
    if(telTail.value == "") {
        alert("번호를 입력하세요.");
        return;
    }
    tel.setAttribute('value', tel.value + telMiddle.value + telTail.value);

    // 주소 체크
    const address = document.getElementById("roadAddress");
    const detailAddress = document.getElementById("detailAddress");
    if(address.value == "") {
        alert("주소를 입력하세요.");
        return;
    }
    document.getElementById('address').setAttribute('value', address.value + " " + detailAddress.value);

    // 최소 주문 금액
    const price = document.getElementById("price").value;
    if(price == "") {
        alert("최소 주문 금액을 입력하세요.");
        return;
    }

    join.submit();
}

$('#telSelect li').on('click', function () {
    $('#telBtn').text($(this).text());
    $('#telBtn').attr('value', $(this).text());
    $('#tel').attr('value', $('#telBtn').text());
});
