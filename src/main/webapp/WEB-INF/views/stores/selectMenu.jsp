<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	<div class="row">
		<div class="col-12">
			<!-- The Modal -->
			<div class="modal" id="myMenu-${status.index}">
				<div class="modal-dialog">
					<div class="modal-content">
						<%-- <form name="insertItem-${status.index}" action="/api/cart/items/insert.do" method="post" > --%>
							<!-- Modal Header -->
							<div class="modal-header" style="background-color: white; text-align: center;">
								<h4>메뉴 상세</h4>
								<button type="button" class="close" data-dismiss="modal">&times;</button>
							</div>
	
							<!-- Modal body -->
							<div class="modal-body">
								<div class="form-group">
									<div class="cols-sm-10">
										<div class="image_container" style="width: 100%; height: 300px;">
											<img src="/static/resource/images/store/${ownerNo}/${storeNo}/menu/${distictMenuGroup[status.index].menuThumbnail}" style="width: 100%; height: 100%;" />
										</div>
										<div>
											<h3 class="text-center">${distictMenuGroup[status.index].menuName}</h3>
											<p id="menuDetail" name="menuDetail" class="text-center" rows="3">${distictMenuGroup[status.index].menuDetail}</p>
										</div>
									</div>
								</div>
	
								<div class="form-group">
									<hr />
									<h4>가격</h4>
									<p>${distictMenuGroup[status.index].menuPrice}원</p>
									<hr />
								</div>
	
								<br />
								<c:set var="loop_flag" value="false" />
								<c:forEach items="${distictOptionGroup }" varStatus="optionStatus">
									<c:if test="${not loop_flag }">
										<c:if test="${distictMenuGroup[status.index].menuNo eq distictOptionGroup[optionStatus.index].menuNo }">
											<div class="form-group">
												<h4>옵션 메뉴</h4>
											</div>
											<c:set var="loop_flag" value="true" />
										</c:if>
									</c:if>
								</c:forEach>
	
								<!-- 옵션 메뉴 그룹 이름 -->
								<%-- 사이드 메뉴 추가 --%>
								<div class="form-group">
								<c:forEach items="${distictOptionGroup }" varStatus="optionStatus">
									<!-- <div style="display: block;"> -->
										<c:if test="${distictMenuGroup[status.index].menuNo eq distictOptionGroup[optionStatus.index].menuNo }">
											<c:if test="${distictOptionGroup[optionStatus.index].count < distictOptionGroup[optionStatus.count].count}">
												<div>
													<hr/>
													<h6>${distictOptionGroup[optionStatus.index].groupName}</h6>
													<hr/>
												</div>
											</c:if>
											<div>
												<input type="radio" name="optionValue-${status.index}-${distictOptionGroup[optionStatus.index].groupNo}" value="${distictOptionGroup[optionStatus.index].optionMenuNo}/${distictOptionGroup[optionStatus.index].optionMenuName}/${distictOptionGroup[optionStatus.index].optionMenuPrice}">
												<label>${distictOptionGroup[optionStatus.index].groupNo} / ${distictOptionGroup[optionStatus.index].optionMenuName} / menuNo: ${distictMenuGroup[status.index].menuNo} / optionMenuNo: ${distictOptionGroup[optionStatus.index].menuNo }</label>
						    				</div>
						    			</c:if>
									<!-- </div> -->
								</c:forEach>
								</div>
								<div class="form-group" style="display: block; text-align: right;">
									<div class="btn-group" style="display: block;">
										<button type="button" class="btn" onclick="btnPlus(${status.index})" style="background-color: #fa0050; color: white;">+</button>
										<input name="amount" type="button" class="btn" disabled='disabled' value="1" />
										<button type="button" class="btn" onclick="btnMinus(${status.index})" style="background-color: #fa0050; color: white;">-</button>
									</div>
								</div>
							</div>
	
							<!-- Modal footer -->
							<div class="modal-footer">
								<button type="button" class="btn btn-primary" onclick="onSubmit(${status.index}, ${distictMenuGroup[status.index].menuNo})" data-dismiss="modal">메뉴 등록</button>
								<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
							</div>
						<!-- </form> -->
					</div>
				</div>
			</div>
		</div>
	</div>