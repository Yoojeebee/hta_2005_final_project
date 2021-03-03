<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file = "../../../common/taglib.jsp" %>
<!DOCTYPE html>
<html>

<head>
    <title>login</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/vue/2.5.15/vue.js"></script>
    <link rel="stylesheet" href="/static/resource/css/store/manage.css" />
</head>

<body>

    <div id="storeOpen"  class="container">
        <div class="row justify-content-center">
            <div class="col-md-8">
                <div class="card">
                    <!-- <div class="card-header" stlye="background-color: white;">Register</div> -->
                    <div class="card-body">

                        <form name="join" action="form" class="form-horizontal" method="POST" autocomplete="off" enctype="multipart/form-data">
                            <div class="form-group">
                                <label for="name" class="cols-sm-2 control-label">가게 이름 &nbsp; {{storeStatus}}</label>
                                <div class="cols-sm-10">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                        <input type="text" class="form-control" name="name" id="name" />
                                        <input type="button" @click="checkStore()" class="btn btn-outline-dark" id="owner-id-confirm" value="아이디 체크"/>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="thumbnail" class="cols-sm-2 control-label">가게 이미지</label>
                                <div class="cols-sm-10">
                                    <div class="filebox">
                                        <label for="thumbnail" class="cols-sm-2 control-label">업로드</label>
                                        <input type="file" name="thumbnail" id="thumbnail" accept="image/*" onchange="setThumbnail(this);">
                                        <div id="image_container"></div>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="row">
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label for="open" class="cols-sm-2 control-label">오픈 시간</label>
                                            <div class="cols-sm-4">
                                                <div class="input-group">
                                                    <input type="time" name="openTime" id="open" value="00:00" class="form-control">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label for="closed" class="cols-sm-2 control-label">마감 시간</label>
                                            <div class="cols-sm-4">
                                                <div class="input-group">
                                                    <input type="time" name="closeTime" id="closed" value="23:59" class="form-control">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="payment" class="cols-sm-2 control-label">결제 방식</label>
                                <div class="cols-sm-10">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                        <div id="payment" class="btn-group btn-group-lg">
                                            <input type="hidden" name="place"> <input type="hidden" name="card">
                                            <button id="place" type="button" class="btn btn-outline-dark" onclick="btnChange(this)">현장결제</button>
                                            <button id="card" type="button" class="btn btn-outline-dark" onclick="btnChange(this)">신용카드</button>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="price" class="cols-sm-2 control-label">최소 주문금액</label>
                                <div class="cols-sm-10">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                        <input type="number" class="form-control" name="minPrice" id="price" onkeypress="checkNum(this)" maxlength="4" oninput="maxCheck(this)" />
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="tel" class="cols-sm-2 control-label">전화번호</label>
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
                                <label for="address" class="cols-sm-2 control-label">주소</label>
                                <div class="cols-sm-10">
                                    <input type="text" readonly id="sample4_postcode" placeholder="우편번호">
                                    <input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
                                    <input class="form-control" style="width: 100%;" readonly type="text" id="roadAddress" placeholder="도로명주소">
                                    <input class="form-control" style="width: 100%;" readonly type="text" id="jibunAddress" placeholder="지번주소">
                                    <span id="guide" style="color:#999;display:none"></span>
                                    <input id="address" type="hidden" name="address">
                                    <input style="width: 100%;" type="text" id="detailAddress" placeholder="상세주소">
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
    <script src="/static/resource/javascript/map.js"></script>
    <script src="/static/resource/vue/store/vue-checkStore.js"></script>
    <script src="/static/resource/javascript/store/storeOpen.js"></script>
</body>
</html>