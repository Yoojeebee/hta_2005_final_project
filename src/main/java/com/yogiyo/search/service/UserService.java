package com.yogiyo.search.service;

import org.springframework.stereotype.Service;

import com.yogiyo.search.vo.User;

@Service
public interface UserService {
	void insertNewUser(User user);
	
	boolean isExistUserId(String userId);
	
	User getLoginedUserInfo(String userId, String password);

}
