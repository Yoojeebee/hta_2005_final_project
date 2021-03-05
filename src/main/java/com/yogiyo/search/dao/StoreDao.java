package com.yogiyo.search.dao;

import java.util.List;import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.yogiyo.search.vo.Store;

@Mapper
public interface StoreDao {
	
	/**
	 * 전체 음식점 정보를 조회한다.
	 * @return 전체 음식점
	 */
	List<Store> getAllStores();										// 음식점 전체조회
	
	/**
	 * 조건에 맞는 음식점을 조회한다.
	 * @param condition 조건
	 * @return 조회된 조건에 맞는 음식점
	 */
	List<Store> getStoreByCondition(Map<String, Object> condition);	// 음식점 조건 조회
	
	/**
	 * 지정된 음식점 번호로 조회된 음식점 정보를 반환한다.
	 * @param storeNo 음식점 번호
	 * @return 지정된 음식점 번호의 음식점
	 */
	Store getStoreByNo(String storeNo);								// 음식점 번호로 음식점 조회

	/**
	 * 지정된 카테고리 번호로 음식점을 조회한다.
	 * @param categoryNo 카테고리 번호
	 * @return 지정된 카테고리 번호의 음식점
	 */
	List<Store> getStoresByCategory(int categoryNo);				// 카테고리 번호로 음식점 조회
	
	/**
	 * 조건에 맞는 총합을 반환한다.
	 * @param condition 조건
	 * @return 조건에 맞는 총합
	 */
	int getTotalCountByCondition(Map<String, Object> condition);	// 페이징 처리 할때 사용하는 메소드

}
