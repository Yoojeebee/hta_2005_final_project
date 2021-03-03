<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<div class="container">
    <div class="row">
        <div class="col-12">
            <ul class="list-group">
                <button type="button" class="menu" data-toggle="modal" data-target="#myMenu-${status.index}" style="width: auto; border: 0;">

                    <li class="list-group-item" style="text-align: left;">${item.optionMenuName}</li>

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
                </button>
            </ul>
        </div>
    </div>
</div>