package com.yogiyo.search.service;

import java.util.HashMap;import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yogiyo.search.dao.CategoryDao;
import com.yogiyo.search.dao.StoreDao;
import com.yogiyo.search.dto.Pagination;
import com.yogiyo.search.vo.Category;
import com.yogiyo.search.vo.Store;
@Service
public class StoreServiceImpl implements StoreService {

	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	StoreDao storeDao;
	
	@Override
	public List<Category> getAllCategories() {
		return categoryDao.getAllCategories();
	}
	
	@Override
	public List<Store> getAllStores() {
		return storeDao.getAllStores();
	}
	
	@Override
	public Category getCategory(int categoryNo) {
		return categoryDao.getCategoryByNo(categoryNo);
	}
	
	
	@Override
	public Map<String, Object> getStores(Map<String, Object> condition) {
		Map<String, Object> result = new HashMap<String, Object>();
		// 검색조건에 해당하는 음식점의 갯수를 조회한다.
		int totalRows = storeDao.getTotalCountByCondition(condition);
		
	    // 페이지정보 생성
		Pagination pagination = new Pagination((Integer) condition.get("pageNo"), totalRows);
		
		// 검색조건에 해당하는 음식점 목록을 조회한다.
		List<Store> stores = storeDao.getStoreByCondition(condition);
		
		// 카테고리가 번호가 있는 경우 해당 카테고리 정보를 조회한다.
      	if (condition.get("category") != null) {
         	int categoryNo = (Integer) condition.get("categoryNo");
         	Category category = categoryDao.getCategoryByNo(categoryNo);
         	result.put("category", category);
      	}
		
		result.put("stores", stores);
		result.put("pagination", pagination);
		return result;
	}
}
