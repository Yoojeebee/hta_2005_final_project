package com.yogiyo.review.form;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

/**
 * 사용자가 리뷰를 작성할때 받아오는 값
 * @author wooni
 *
 */
@Data
public class ReviewForm {

	private String contents;
	private int tasteScore;
	private int quantityScore;
	private int deliveryScore;
	private MultipartFile reviewPhoto1;
	private MultipartFile reviewPhoto2;
	private MultipartFile reviewPhoto3;
	private String orderInfo;
}
