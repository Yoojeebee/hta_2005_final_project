<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="modal" id="modalOpt">
    <div class="modal-dialog">
        <div class="modal-content">
            <form name="joinOption" action ="optionForm" method="post" autocomplete="off" enctype="multipart/form-data">
                <!-- Modal Header -->
                <div class="modal-header" style="background-color: red; text-align: center;">
                    <h4>옵션 메뉴 등록</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>

                <!-- Modal body -->
                <div class="modal-body">
                    <div class="form-group">
                        <label for="optionName">옵션 메뉴 이름</label>
                        <input id="optionName" name="optionName" type="text" class="form-control" placeholder="메뉴 이름 입력">
                    </div>

                    <div class="form-group">
                        <label for="optionThumbnail" class="cols-sm-2 control-label">
                            메뉴 이미지
                            <div class="filebox" style="margin: 0">
                                <label for="optionThumbnail" class="cols-sm-2 control-label">업로드</label>
                                <input id="optionThumbnail" name="optionThumbnail" type="file" accept="image/*" onchange="changeThumbnail(this);">
                            </div>
                        </label>
                        <div class="cols-sm-10">
                            <div class="option_image_container" style="width:100%; height: 300px;">
                                <img style="width: 100%; height: 100%;"/>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="optionPrice">가격</label>
                        <input id="optionPrice" name="optionPrice" type="number" class="form-control" onclick="checkNum(this);" placeholder="가격 입력">
                    </div>
                </div>

                <!-- Modal footer -->
                <div class="modal-footer">
                    <button type="submit" class="btn btn-success" onclick="optionUpdate()" data-dismiss="modal">메뉴 등록</button>
                    <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                </div>
            </form>
        </div> <!-- modal content -->
    </div>
</div>