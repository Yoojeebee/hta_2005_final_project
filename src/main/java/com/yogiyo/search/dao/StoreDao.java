package com.yogiyo.search.dao;

import java.util.List;import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.yogiyo.search.vo.Store;

@Mapper
public interface StoreDao {
	
	List<Store> getAllStores();										// 음식점 전체조회
	
	List<Store> getStoreByCondition(Map<String, Object> condition);	// 음식점 조건 조회
	
	Store getStoreByNo(String storeNo);								// 음식점 번호로 음식점 조회
	
	List<Store> getStoresByCategory(int categoryNo);				// 카테고리 번호로 음식점 조회
	
	int getTotalCountByCondition(Map<String, Object> condition);
	
	

}
