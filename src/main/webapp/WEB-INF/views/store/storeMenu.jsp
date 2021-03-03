<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<div class="container">
    <div class="row">
        <div class="col-12">
            <ul class="list-group">
                <button type="button" class="menu" data-toggle="modal" data-target="#myMenu-${status.index}" style="width: auto; border: 0;">

                    <li class="list-group-item" style="text-align: left;">${item.name}</li>

                    <li class="list-group-item">
                        <div class="row">
                            <div class="col-md-12">
                                <div style="width: 80px; height: 80px; float: left; border: 1px solid black; overflow: hidden;">
                                    <img src="/static/resource/images/store/${ownerNo}/${storeNo}/menu/${item.thumbnail}" style="width: 100%; height: 100%; object-fit: fill;">
                                </div>

                                <p>${item.price}</p>
                                <p>${item.detail}</p>
                                <c:if test="${group[status.index].no != null}">
                                    <p>옵션 그룹 이름 : ${group[status.index].groupName}</p>
                                    <p>옵션 이름 : ${group[status.index].optName}</p>
                                    <p>옵션 가격 : ${group[status.index].optPrice}</p>
                                </c:if>
                            </div>
                        </div>
                    </li>

                </button>
            </ul>
        </div>
    </div>
</div>