package com.yogiyo.owner.form;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OwnerForm {

	private String name;
	private String id;
	private String password;
	private String email;
	private String tel;
	private String address;
	private String bank;
	private Long bankNumber;
	private Long license;

}
