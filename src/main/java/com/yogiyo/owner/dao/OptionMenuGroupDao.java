package com.yogiyo.owner.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yogiyo.owner.dto.StoreMenuGroupDto;
import com.yogiyo.owner.dto.StoreOptionMenuGroupDto;
import com.yogiyo.owner.vo.OptionMenuGroup;
import com.yogiyo.owner.vo.StoreOptionGroup;

@Mapper
public interface OptionMenuGroupDao {
	
	/**
	 * 그룹번호를 기준으로 포함된 옵션 메뉴를 가져온다
	 * @param groupNo
	 * @return
	 */
	List<StoreOptionMenuGroupDto> selectGroupIncludeOptionMenu(int groupNo);
	
	/**
	 * 그룹 이름을 모두 출력
	 * @param groupNo
	 * @return
	 */
	String selectByGroupName(int groupNo);
	
	/**
	 * 옵션 그룹 번호를 모두 출력
	 * 
	 * @return
	 */
	int[] selectGroupNo(String storeNo);
	
	/**
	 * 옵션 메뉴 테이블(YOGIYO_OPTION_GROUP)에 저장될 현재 번호를 가져온다
	 * @return
	 */
	int nextVal();
	
	/**
	 * 옵션 메뉴 테이블(YOGIYO_STORE_OPTION_GROUP)에 저장
	 */
	void insertOptionMenuGroup(List<StoreOptionGroup> storeOptionGroup);

	/**
	 * 옵션 메뉴 테이블(YOGIYO_OPTION_GROUP)에 저장
	 */
	void insertOptionMenuGroupDetail(OptionMenuGroup group);

}
