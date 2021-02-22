package com.yogiyo.search.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CategoryRegStore {
	
	private int categoryNo;
	private String categoryName;
	
	private String no;
	private String name;
	private String thumbnailPath;
	private String tel;
	private String open;
	private String closed;
	private String address;
	private int minPrice;
	private String status;
	private Date createdDate;
	private String ownerNo;

}
