package com.yogiyo.owner.service;

import com.yogiyo.owner.dto.StoreMenuGroupDto;
import com.yogiyo.owner.dto.StoreOptionMenuGroupDto;
import com.yogiyo.owner.form.OptionMenuForm;
import com.yogiyo.owner.vo.OOptionMenu;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public interface OptionMenuService {
	
	/**
	 * 옵션 메뉴 테이블 모두 출력
	 * @param storeNo
	 * @return
	 */
	List<StoreOptionMenuGroupDto> distinctSelectOptionGroup(String storeNo);
	
	Map<String, Object> selectAllGroup(String storeNo);

    List<OOptionMenu> selectAllOptionMenu(String storeNo);

    void insertOptionMenu(OOptionMenu optionMenu);

    int nextNoVal();

	void insertOptionMenu(OptionMenuForm form) throws IOException;

}
