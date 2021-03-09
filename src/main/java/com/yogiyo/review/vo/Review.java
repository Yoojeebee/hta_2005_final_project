package com.yogiyo.review.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class Review {

	private int no;								// 리뷰 넘버
	private String contents;					// 리뷰 내용
	@JsonFormat(pattern="yyyy년 M월 d일")			
	private Date reviewCreatedDate;				// 리뷰 생성 날짜
	private int tasteScore;						// 맛 점수
	private int quantityScore;					// 양 점수
	private int deliveryScore;					// 배달 점수
	private int avgScore;
	private String photo1;						// 리뷰 포토1 경로
	private String photo2;						// 리뷰 포토2 경로
	private String photo3;						// 리뷰 포토3 경로
	private String ownerNo;						// 오너 넘버
	private String ownerComment;				// 오너 코멘트
	@JsonFormat(pattern="yyyy년 M월 d일")	
	private Date ownerReviewCreatedDate;		// 오너 코멘트 생성 날짜
	private String storeNo;						// 가게 넘버
	private int userNo;							// 유저 넘버
	private String userId;						// 유저 아이디
	private String disabled;					// default 'N' 활성화, 'Y' 비활성화
	private String orderInfo;
	private int orderNo;
	
}
