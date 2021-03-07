package com.yogiyo.owner.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class StoreMenuGroupDto {

	private int menuNo;
	
	private String menuName;

    private int menuPrice;

    private String menuThumbnail;

    private String menuDetail;

	private int groupNo;

	private String groupName;

	private String detailName;
	
	private int detailPrice;
	
	private int menuGroupNo;
	
	private String menuGroupName;
	
	private String menuGroupDescription;
	
	private int count;

}
