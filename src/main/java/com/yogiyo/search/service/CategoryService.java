package com.yogiyo.search.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.yogiyo.search.vo.Category;

@Service
public interface CategoryService {

	/**
	 * 모든 카테고리의 정보를 반환한다. 
	 * @return 카테고리 리스트
	 */
	List<Category> getAllCategories();

	/**
	 * 카테고리 번호로 카테고리 정보를 조회해서 반환한다.
	 * @param categoryNo 카테고리 번호
	 * @return 카테고리
	 */
	Category getCategoryByNo(int categoryNo);

	
	/*
	 * 지정된 검색조건에 해당하는 책 정보 및 페이징 정보를 반환한다.
	 * @param condition 검색조건
	 * @return 책목록과 페이징 정보를 포함하고 있는 Map객체
	 *
	 Map<String, Object> getStores(Map<String, Object> condition);
	 */
}
