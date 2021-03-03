<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <title>join Owner</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/vue/2.5.15/vue.js"></script>
    <style>
        input[type="number"]::-webkit-outer-spin-button,
        input[type="number"]::-webkit-inner-spin-button {
            -webkit-appearance: none;
            margin: 0;
        }
    </style>
</head>

<body style="margin-top: 50px; margin-bottom: 50px;">

    <div id="chkBtn"  class="container">
        <div class="row justify-content-center">
            <div class="col-md-8">
                <div class="card">
                    <!-- <div class="card-header" stlye="background-color: white;">Register</div> -->
                    <div class="card-body">
    
                        <form name="join" action="joinForm" class="form-horizontal" method="POST" autocomplete="off" >
                            <div class="form-group">
                                <label for="name" class="cols-sm-2 control-label">이름</label>
                                <div class="cols-sm-10">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                        <input type="text" class="form-control" name="name" id="owner-name" />
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="email" class="cols-sm-2 control-label">아이디 &nbsp;<span>{{idStatus}}</span></label>
                                <div class="cols-sm-10">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
                                        <input type="text" class="form-control" name="id" id="owner-id" />
                                        <input type="button" @click="checkId()" class="btn btn-outline-dark" id="owner-id-confirm" value="아이디 체크"/>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="email" class="cols-sm-2 control-label">비밀번호</label>
                                <div class="cols-sm-10">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
                                        <input type="password" class="form-control" name="password" id="owner-password" />
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="email" class="cols-sm-2 control-label">비밀번호 체크 </label>
                                <div class="cols-sm-10">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
                                        <input type="password" class="form-control" id="owner-password-check" />
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="username" class="cols-sm-2 control-label">이메일 &nbsp;<span>{{emailStatus}}</span></label>
                                <div class="cols-sm-10">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
                                        <input type="text" class="form-control" id="email-head" />
                                        <button id="emailBtn" type="button" class="btn btn-outline-dark dropdown-toggle" data-toggle="dropdown">
                                            이메일 선택
                                        </button>
                                        <input id="email" type="hidden" name="email">
                                        <ul id="emailSelect" class="dropdown-menu">
                                            <li class="dropdown-item">@naver.com</li>
                                            <li class="dropdown-item">@kakao.com</li>
                                            <li class="dropdown-item">@google.com</li>
                                        </ul>
                                        <input type="button" @click="checkEmail()" class="btn btn-outline-dark" id="owner-email-confirm" value="이메일 체크"/>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="confirm" class="cols-sm-2 control-label">전화번호</label>
                                <div class="cols-sm-10">
                                    <div class="row">
                                        <div class="col-sm-4">
                                            <button id="telBtn" type="button" class="btn btn-block btn-outline-dark dropdown-toggle" data-toggle="dropdown">
                                                번호 선택
                                            </button>
                                            <input id="tel" type="hidden" name="tel">
                                            <ul id="telSelect" class="dropdown-menu">
                                                <li class="dropdown-item">010</li>
                                                <li class="dropdown-item">011</li>
                                                <li class="dropdown-item">017</li>
                                            </ul>
                                        </div>
                                        <div class="col-sm-4">
                                            <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                                            <input type="number" class="form-control" id="tel-middle" maxlength="4" oninput="maxCheck(this)" />
                                        </div>
                                        <div class="col-sm-4">
                                            <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                                            <input type="number" class="form-control" id="tel-tail" maxlength="4" oninput="maxCheck(this)" />
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="confirm" class="cols-sm-2 control-label">주소</label>
                                <div class="cols-sm-10">
                                    <input type="text" id="sample4_postcode" placeholder="우편번호">
                                    <input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
                                    <input style="width: 100%;" type="text" id="roadAddress" placeholder="도로명주소"><br/>
                                    <input style="width: 100%;" type="text" id="jibunAddress" placeholder="지번주소">
                                    <span id="guide" style="color:#999;display:none"></span>
                                    <input id="address" type="hidden" name="address">
                                    <input style="width: 100%;" type="text" id="detailAddress" placeholder="상세주소">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="confirm" class="cols-sm-2 control-label">거래통장</label>
                                <div class="cols-sm-10">
                                    <div class="input-group">
                                        <button id="bankBtn" type="button" class="btn btn-outline-dark dropdown-toggle" data-toggle="dropdown">
                                            선택
                                        </button>
                                        <input id="bank" type="hidden" name="bank">
                                        <ul id="bankSelect" class="dropdown-menu">
                                            <li class="dropdown-item">농협</li>
                                            <li class="dropdown-item">신한</li>
                                            <li class="dropdown-item">우리</li>
                                        </ul>
                                        <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                                        <input type="number" class="form-control" name="bankNumber" id="owner-banknumber" placeholder="'-'자를 뺀 숫자만 입력하시오" oninput="maxCheck(this)" maxlength="16" />
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="confirm" class="cols-sm-2 control-label">사업자 등록증</label>
                                <div class="cols-sm-10">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                                        <input type="number" class="form-control" name="license" id="owner-license" placeholder="'-'자를 뺀 숫자만 입력하시오" oninput="maxCheck(this)" maxlength="10" />
                                    </div>
                                </div>
                            </div>

                            <div class="form-group ">
                                <input id="btn-join" type="button" onclick="goSubmit()" class="btn btn-outline-dark btn-lg btn-block login-button" value="Register">
                            </div>
                        </form>
                    </div>
    
                </div>
            </div>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script type="text/javascript" src="/static/resource/vue/owner/checkConfirm.js"></script>
    <script type="text/javascript" src="/static/resource/javascript/map.js"></script>
    <script src="/static/resource/javascript/owner/joinOwner.js"></script>
    <script>
        $('#emailSelect li').on('click', function () {
            $('#emailBtn').text($(this).text());
            $('#emailBtn').attr('value', $(this).text());
            $('#email').attr('value', $('#emailBtn').text());
        });

        $('#telSelect li').on('click', function () {
            $('#telBtn').text($(this).text());
            $('#telBtn').attr('value', $(this).text());
            $('#tel').attr('value', $('#telBtn').text());
        });

        $('#bankSelect li').on('click', function () {
            $('#bankBtn').text($(this).text());
            $('#bankBtn').attr('value', $(this).text());
            $('#bank').attr('value', $('#bankBtn').text());
        });
    </script>
</body>
</html>
