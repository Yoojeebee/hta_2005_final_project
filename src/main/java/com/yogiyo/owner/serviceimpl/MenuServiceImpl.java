package com.yogiyo.owner.serviceimpl;

import com.yogiyo.owner.dao.MenuDao;
import com.yogiyo.owner.dao.MenuDetailGroupDao;
import com.yogiyo.owner.dao.MenuGroupDao;
import com.yogiyo.owner.dao.OOptionMenuDao;
import com.yogiyo.owner.dao.OStoreDao;
import com.yogiyo.owner.dto.DetailMenu;
import com.yogiyo.owner.dto.StoreMenuGroupDto;
import com.yogiyo.owner.form.MenuForm;
import com.yogiyo.owner.service.MenuService;
import com.yogiyo.owner.utils.SessionUtils;
import com.yogiyo.owner.vo.Menu;
import com.yogiyo.owner.vo.MenuDetail;
import com.yogiyo.owner.vo.MenuDetailGroup;
import com.yogiyo.owner.vo.OOptionMenu;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class MenuServiceImpl implements MenuService {
	
	/**
	 * 가게 메뉴 이미지 저장 장소
	 */
	@Value("${upload.img.path}")
	private String uploadDir;

    @Autowired
    MenuDao menuDao;
    
    @Autowired
    OStoreDao storeDao;

    @Autowired
    MenuDetailGroupDao menuDetailGroupDao;

    @Autowired
    OOptionMenuDao optionMenuDao;

    @Autowired
    MenuGroupDao menuGroupDao;

    @Override
    public Map<String, Object> selectAllGroup(String storeNo) {
        Map<String, Object> items = new ConcurrentHashMap<>();

        int[] groupNo = menuGroupDao.selectGroupNo(storeNo);
        String[] groupName = new String[groupNo.length];
        int i = 0;
        for(int num : groupNo) {
            groupName[i++] = menuGroupDao.selectByGroupName(num);
        }

        List<StoreMenuGroupDto> storeMenuGroupDtoList = new ArrayList<>();
        for (int num : groupNo) {
            List<StoreMenuGroupDto> list = menuGroupDao.selectGroupIncludeMenu(num);
            for(StoreMenuGroupDto dto : list) {
                storeMenuGroupDtoList.add(dto);
            }
        }

        items.put("groupNo", groupNo);
        items.put("groupName", groupName);
        items.put("groupSize", groupNo.length);
        items.put("menuGroup", storeMenuGroupDtoList);

        return items;
    }

    @Override
    @Transactional
    public Map<String, Object> selectAll(String storeNo) {
        Map<String, Object> items = new ConcurrentHashMap<>();

        // 메뉴를 담는다
        items.put("menu", menuDao.selectAll(storeNo));

        // 가게에 등록된 메뉴의 옵션 기능들을 담는다
        int[] menuNos = menuDao.selectMenuNo(storeNo);
        List<DetailMenu> group = new ArrayList<>();
        if(menuNos.length != 0) {
            for (int num : menuNos) {
                group.add(menuDetailGroupDao.selectAllMenuGroup(num));
            }
        }
        items.put("menuGroup", group);

        // 가게에 등록된 옵션 메뉴(= 사이드 메뉴)를 담는다
        List<OOptionMenu> optionMenu = optionMenuDao.selectAllOptionMenu(storeNo);
        if(!optionMenu.isEmpty()) {
            items.put("optionMenu", optionMenu);
        }

        return items;
    }

	@Override
	@Transactional
	public boolean insertMenu(MenuForm form) throws IOException {
		// 메뉴 음식 생성
		Menu menu = new Menu();
		String storeNo = storeDao.getStoreNo((String) SessionUtils.getAttribute("OWNER_NO"));
		String ownerNo = (String)SessionUtils.getAttribute("OWNER_NO");

		menu.setThumbnail(form.getThumbnail().getOriginalFilename());
		menu.setStoreNo(storeNo);
		BeanUtils.copyProperties(form, menu);

		// 메뉴 음식 등록
		menuDao.insertMenu(menu);

		if (!new File(uploadDir + "/" + ownerNo + "/" + storeNo).isDirectory()) {
			new File(uploadDir + "/" + ownerNo + "/" + storeNo).mkdir();
		}
		if (!new File(uploadDir + "/" + ownerNo + "/" + storeNo + "/menu").isDirectory()) {
			new File(uploadDir + "/" + ownerNo + "/" + storeNo + "/menu").mkdir();
		}

		// 메뉴 음식 그림 저장
		FileCopyUtils.copy(form.getThumbnail().getBytes(), 
				new File(new File(uploadDir + "/" + ownerNo + "/" + storeNo + "/menu"), form.getThumbnail().getOriginalFilename()));

		if (!form.getGroupName().isEmpty()) {
			// 메뉴의 옵션 그룹 생성
			int menuNo = menuDao.currentNoVal();
			MenuDetailGroup group = new MenuDetailGroup();
			group.setName(form.getGroupName());
			group.setMenuNo(menuNo);

			menuDetailGroupDao.insertMenuGroup(group);

			// 메뉴의 옵션 이름 및 가격 생성
			Map<String, Object> map = new ConcurrentHashMap<String, Object>();
			map.put("name", form.getGroupName());
			map.put("menuNo", menuNo);
			int groupNo = menuDetailGroupDao.selectMenuGroupNo(map);
			MenuDetail detail = new MenuDetail();
			detail.setName(form.getOptName());
			detail.setPrice(form.getOptPrice());
			detail.setGroupNo(groupNo);

			menuDetailGroupDao.insertMenuDetail(detail);
		}
		return false;
	}

}
