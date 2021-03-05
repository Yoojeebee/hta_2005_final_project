package com.yogiyo.owner.dao;

import com.yogiyo.owner.vo.OOptionMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface OOptionMenuDao {
	
	/**
	 * 옵션 메뉴에 메뉴 번호를 부여해서 메뉴에 들어가는 옵션 메뉴 그룹을 부여
	 * @param list
	 */
	void updateOptionMenu(Map<String, Object> map);

    /**
     * 가게 번호를 기준으로 가게에 등록된 사이드 메뉴를 정보를 전부 가져온다
     * @param storeNo
     * @return
     */
    List<OOptionMenu> selectAllOptionMenu(String storeNo);

    /**
     *가게에 사이드 메뉴를 등록한다
     * @param optionMenu
     */
    void insertOptionMenu(OOptionMenu form);

    /**
     * OptionMenu 테이블의 다음 번호를 가져온다
     * @return
     */
    int nextNoVal();

}
