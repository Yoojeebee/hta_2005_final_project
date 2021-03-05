package com.yogiyo.owner.service;

import com.yogiyo.owner.dto.DetailMenu;
import com.yogiyo.owner.vo.MenuDetail;
import com.yogiyo.owner.vo.MenuDetailGroup;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface MenuDetailGroupService {

    DetailMenu[] selectAllMenuGroup(int menuNo);

    int selectMenuGroupNo(Map<String, Object> obj);

    void insertMenuGroup(MenuDetailGroup group);

    void insertMenuDetail(List<MenuDetail> list);

}
