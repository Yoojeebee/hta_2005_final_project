package com.yogiyo.search.vo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Store {

	// 번호
    private String no;
    
    // 이름
    private String name;
    
    // 이미지 이름
    private String thumbnail;
    
    // 가게 번호
    private String tel;
    
    // 오픈 시간
    private String openTime;
    
    // 닫는 시간
    private String closeTime;
    
    //  가게 주소
    private String address;
    
    // 최소 금액
    private int minPrice;
    
    // 가계 폐업 여부(폐업, 영업)
    private String closeStatus;
    
    // 가계 상태 여부(준비중, 오픈)
    private String status;
    
    // 생성 날짜
    private Date createdDate;
    
    // 현장 결제 여부(Y, N)
    private String place;
    
    // 카드 결제 여부(Y, N)
    private String card;
    
    // 리뷰 평균 점수
    private int avg;
    
    // 맛 점수
    private int taste;
    
    // 양 점수
    private int quality;
    
    // 배달 점수
    private int delivery;
    
    // 리뷰 댓글 수
    private int reviewAcc;
    
    // 사장님 댓글 수
    private int ownerAcc;
    
    // 사장님 번호
    private String ownerNo;

}
