package com.yogiyo.pay.vo;

import java.util.Date;

import lombok.Data;

@Data
public class PayUser {
		
		private String no;
		private String name;
		private String id;
		private String password;
		private String tel;
		private String email;
		private Date birth;
		private String status;
		private Date createdDate;
		
}
