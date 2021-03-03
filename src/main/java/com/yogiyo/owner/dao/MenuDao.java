package com.yogiyo.owner.dao;

import com.yogiyo.owner.vo.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuDao {

    /**
     * Menu 테이블의 다음 번호를 출력한다
     * @return
     */
    int nextNoVal();

    /**
     * Menu 테이블의 현재 번호를 출력한다
     * @return
     */
    int currentNoVal();

    /**
     * 가게 번호를 기준으로(오너의 가게) 가게에 등록된 모든 메뉴를 가져온다
     * @param storeNo
     * @return
     */
    List<Menu> selectAll(String storeNo);

    /**
     * 가게 번호를 기준으로(오너의 가게) 가게에 등록된 메뉴 번호를 가져온다
     * @param storeNo
     * @return
     */
    int[] selectMenuNo(String storeNo);

    /**
     * 가게에 메뉴를 등록시킨다
     * @param menu
     */
    void insertMenu(Menu menu);

}
