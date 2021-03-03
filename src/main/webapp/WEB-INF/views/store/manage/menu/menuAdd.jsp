<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<div class="modal" id="myModal">
    <div class="modal-dialog">
        <div class="modal-content">

            <!-- Modal Header -->
            <div class="modal-header" style="background-color: red; text-align: center;">
                <h4>음식 메뉴 등록</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>

            <!-- Modal body -->
            <div class="modal-body">
                <form name="joinMenu" action ="menuForm" method="post" autocomplete="off" enctype="multipart/form-data">
                    <div class="form-group">
                        <label for="name">메뉴 이름</label>
                        <input id="name" name="name" type="text" class="form-control" placeholder="메뉴 이름 입력">
                    </div>

                    <div class="form-group">
                        <label for="thumbnail" class="cols-sm-2 control-label">
                            메뉴 이미지
                            <div class="filebox" style="margin: 0">
                                <label for="thumbnail" class="cols-sm-2 control-label">업로드</label>
                                <input id="thumbnail" name="thumbnail" type="file" accept="image/*" onchange="setThumbnail(this);">
                            </div>
                        </label>
                        <div class="cols-sm-10">
                            <div id="image_container" style="width:100%; height: 300px;">
                                <img style="width: 100%; height: 100%;"/>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="detail">상세 정보</label>
                        <textarea id="detail" name="detail" class="form-control" rows="3" ></textarea>
                    </div>

                    <div class="form-group">
                        <label for="price">가격</label>
                        <input id="price" name="price" type="number" class="form-control" onclick="checkNum(this);" placeholder="가격 입력">
                    </div>

                    <div id="essential-area">
                        <input type="button" class="btn btn-primary btn-sm" onclick="essAdd(this);" value="필수 메뉴 추가"/>
                        <input type="button" class="btn btn-primary btn-sm" value="사이드 메뉴 추가"/>
                    </div>

                    <br/>

                    <div id="essential" style="display:none;">
                        <div class="ess-option border p-1 mb-2">
                            <div class="form-group">
                                <label for="groupName">옵션 이름 입력</label>
                                <input id="groupName" name="groupName" class="groupName" type="text" class="form-control form-control-sm" placeholder="옵션 이름 입력">
                            </div>

                            <div id="btn-area">
                                <input type="button" class="btn btn-primary btn-sm" onclick="optAdd(this);" value="옵션 추가"/>
                            </div>
                            <br/>

                            <div id="option">
                                <div class="form-check">
                                    <label class="form-check-label">
                                        <div class="input-group mb-3 input-group-sm">
                                            이름 : &nbsp; <input class="detailName" type="text" name="optName" class="form-control">
                                        </div>
                                        <div class="input-group mb-3 input-group-sm">
                                        	가격 : &nbsp; <input class="detailPrice" type="text" name="optPrice" class="form-control" onclick="checkNum(event)">
                                        </div>
                                    </label>
                                </div>
                            </div>
                            <br/>
                            <input type="button" class="btn btn-primary btn-sm" onclick="essOptRemove(this);" value="필수 메뉴 삭제"/>
                        </div>
                    </div>

                    <%-- 사이드 메뉴 추가 --%>
                    <%-- <div style="display: block; text-align: center;">
                        <div class="form-check">
                            <c:forEach var="item" items="${optionMenu}">
                                <label class="form-check-label" style="padding-right: 30px;">
                                    <input type="checkbox" class="form-check-input" value=""> ${item.optionName} / ${item.optionPrice}
                                    <div style="width: 100px; height: 100px; overflow: hidden;">
                                        <img src="/static/images/store/${storeNo}/optionMenu/${item.optionThumbnail}" style="width: 100%; height: 100%; object-fit: cover;">
                                    </div>
                                </label>
                            </c:forEach>
                        </div>
                    </div> --%>
                    <%-- 사이드 메뉴 추가 --%>
                </form>
            </div>

            <!-- Modal footer -->
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" onclick="menuUpdate()" data-dismiss="modal">메뉴 등록</button>
                <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
            </div>
        </div> <!-- modal content -->
    </div>
</div>
