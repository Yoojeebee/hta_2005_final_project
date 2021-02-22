package com.yogiyo.search.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.yogiyo.search.vo.Category;


@Mapper
public interface CategoryDao {

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
	
	
}
