package com.yogiyo.search.service;

import java.util.List;import java.util.Map;

import org.springframework.stereotype.Service;

import com.yogiyo.search.vo.Category;
import com.yogiyo.search.vo.Store;
@Service
public interface StoreService {
	
	/**
	 * 지정된 검색조건에 해당하는 음식점 정보 및 페이징 정보를 반환한다.
	 * @param condition 검색조건
	 * @return 음식점 목록과 페이징 정보를 포함하고 있는 Map객체
	 */
	Map<String, Object> getStores(Map<String, Object> condition);

	/**
	 * 카테고리 번호에 대한 카테고리 정보를 제공한다.
	 * @param categoryNo 카테고리 번호
	 * @return 카테고리 정보
	 */
	Category getCategory(int categoryNo);

	/**
	 * 모든 카테고리 목록을 제공한다.
	 * @return 카테고리 목록
	 */
	List<Category> getAllCategories();
	
	/**
	 * 모든 음식점 정보를 제공한다.
	 * @return 전체 음식점 목록
	 */
	List<Store> getAllStores();
	
	/**
	 * 지정된 음식점 번호에 대한 음식점의 정보를 반환한다.
	 * @param storeNo 음식점 번호
	 * @return 음식점 정보
	 */
	Store getStoreDetail(String storeNo);
}
