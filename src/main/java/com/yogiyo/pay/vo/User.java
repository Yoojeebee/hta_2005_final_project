package com.yogiyo.pay.vo;

import java.util.Date;

public class User {

	private String no;
	private String id;
	private String password;
	private String name;
	private int resReg; 		// 유저 주민등록번호
	private int tel;
	private String email;
	private int gender;			// 성별
	private int age;
	private int point;
	private String authCode;	// 이메일 인증코드
	private String authStatus;	// 이메일 인증확인
	private String status;		// 유저 로그인 상태
	private String disabled;	// 유저 탈퇴여부
	private Date createdDate;
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getResReg() {
		return resReg;
	}
	public void setResReg(int resReg) {
		this.resReg = resReg;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getAuthCode() {
		return authCode;
	}
	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}
	public String getAuthStatus() {
		return authStatus;
	}
	public void setAuthStatus(String authStatus) {
		this.authStatus = authStatus;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDisabled() {
		return disabled;
	}
	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	@Override
	public String toString() {
		return "User [no=" + no + ", id=" + id + ", password=" + password + ", name=" + name + ", resReg=" + resReg
				+ ", tel=" + tel + ", email=" + email + ", gender=" + gender + ", age=" + age + ", point=" + point
				+ ", authCode=" + authCode + ", authStatus=" + authStatus + ", status=" + status + ", disabled="
				+ disabled + ", createdDate=" + createdDate + "]";
	}
	
	
}
