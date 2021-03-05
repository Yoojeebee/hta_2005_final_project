package com.yogiyo.review.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yogiyo.review.dao.ReviewOrderDao;
import com.yogiyo.review.vo.ReviewOrderItem;

@Service
public class ReviewOrderServiceImpl implements ReviewOrderService {

	@Autowired
	ReviewOrderDao orderDao;
	
	/**
	 * userNo로 내가 주문한 내역 조회
	 * @param userNo
	 * @return ReviewOrderItem
	 */
	//@Override
	//public List<ReviewOrderItem> getOrderInfoByUserNo(String userNo, int orderNo) {
		
	//	List<ReviewOrderItem> list = orderDao.getOrderInfoByUserNo(userNo, orderNo);
	//	StringBuilder sb = new StringBuilder();
	//	for(int i=0; i < list.size(); i++) {
	//		sb.append(false)
	//	}
		
	//	return list;
	//}

}
