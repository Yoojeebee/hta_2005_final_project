package com.yogiyo.search.service;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yogiyo.search.dao.UserDao;
import com.yogiyo.search.exception.DuplicatedUserIdException;
import com.yogiyo.search.exception.PasswordMismatchException;
import com.yogiyo.search.exception.UserNotFoundException;
import com.yogiyo.search.vo.User;


@Service 
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao; 
	
	@Override
	public User getLoginedUserInfo(String userId, String password) {
		User user = userDao.getUserbyId(userId);
		
		// 사용자 정보가 존재하지 않으면 예외발생
		if(user == null) {
			throw new UserNotFoundException("아이디가 [" + userId + "] 존재하지 않습니다.");
		}
		String secretPassword = DigestUtils.sha256Hex(password);
		//비밀번호가 일치하지 않으면 예외발생
		if(!user.getPassword().equals(secretPassword)) {
			throw new PasswordMismatchException();
		}
		
		return user;
	}
	
	@Override
	public void insertNewUser(User user) {
		User savedUser = userDao.getUserbyId(user.getId());
		if(savedUser != null) {
			throw new DuplicatedUserIdException("아이디 [" + user.getId() + "] 가 이미 존재합니다.");
		}
		String secretPassword = DigestUtils.sha256Hex(user.getPassword());
		user.setPassword(secretPassword);
		userDao.insertNewUser(user);
	}
	
	@Override
	public boolean isExistUserId(String userId) {
		return userDao.getUserbyId(userId) != null;
	}
	
}
