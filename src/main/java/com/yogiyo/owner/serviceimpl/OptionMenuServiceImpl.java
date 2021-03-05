package com.yogiyo.owner.serviceimpl;

import com.yogiyo.owner.dao.OOptionMenuDao;
import com.yogiyo.owner.dao.OStoreDao;
import com.yogiyo.owner.dao.OptionMenuGroupDao;
import com.yogiyo.owner.dto.StoreOptionMenuGroupDto;
import com.yogiyo.owner.form.OptionMenuForm;
import com.yogiyo.owner.service.OptionMenuService;
import com.yogiyo.owner.utils.SessionUtils;
import com.yogiyo.owner.vo.OOptionMenu;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class OptionMenuServiceImpl implements OptionMenuService {
	
	/**
	 * 가게 메뉴 이미지 저장 장소
	 */
	@Value("${upload.img.path}")
	private String uploadDir;

	@Autowired
	OStoreDao storeDao;
	
    @Autowired
    OOptionMenuDao optionMenuDao;
    
    @Autowired
    OptionMenuGroupDao optionMenuGroupDao;
    
    @Override
	public Map<String, Object> selectAllGroup(String storeNo) {
    	Map<String, Object> items = new ConcurrentHashMap<>();
    	
    	int[] groupNo = optionMenuGroupDao.selectGroupNo(storeNo);
    	
    	String[] groupName =  new String[groupNo.length];
    	int cnt = 0;
    	for(int num : groupNo) {
    		groupName[cnt++] = optionMenuGroupDao.selectByGroupName(num);
//    		System.out.println("groupName= " + groupName[cnt-1]);
    	}
    	
    	List<StoreOptionMenuGroupDto> storeOptionMenuGroupDto = new ArrayList<>();
    	for(int num : groupNo) {
    		List<StoreOptionMenuGroupDto> list = optionMenuGroupDao.selectGroupIncludeOptionMenu(num);
    		for(StoreOptionMenuGroupDto dto : list) {
    			storeOptionMenuGroupDto.add(dto);
    		}
    	}
    	
    	items.put("groupNo", groupNo);
    	items.put("optionGroupNo", groupNo);
        items.put("optionGroupName", groupName);
//        items.put("optionGroupSize", groupNo.length);
        items.put("optionGroupSize", storeOptionMenuGroupDto.size());
        items.put("optionMenuGroup", storeOptionMenuGroupDto);
    	
    	return items;
	}

    @Override
    public List<OOptionMenu> selectAllOptionMenu(String storeNo) {
        return optionMenuDao.selectAllOptionMenu(storeNo);
    }

    @Override
    @Transactional
    public void insertOptionMenu(OptionMenuForm form) throws IOException {
    	String storeNo = storeDao.getStoreNo((String) SessionUtils.getAttribute("OWNER_NO"));
    	String ownerNo = (String)SessionUtils.getAttribute("OWNER_NO");

//		form.setNo(optionMenuDao.nextNoVal());
		form.setStoreNo(storeNo);

		OOptionMenu optionMenu = new OOptionMenu();
		BeanUtils.copyProperties(form, optionMenu);
		optionMenu.setOptionThumbnail(form.getOptionThumbnail().getOriginalFilename());

		if(!new File(uploadDir + "/" + ownerNo + "/" + storeNo + "/optionMenu").isDirectory()) {
			new File(uploadDir + "/" + ownerNo + "/" + storeNo + "/optionMenu").mkdir();
		}

		FileCopyUtils.copy(form.getOptionThumbnail().getBytes(), new File(new File(uploadDir + "/" + ownerNo + "/" + storeNo + "/optionMenu"), form.getOptionThumbnail().getOriginalFilename()));

		optionMenuDao.insertOptionMenu(optionMenu);
    }

    @Override
    public int nextNoVal() {
        return optionMenuDao.nextNoVal();
    }

	@Override
	public void insertOptionMenu(OOptionMenu optionMenu) {
		// TODO Auto-generated method stub
		
	}

}
