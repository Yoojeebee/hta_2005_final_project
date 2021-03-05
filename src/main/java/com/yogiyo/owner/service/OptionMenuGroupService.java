package com.yogiyo.owner.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yogiyo.owner.form.OptionGroupForm;
import com.yogiyo.owner.vo.StoreOptionGroup;

@Service
public interface OptionMenuGroupService {
	
	/**
	 * 옵션 메뉴 그룹을 생성
	 */
	void insertOptionMenuGroup(OptionGroupForm form);
	
	/**
	 * 옵션 메뉴 그룹 테이블의 행에 데이터 추가
	 */
	void insertOptionMenuGroupByMenuNo(List<StoreOptionGroup> list);

}
