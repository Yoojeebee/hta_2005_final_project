package com.yogiyo.owner.service;

import org.springframework.stereotype.Service;

import com.yogiyo.owner.form.OptionGroupForm;

@Service
public interface OptionMenuGroupService {
	
	/**
	 * 옵션 메뉴 그룹을 생성
	 */
	void insertOptionMenuGroup(OptionGroupForm form);

}
