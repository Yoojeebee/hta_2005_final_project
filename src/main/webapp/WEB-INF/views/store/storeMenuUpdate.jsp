<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="container">
	<div class="row">
		<div class="col-12">
			<!-- The Modal -->
			<div class="modal" id="myMenu-${status.index}">
				<div class="modal-dialog">
					<div class="modal-content">

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
										<img src="/static/resource/images/store/${ownerNo}/${storeNo}/menu/${item.thumbnail}" style="width: 100%; height: 100%;" />
									</div>
									<div>
										<h3 class="text-center">${item.name}</h3>
										<p id="menuDetail" name="menuDetail" class="text-center" rows="3">${item.detail}</p>
									</div>
								</div>
							</div>

							<div class="form-group">
								<hr/>
									<h4>가격</h4>
									<p>${item.price}</p>
								<hr/>
							</div>

							<br />
							
							<c:if test="${optionGroupSize >= 1}">
								<c:forEach var="group" items="${optionMenuGroup}" begin="0" end="${optionGroupSize - 1}" varStatus="status" step="1">
									<c:forEach var="item" items="${optionMenuGroup}">
										<c:if test="${optionGroupNo[status.index] eq item.groupNo}">
											<li class="list-group-item" style="text-align: left;">
												<input type="checkbox" id="defaultCheck" name="example2" v-bind:value="${item.optionMenuNo}">
	    										<label for="defaultCheck">${item.optionMenuName}</label>
											</li>
											<li class="list-group-item">
												<div class="row">
													<div class="col-md-12">
														<div style="width: 80px; height: 80px; float: left; border: 1px solid black; overflow: hidden;">
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
							<!-- Modal footer -->
							<div class="modal-footer">
								<button type="submit" class="btn btn-primary" v-on:click='insert("${storeNo}", 1, 1)' data-dismiss="modal">메뉴 등록</button>
								<!-- <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button> -->
							</div>
						</div>
					</div>
					<!-- modal content -->
				</div>
			</div>
		</div>
	</div>
</div>
