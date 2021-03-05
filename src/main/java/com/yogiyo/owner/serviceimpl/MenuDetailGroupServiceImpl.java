package com.yogiyo.owner.serviceimpl;

import com.yogiyo.owner.dao.MenuDetailGroupDao;
import com.yogiyo.owner.dto.DetailMenu;
import com.yogiyo.owner.service.MenuDetailGroupService;
import com.yogiyo.owner.vo.MenuDetail;
import com.yogiyo.owner.vo.MenuDetailGroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class MenuDetailGroupServiceImpl implements MenuDetailGroupService {

    @Autowired
    MenuDetailGroupDao groupDao;

    @Override
    public DetailMenu[] selectAllMenuGroup(int menuNo) {
        return groupDao.selectAllMenuGroup(menuNo);
    }

    @Override
    public int selectMenuGroupNo(Map<String, Object> obj) {
        return groupDao.selectMenuGroupNo(obj);
    }

    @Override
    public void insertMenuGroup(MenuDetailGroup group) {
        groupDao.insertMenuGroup(group);
    }

    @Override
    public void insertMenuDetail(List<MenuDetail> list) {
        groupDao.insertMenuDetail(list);
    }
}
