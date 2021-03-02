package com.yogiyo.review.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yogiyo.review.dao.ReviewUserDao;

@Service
public class ReviewUserServiceImpl implements ReviewUserService{

	@Autowired
	ReviewUserDao reviewUserDao;
	
	/*
	@Override
	public User getUserbyNo(int userNo) {
		User user = reviewUserDao.getUserbyNo(userNo);
		return user;
	}
	*/
	
	//@Override
	//public String getUserId() {
	//	return reviewUserDao.getUserId();
	//}
}
