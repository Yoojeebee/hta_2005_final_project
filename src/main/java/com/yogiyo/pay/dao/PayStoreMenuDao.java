package com.yogiyo.pay.dao;

import org.apache.ibatis.annotations.Mapper;

import com.yogiyo.pay.vo.StoreMenu;

@Mapper
public interface PayStoreMenuDao {

	StoreMenu getStoreMenuByMenuNo(int menuNo);
	
}
