package com.yogiyo.owner.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class StoreMenuGroupDto {

    private int groupNo;

    private String groupName;

    private String groupDescription;

    private int menuNo;

    private String menuName;

    private int menuPrice;

    private String menuThumbnail;

    private String menuDetail;

}
