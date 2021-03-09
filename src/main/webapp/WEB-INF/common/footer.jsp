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
<title>footer</title>
<style type="text/css">
footer {
    width:100%; 
    height: auto; 
    background-color: #FBFBFB;
}

#nav-item-link {
    border:1px solid #d9d9d9; 
    background-color: #FBFBFB;
}

#logo-and-contents {
    margin-top: 30px;
}

#footer-img {
    background: url('/static/resource/images/img-footer1.png') no-repeat 0 0; 
    width: 72px; 
    height: 29px;
}
</style>
</head>
<body>
<footer>
    <div id="nav-item-link">
        <div class="container-fluid">
            <div class="row">
                <ul class="nav">
                    <li class="nav-item">
                        <a class="nav-link text-muted" href="#">요기요 사장님</a>
                    </li>
                    <span class="navbar-text">
                        |
                    </span>
                    <li class="nav-item">
                        <a class="nav-link text-muted" href="#">Link</a>
                    </li>
                    <span class="navbar-text">
                        |
                    </span>
                    <li class="nav-item">
                        <a class="nav-link text-muted" href="#">Link</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    
    <div>
        <div id="logo-and-contents" class="container-fluid">
            <div class="row">
                <div class="col-sm-2">
                    <div id="footer-img"></div>
                </div>
                <div class="col-sm-10">
                    <strong>(주) 중앙HTA 2005기 파이널 프로젝트 - 2조</strong>
                    <p style="margin-top: 20px;">서울특별시 종로구 봉익동 율곡로10길 105 디아망 | 조장 : 유정국 | 조원 : 단비, 혜영, 연우</p>
                    <div id="clean-review"></div>
                </div>
            </div>
        </div>
    </div>
</footer>
</body>
</html>