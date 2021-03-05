package com.yogiyo.owner.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StoreOptionMenuGroupDto {
	
	private int groupNo;

    private String groupName;

    private String groupDescription;

    private int optionMenuNo;

    private String optionMenuName;

    private int optionMenuPrice;

    private String optionMenuThumbnail;
    
    private int menuNo;

}
