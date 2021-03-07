<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="container">
    <div class="row">
        <div class="col-12">
            <!-- The Modal -->
            <div class="modal" id="myMenu-${status.index}">
                <div class="modal-dialog">
                    <div class="modal-content">

                        <!-- Modal Header -->
                        <div class="modal-header" style="background-color: red; text-align: center;">
                            <h4>메뉴 업데이트</h4>
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                        </div>

                        <!-- Modal body -->
                        <div class="modal-body">
                            <form name="updateMenu" method="post" autocomplete="off" enctype="multipart/form-data">
                                <div class="form-group">
                                    <label for="name">메뉴 이름</label>
                                    <input id="menuName" name="menuName" type="text" class="form-control" value="${distictMenuGroup[status.index].menuName}">
                                </div>

                                <div class="form-group">
                                    <label for="thumbnail" class="cols-sm-2 control-label">
                                        메뉴 이미지
                                        <div class="filebox" style="margin: 0">
                                            <label for="thumbnail" class="cols-sm-2 control-label">업로드</label>
                                            <input id="menuThumbnail" name="menuThumbnail" type="file" accept="image/*" onchange="changeThumbnail(this);">
                                        </div>
                                    </label>
                                    <div class="cols-sm-10">
                                        <div class="image_container" style="width:100%; height: 300px;">
                                            <img src="/static/resource/images/store/${ownerNo}/${storeNo}/menu/${distictMenuGroup[status.index].menuThumbnail}" style="width: 100%; height: 100%;"/>
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="detail">상세 정보</label>
                                    <textarea id="menuDetail" name="menuDetail" class="form-control" rows="3" >${distictMenuGroup[status.index].menuDetail}</textarea>
                                </div>

                                <div class="form-group">
                                    <label for="price">가격</label>
                                    <input id="menuPrice" name="menuPrice" type="number" class="form-control" onclick="checkNum(this);" value="${distictMenuGroup[status.index].menuPrice}" placeholder="가격 입력">
                                </div>
                                
                                <!-- 옵션 메뉴 그룹 이름 -->
								<%-- 사이드 메뉴 추가 --%>
								<c:forEach items="${distictOptionGroup }" varStatus="optionStatus" step="1">
									<c:if test="${distictMenuGroup[status.index].menuNo eq distictOptionGroup[optionStatus.index].menuNo }">
										<c:if test="${distictOptionGroup[optionStatus.index].count < distictOptionGroup[optionStatus.count].count}">
												<h1>${distictOptionGroup[optionStatus.index].groupName}</h1>
										</c:if>
										<div style="display: block;">
											<input type="checkbox" id="defaultCheck" name="example2">
											<label for="defaultCheck">${distictOptionGroup[optionStatus.index].optionMenuName}
												<span class="text-right">${distictOptionGroup[optionStatus.index].optionMenuPrice}</span>
											</label>
										</div>
									</c:if>
				
									<c:if test="${distictOptionGroup[status.count].count == 1}">
										<br />
									</c:if>
								</c:forEach>

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
        </div>
    </div>
</div>
