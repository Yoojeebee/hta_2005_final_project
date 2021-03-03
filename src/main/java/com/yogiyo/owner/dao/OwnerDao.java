package com.yogiyo.owner.dao;

import com.yogiyo.owner.vo.Owner;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OwnerDao {

	/**
	 * Owner 테이블의 다음 순번을 가져온다
	 * @return 순번 번호
	 */
    int nextNoVal();

    /**
     * 오너 생성자 생성
     * @param owner 생성할 오너 생성자에 대한 정보
     */
    void insertNewOwner(Owner owner);

    /**
     * 가입된 오너 생성자 리스트
     * @return
     */
    List<Owner> getAllOwner();

    /**
     * 가입된 오너 생성자의 순번 획득
     * @param col 오너 테이블 컬럼 값
     * @return 오너 생성자 순번(owner_no)
     */
    String getOwnerNo(String col);
    
    /**
     * 로그인한 id와 passowrd의 값이 오너 테이블에 존재하는지 확인
     * @param id 오너 아이디
     * @param password 오너 비밀번호
     * @return 오너 정보가 담기 객체
     */
    Owner getOnwerData(String id, String password);

}
