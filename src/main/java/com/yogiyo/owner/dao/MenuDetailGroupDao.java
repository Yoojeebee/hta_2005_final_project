package com.yogiyo.owner.dao;

import com.yogiyo.owner.dto.DetailMenu;
import com.yogiyo.owner.vo.MenuDetail;
import com.yogiyo.owner.vo.MenuDetailGroup;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MenuDetailGroupDao {

	/**
	 * 가게에 등록된 각 메뉴의 옵션들을 가져온다
	 * 
	 * @param menuNo
	 * @return
	 */
	DetailMenu[] selectAllMenuGroup(int menuNo);

	/**
	 * 메뉴에 등록된 옵션의 이름 및 가격을 생성하기 위해 옵션 그룹 번호를 가져온다
	 * 
	 * @param obj
	 * @return
	 */
	int selectMenuGroupNo(Map<String, Object> obj);

	/**
	 * 메뉴의 옵션 그룹 이름을 저장한다(메뉴를 기준으로)
	 * 
	 * @param group
	 */
	void insertMenuGroup(MenuDetailGroup group);

	/**
	 * 메뉴에 등록된 옵션 그룹 이름에 대한 상세 내용을 저장한다
	 * 
	 * @param detail
	 */
	void insertMenuDetail(List<MenuDetail> detail);

}
