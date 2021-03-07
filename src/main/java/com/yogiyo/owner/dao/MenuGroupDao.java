package com.yogiyo.owner.dao;

import com.yogiyo.owner.dto.StoreMenuGroupDto;
import com.yogiyo.owner.dto.StoreOptionMenuGroupDto;
import com.yogiyo.owner.vo.StoreMenuGroup;
import com.yogiyo.owner.vo.MenuGroup;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuGroupDao {
	
	List<StoreMenuGroupDto> deduplactionMenuGroup(String storeNo);

	int currVal();

	int nextVal();

	/**
	 * 그룹번호를 기준으로 포함된 메뉴를 가져온다
	 * @param groupNo
	 * @return
	 */
	List<StoreMenuGroupDto> selectGroupIncludeMenu(int groupNo);

	/**
	 * 그룹 이름을 모두 출력
	 * @param groupNo
	 * @return
	 */
	String selectByGroupName(int groupNo);

//    String groupNames(int groupNo);

	/**
	 * 음식 그룹 번호를 모두 출력
	 * 
	 * @return
	 */
	int[] selectGroupNo(String storeNo);

	/**
	 * 그룹 번호를 기준으로 들어가는 음식 메뉴 번호
	 * 
	 * @param list
	 */
	void insertMenuGroup(List<StoreMenuGroup> list);

	/**
	 * 음식 그룹을 입력
	 * 
	 * @param menuGroup
	 */
	void insertMenuGroupDetail(MenuGroup menuGroup);

}
