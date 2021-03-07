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

                    <br/>

                    <div id="essential" style="display: block;">
                        <div class="ess-option border p-1 mb-2">
                        	<div id="groupName">
                                <div class="container-fluid">
									<div class="row">
										<div class="col-12">
											<div class="input-group mb-3 input-group-sm">
												메뉴 옵션 이름 입력
											</div>
										</div>
										<div class="col-6">
											<div class="input-group mb-3 input-group-sm">
												<input id="groupName" name="groupName" class="groupName" type="text" class="form-control form-control-sm" placeholder="옵션 이름 입력">
											</div>
										</div>
										<!-- <div class="col-12">
											<div id="btn-area">
                        						<input type="button" class="btn btn-primary btn-sm" onclick="optAdd(this);" value="옵션 추가"/>
                        					</div>
										</div> -->
									</div>
								</div>
                            </div>
                            <div class="container-fluid">
								<div class="row">
									<div class="col-12">
										<div class="input-group mb-3 input-group-sm">
											옵션의 이름 및 가격 입력
										</div>
									</div>
								</div>
							</div>
                            <div id="option">
                                <div class="container-fluid" style="margin-bottom: 12px;">
									<div class="row">
										<div class="col-5">
											<input class="detailName" type="text" name="optName" style="width: 100%;" placeholder="이름 입력">
										</div>
										<div class="col-5">
											<input class="detailPrice" type="text" name="optPrice" style="width: 100%;" onclick="checkNum(event)" placeholder="가격 입력">
										</div>
										<div class="col-2" style="padding: 0;">
                        					<input type="button" class="btn btn-primary btn-sm btn-block" onclick="optAdd(this);" value="추가"/>
										</div>
									</div>
								</div>
                            </div>
                        </div>
                    </div>

                    <%-- 옵션 메뉴 선택 --%>
					<div class="form-group">
						<label for="price">옵션 메뉴 선택</label>
						<!-- 옵션 메뉴 그룹들 -->
						<c:if test="${distictOptionGroup.size() >= 1}">
							<c:forEach var="group" items="${distictOptionGroup }">
								<div class="container" style="display: block;">
									<div class="row">
										<div class="col-12">
											<input type="checkbox" id="defaultCheck" name="optionGroupNo" value="${group.groupNo}">
		    								<label for="defaultCheck">${group.groupName}</label>
										</div>
									</div>
								</div>
							</c:forEach>
					    </c:if>
					    
					</div>
					
				</form>
            </div>

            <!-- Modal footer -->
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" onclick="menuUpdate()" data-dismiss="modal">메뉴 등록</button>
                <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
            </div>
        </div> <!-- modal content -->
    </div>
</div>
