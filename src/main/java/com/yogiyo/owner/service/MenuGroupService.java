package com.yogiyo.owner.service;

import com.yogiyo.owner.dto.StoreMenuGroupDto;
import com.yogiyo.owner.form.MenuGroupForm;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface MenuGroupService {
	
	List<StoreMenuGroupDto> distinctSelectMenuGroup(String storeNo);

    void insertMenuGroup(MenuGroupForm menuGroupForm);

}
