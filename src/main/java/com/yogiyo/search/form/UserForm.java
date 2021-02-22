package com.yogiyo.search.form;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserForm {
	private String name;
    private String id;
    private String password;
    private String password2;
    private String tel;
    private String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;
    private MultipartFile photofile;
}
