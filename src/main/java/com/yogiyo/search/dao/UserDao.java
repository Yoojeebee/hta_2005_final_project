package com.yogiyo.search.dao;

import org.apache.ibatis.annotations.Mapper;

import com.yogiyo.search.vo.User;
@Mapper
public interface UserDao {
	
	void insertNewUser(User user);
	
	void updateUser(User user);
	
	User getUserbyNo(int userNo);
	
	User getUserbyId(String userId);


}
