package com.yogiyo.search.dao;

import org.apache.ibatis.annotations.Mapper;

import com.yogiyo.search.vo.User;
@Mapper
public interface UserDao {
	
	/**
	 * 새로운 사용자를 추가한다.
	 * @param user 사용자 정보
	 */
	void insertNewUser(User user);
	
	
	/**
	 * 지정된 사용자 번호로 조회된 사용자정보를 반환한다.
	 * @param userNo 사용자 번호
	 * @return 사용자정보
	 */
	User getUserbyNo(int userNo);
	
	/**
	 * 지정된 사용자 아이디로 조회된 사용자정보를 반환한다.
	 * @param userId 사용자 아이디
	 * @return 사용자정보
	 */
	User getUserbyId(String userId);
}
