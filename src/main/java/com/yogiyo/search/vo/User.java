package com.yogiyo.search.vo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class User {
	
	private int no;
	private String name;
	private String id;
	private String password;
	private String tel;
	private String email;
	private Date birth;
	private String status;
	private Date createdDate;
	
}

