package com.yogiyo.pay.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yogiyo.pay.vo.OptionMenu;

@Mapper
public interface OptionMenuDao {

	/**
	 * 주문표번호에 해당하는 옵션메뉴정보를 조회하는 기능
	 * @param cartItemNo
	 * @return
	 */
	List<OptionMenu> getOptionMenuByCartItemNo(int cartItemNo);
	
	/**
	 * 옵션메뉴정보를 DB에 저장하는 기능
	 * @param optionMenu
	 */
	void insertOptionMenu(OptionMenu optionMenu);
}
