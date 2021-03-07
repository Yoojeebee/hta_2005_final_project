package com.yogiyo.owner.serviceimpl;

import com.yogiyo.owner.dao.MenuGroupDao;
import com.yogiyo.owner.dto.StoreMenuGroupDto;
import com.yogiyo.owner.form.MenuGroupForm;
import com.yogiyo.owner.service.MenuGroupService;
import com.yogiyo.owner.vo.MenuGroup;
import com.yogiyo.owner.vo.StoreMenuGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MenuGroupServiceImpl implements MenuGroupService {

    @Autowired
    MenuGroupDao menuGroupDao;
    
    @Override
	public List<StoreMenuGroupDto> distinctSelectMenuGroup(String storeNo) {
    	
    	List<StoreMenuGroupDto> list = menuGroupDao.deduplactionMenuGroup(storeNo);
    	for(StoreMenuGroupDto dto : list) {
    		System.out.println(dto);
    	}
    	
		return list;
	}

    @Override
    @Transactional
    public void insertMenuGroup(MenuGroupForm menuGroupForm) {
        int nextVal = menuGroupDao.nextVal();

        // 메뉴 그룹 생성
        MenuGroup group = new MenuGroup();
        group.setNo(nextVal);
        group.setName(menuGroupForm.getGroupName());
        group.setDescription(menuGroupForm.getGroupDescription());
        
        // 메뉴의 그룹 생성(번호, 이름, 설명)
        menuGroupDao.insertMenuGroupDetail(group);
        
        List<StoreMenuGroup> list = new ArrayList<>();
        for(int num : menuGroupForm.getMenuNo()) {
            StoreMenuGroup storeMenuGroup = new StoreMenuGroup();
            storeMenuGroup.setGroupNo(nextVal);
            storeMenuGroup.setMenuNo(num);

            list.add(storeMenuGroup);
        }

        menuGroupDao.insertMenuGroup(list);
    }

}
