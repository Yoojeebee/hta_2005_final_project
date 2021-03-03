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

								<div class="essential-area">
									<input type="button" class="btn btn-primary btn-sm" onclick="essAdd(this);" value="필수 메뉴 추가" />
								</div>

								<br />

								<c:if test="${group[status.index].groupName eq not null}">
									<div class="essential" style="display: block">
								</c:if>
								<c:if test="${group[status.index].groupName eq null}">
									<div class="essential" style="display: none">
								</c:if>

								<div class="ess-option border p-1 mb-2">
									<div class="form-group">
										<label>필수 선택 이름 입력</label> <input name="groupName" class="groupName" type="text" class="form-control form-control-sm" value="${group[status.index].groupName}" placeholder="필수 선택 이름 입력">
									</div>

									<div class="btn-area">
										<input type="button" class="btn btn-primary btn-sm" onclick="optAdd(this);" value="옵션 추가" />
									</div>
									<br />

									<div class="option">
										<div class="form-check">
											<label class="form-check-label">
												<div class="input-group mb-3 input-group-sm">
													이름 : &nbsp; <input class="detailName" type="text" name="optName" class="form-control" value="${group[status.index].optName}"> 
													가격 : &nbsp; <input class="detailPrice" type="text" name="optPrice" class="form-control" onclick="checkNum(event)" value="${group[status.index].optPrice}">
												</div>
											</label>
										</div>
									</div>
									<br /> 
									<input type="button" class="btn btn-primary btn-sm" onclick="essOptRemove(this);" value="필수 메뉴 삭제" />
								</div>
						</div>
							<c:if test="${optionGroupSize >= 1}">
							<c:forEach var="group" items="${optionMenuGroup}" begin="0" end="${optionGroupSize - 1}" varStatus="status" step="1">
								<div class="container">
									<div class="row">
										<div class="col-12">
											<p>${optionGroupName[status.index]}</p>
										</div>
									</div>
								</div>
								<c:forEach var="item" items="${optionMenuGroup}">
									<c:if test="${optionGroupNo[status.index] eq item.groupNo}">
										<li class="list-group-item" style="text-align: left;">
											<input type="checkbox" id="defaultCheck" name="example2" value="${item.optionMenuNo}">
    										<label for="defaultCheck">${item.optionMenuName}</label>
										</li>

										<li class="list-group-item">
											<div class="row">
												<div class="col-md-12">
													<div
														style="width: 80px; height: 80px; float: left; border: 1px solid black; overflow: hidden;">
														<img src="/static/resource/images/store/${ownerNo }/${storeNo}/optionMenu/${item.optionMenuThumbnail}" style="width: 100%; height: 100%; object-fit: fill;">
													</div>

													<p>${item.optionMenuPrice}</p>
												</div>
											</div>
										</li>
									</c:if>
								</c:forEach>
							</c:forEach>
						</c:if>
						</form>
					</div>

					<!-- Modal footer -->
					<div class="modal-footer">
						<button type="button" class="btn btn-danger" onclick="menuUpdate()" data-dismiss="modal">메뉴 등록</button>
						<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
					</div>
				</div>
				<!-- modal content -->
			</div>
		</div>
	</div>
</div>
</div>
