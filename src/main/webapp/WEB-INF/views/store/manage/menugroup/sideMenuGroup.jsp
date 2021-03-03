<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../../../common/taglib.jsp"%>

<!-- The Modal -->
<div class="modal" id="sideMenuGroup">
	<div class="modal-dialog">
		<div class="modal-content">

			<!-- Modal Header -->
			<div class="modal-header" style="background-color: red; text-align: center;">
				<h4>옵션 메뉴 그룹 생성</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>

			<form name="joinOptionMenu" action="optionMenuGroup" method="post" autocomplete="off">
				<!-- Modal body -->
				<div class="modal-body">
					<div class="form-group">
						<label for="optionGroupName">옵션 메뉴 그룹 이름 <button type="button" class="btn btn-primary btn-sm" onclick="checkMenuGroup()">옵션 메뉴 그룹 체크</button></label>
						<input id="optionGroupName" name="optionGroupName" type="text" class="form-control" placeholder="옵션 메뉴 그룹 이름 입력"> 
						<input id="optionGroupDescription" name="optionGroupDescription" type="text" class="form-control" placeholder="옵션 메뉴 그룹 설명 입력">
					</div>
				</div>

				<%-- 사이드 메뉴 추가 --%>
				<div style="display: block; text-align: center;">
					<div class="form-check">
						<c:forEach var="item" items="${optionMenu}" varStatus="status">
							<div class="container text-left">
								<div class="row">
									<div class="col-lg-12">
										<label class="form-check-label" style="padding-right: 30px;">
											<input type="checkbox" class="form-check-input" name="optionMenuNo" value="${item.no}"> 옵션 메뉴 이름 : ${item.optionName} / 옵션 메뉴 가격 : ${item.optionPrice}
											<div style="width: 100px; height: 100px; overflow: hidden;">
												<img src="/static/resource/images/store/${ownerNo }/${storeNo}/optionMenu/${item.optionThumbnail}" style="width: 100%; height: 100%; object-fit: fill;">
											</div>
										</label>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
				<%-- 사이드 메뉴 추가 --%>

				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" onclick="optionMenuGroupAdd()" data-dismiss="modal">메뉴 등록</button>
					<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
				</div>
			</form>
		</div>
		<!-- modal content -->
	</div>
</div>
<script>
    function menuGroupAdd() {

        event.stopPropagation();
    }
</script>