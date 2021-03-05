package com.yogiyo.owner.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yogiyo.owner.dao.OptionMenuGroupDao;
import com.yogiyo.owner.form.OptionGroupForm;
import com.yogiyo.owner.service.OptionMenuGroupService;
import com.yogiyo.owner.vo.OptionMenuGroup;
import com.yogiyo.owner.vo.StoreOptionGroup;

@Repository
public class OptionMenuGroupServiceImpl implements OptionMenuGroupService {
	
	@Autowired
	OptionMenuGroupDao optionMenuGroupDao;

	@Override
	@Transactional
	public void insertOptionMenuGroup(OptionGroupForm optionGroupform) {
		int nextVal = optionMenuGroupDao.nextVal();
		
		// 옵션 메뉴 그룹 생성
		OptionMenuGroup group = new OptionMenuGroup();
		group.setNo(nextVal);
		group.setName(optionGroupform.getOptionGroupName());
		group.setDescription(optionGroupform.getOptionGroupDescription());
		
		// 옵션 메뉴의 그룹 생성(번호, 이름, 설명)
		optionMenuGroupDao.insertOptionMenuGroupDetail(group);
		
		// 다수의 옵션 메뉴 테이블(YOGIYO_STORE_OPTION_GROUP)생성
		List<StoreOptionGroup> list = new ArrayList<>();
		for(int num : optionGroupform.getOptionMenuNo()) {
			StoreOptionGroup storeOptionGroup = new StoreOptionGroup();
			storeOptionGroup.setGroupNo(nextVal);
			storeOptionGroup.setOptionMenuNo(num);
			
			list.add(storeOptionGroup);
		}
		
		optionMenuGroupDao.insertOptionMenuGroup(list);
	}

	@Override
	public void insertOptionMenuGroupByMenuNo(List<StoreOptionGroup> list) {
		optionMenuGroupDao.insertOptionMenuGroup(list);
	}
	
	

}
