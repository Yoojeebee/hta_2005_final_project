package com.yogiyo.review.form;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ReviewForm {

	private String contents;
	private int tasteScore;
	private int quantityScore;
	private int deliveryScore;
	private MultipartFile reviewPhoto1;
	private MultipartFile reviewPhoto2;
	private MultipartFile reviewPhoto3;
}
