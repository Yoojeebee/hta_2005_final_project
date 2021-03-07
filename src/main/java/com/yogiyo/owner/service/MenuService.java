package com.yogiyo.owner.service;

import org.springframework.stereotype.Service;

import com.yogiyo.owner.dto.StoreMenuGroupDto;
import com.yogiyo.owner.form.MenuForm;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public interface MenuService {
	
	boolean insertMenu(MenuForm form) throws IOException;

    Map<String, Object> selectAllGroup(String storeNo);

    Map<String, Object> selectAll(String storeNo);

}
