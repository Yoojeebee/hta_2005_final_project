<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="row" style="margin-top: 10px; margin-bottom: 10px; margin-left: 1px;">
	<div class="col-12">
		<button type="button" class="menu" data-toggle="modal" data-target="#myMenu-${status.index}" style="width: 100%; border: 0; padding: 0 !important;">
			<div class="row">
				<div class="col-12">
					<div style="width: 80px; height: 80px; float: left; overflow: hidden;">
						<img src="/static/resource/images/store/${ownerNo}/${storeNo}/menu/${distictMenuGroup[status.index].menuThumbnail}" style="width: 100%; height: 100%; object-fit: fill;">
					</div>
					<div style="float: left; text-align: left; margin-left: 15px;">
						<span>${distictMenuGroup[status.index].menuName}</span><br/>
						<span>${distictMenuGroup[status.index].menuPrice}</span>
					</div>
				</div>
			</div>
		</button>
	</div>
</div>