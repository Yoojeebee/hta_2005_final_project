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
            img.setAttribute("object-fit", "cover");
            document.querySelector("div#image_container").appendChild(img);
        }
    };

    reader.readAsDataURL(event.files[0]);
}

function changeThumbnail(event) {
    const reader = new FileReader();

    reader.onload = function(source) {
        const src_value = document.querySelector(".option_image_container img");
        if(src_value != null) {
            src_value.setAttribute("src", source.target.result);
            return;
        } else {
            const img = document.createElement("img");
            img.setAttribute("src", source.target.result);
            img.setAttribute("object-fit", "cover");
            document.querySelector(".option_image_container").appendChild(img);
        }
    };

    reader.readAsDataURL(event.files[0]);
}

// 필수 메뉴 추가
const ess = document.getElementById("essential");       // display 용
const $essRepo = $(document.getElementsByClassName("ess-option")[0]);  // 필수 선택 옵션

function essAdd(event) {
    if(ess.style.display == 'none') {
        ess.style.display = 'block';
    } else {
        $('#essential').append($essRepo.clone());
    }
}

// 필수 메뉴 개별 삭제
function essOptRemove(btn) {
    $(btn).closest(".ess-option").remove();
}

// 가격입력 숫자 체크
function checkNum(event) {
    if(event.keyCode<48 || event.keyCode>57){
        event.value = "";
        event.returnValue=false;
    }
}

// 필수 메뉴의 옵션 추가
const $el = $(document.getElementById("option").innerHTML);

function optAdd(event) {
    $('#option').append($el.clone());
}

// 메뉴 업데이트
function menuUpdate() {

    let isOk = true;

    const name = document.getElementById("name").value;
    if(name == "") {
        alert("메뉴 이름을 클릭해주세요.");
        isOk = false;
    }

    const thumbnail = document.getElementById("thumbnail");
    if(thumbnail.value == "") {
        alert("이미지를 선택해 주십시오.");
        isOk = false;
    }

    const price = document.getElementById("price");
    if(price.value == "") {
        alert("가격을 입력해 주세요.");
        isOk = false;
    }

    if(ess.style.display == 'block') {
        const len = document.getElementsByClassName("groupName");
        const detailName = document.getElementsByClassName("detailName");
        const detailPrice = document.getElementsByClassName("detailPrice");
        for (let i = 0; i < len.length; i++) {
            if(len[i].value != "" ) {
                for (let j = 0; j < detailName.length; j++) {
                    if (detailName[i].value == "" || detailPrice[i].value == "") {
                        alert("필수 옵션의 이름 혹은 가격이 빠졌습니다.");
                        isOk = false;
                        break;
                    } else {
                        detailName[i].setAttribute('value', i + detailName[i].value);
                        detailPrice[i].setAttribute('value', i + detailPrice[i].value);
                    }
                }
            }
            if(isOk == false) {
                break;
            }
        }
    }

    if(isOk == true) {
        document.joinMenu.submit();
    }

    event.stopPropagation();

}

function optionUpdate() {

    let isOk = true;

    const optionName = document.getElementById("optionName");
    if(optionName.value == "") {
        alert("옵션 메뉴 이름을 입력해주세요.");
        isOk = false;
    }

    const optionThumbnail = document.getElementById("optionThumbnail");
    if(optionThumbnail.value == "") {
        alert("옵션 메뉴 이름을 입력해주세요.");
        isOk = false;
    }

    const optionPrice = document.getElementById("optionPrice");
    if(optionPrice.value == "") {
        alert("옵션 메뉴 이름을 입력해주세요.");
        isOk = false;
    }

    if(isOk == true) {
        document.joinOption.submit();
    }

    event.stopPropagation();
}

function optionMenuGroupAdd() {
	document.joinOptionMenu.submit();
}

function menuGroupAdd() {
	document.joinMenu.submit();
}