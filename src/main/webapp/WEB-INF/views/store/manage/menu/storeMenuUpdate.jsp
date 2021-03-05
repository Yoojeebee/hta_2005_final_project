<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="container">
	<div class="row">
		<div class="col-12">
			<!-- The Modal -->
			<div class="modal" id="myMenu-${status.index}">
				<div class="modal-dialog">
					<div class="modal-content">

						<!-- Modal Header -->
						<div class="modal-header"
							style="background-color: red; text-align: center;">
							<h4>메뉴 업데이트</h4>
							<button type="button" class="close" data-dismiss="modal">&times;</button>
						</div>

						<!-- Modal body -->
						<div class="modal-body">
							<form name="updateMenu" method="post" autocomplete="off" enctype="multipart/form-data">
								<div class="form-group">
									<label for="name">메뉴 이름</label> <input id="menuName" name="menuName" type="text" class="form-control" value="${item.name}">
								</div>

								<div class="form-group">
									<label for="thumbnail" class="cols-sm-2 control-label">메뉴 이미지
										<div class="filebox" style="margin: 0">
											<label for="thumbnail" class="cols-sm-2 control-label">업로드</label>
											<input id="menuThumbnail" name="menuThumbnail" type="file" accept="image/*" onchange="changeThumbnail(this);">
										</div>
									</label>
									<div class="cols-sm-10">
										<div class="image_container" style="width: 100%; height: 300px;">
											<img src="/static/resource/images/store/${ownerNo}/${storeNo}/menu/${item.thumbnail}" style="width: 100%; height: 100%;" />
										</div>
									</div>
								</div>

								<div class="form-group">
									<label for="detail">상세 정보</label>
									<textarea id="menuDetail" name="menuDetail"
										class="form-control" rows="3">${item.detail}</textarea>
								</div>

								<div class="form-group">
									<label for="price">가격</label> <input id="menuPrice" name="menuPrice" type="number" class="form-control" onclick="checkNum(this);" value="${item.price}" placeholder="가격 입력">
								</div>

								<br />

								<c:if test="${optionGroupSize >= 1}">
									<c:forEach var="group" items="${optionMenuGroup}" begin="0" end="${optionGroupSize}" varStatus="status">
										<c:if test="${group.menuNo eq item.no}">
											<c:forEach var="groupName" items="${optionGroupName }">
												<c:if test="${(groupName eq  group.groupName)}">
													<p style="margin-bottom: 5px;">${group.groupName}</p>
												</c:if>
											</c:forEach>
											<!-- 메뉴에 속한 옵션 메뉴 그룹의 아이템 리스트 -->
											<div style="display: block;">
					    						<input type="checkbox" id="defaultCheck" name="example2">
						    					<label for="defaultCheck">${group.optionMenuName} <span class="text-right">${group.optionMenuPrice}</span></label>
					    					</div>
										</c:if>
									</c:forEach>
								</c:if>
								
							</form>
						</div>
						<!-- Modal body -->
						
						<!-- Modal footer -->
						<div class="modal-footer">
							<button type="submit" class="btn btn-primary" data-dismiss="modal">메뉴 등록</button>
						</div>
						
					</div>
					<!-- modal content -->
				</div>
			</div>
		</div>
	</div>
</div>