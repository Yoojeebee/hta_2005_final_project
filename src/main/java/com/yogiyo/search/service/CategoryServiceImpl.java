package com.yogiyo.search.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yogiyo.search.dao.CategoryDao;
import com.yogiyo.search.dao.StoreDao;
import com.yogiyo.search.vo.Category;
@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	StoreDao storeDao;
	
	@Override
	public List<Category> getAllCategories() {
		return categoryDao.getAllCategories();
	}
	
	@Override
	public Category getCategoryByNo(int categoryNo) {
		return categoryDao.getCategoryByNo(categoryNo);
	}
}
