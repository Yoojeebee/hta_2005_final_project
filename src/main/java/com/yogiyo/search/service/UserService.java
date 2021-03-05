package com.yogiyo.search.service;

import org.springframework.stereotype.Service;

import com.yogiyo.search.vo.User;

@Service
public interface UserService {

	/**
	 * 새로운 사용자를 추가한다.
	 * @param user 사용자 정보
	 */
	void insertNewUser(User user);
	
	/**
	 * 사용자 아이디 존재여부를 확인한다.
	 * @param userId 사용자 아이디
	 * @return 사용자 아이디 존재여부
	 */
	boolean isExistUserId(String userId);
	
	/**
	 * 로그인된 사용자의 정보
	 * @param userId 사용자 아이디
	 * @param password 사용자 비밀번호
	 * @return 사용자의 정보
	 */
	User getLoginedUserInfo(String userId, String password);
	
	/**
	 * 지정된 사용자 아이디로 조회된 사용자정보를 반환한다.
	 * @param userId 사용자 아이디
	 * @return 사용자정보
	 */
	User getUserById(String userId);

}
