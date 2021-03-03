package com.yogiyo.owner.dao;

import com.yogiyo.owner.vo.OStore;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OStoreDao {

    /**
     * 입력된 주소에 따른 배달 지역으로 등록한 가게들을 모두 출력한다
     * @param address
     * @return
     */
    List<OStore> getAllStore(String address);

    /**
     * 가게 번호를 기준으로 가게에 관한 정보를 가져온다
     * @param storeNo
     * @return
     */
    OStore getStore(String storeNo);

    /**
     * 가게 번호가 가리키는 가게 이름을 가져온다
     * @param storeNo
     * @return
     */
    String getStoreName(String storeNo);

    /**
     * 오너의 번호로 오너가 속한 가게 번호를 찾는다
     * @param ownerNo
     * @return
     */
    String getStoreNo(String ownerNo);

    /**
     * Store 테이블에서 다음 번호를 가져온다
     * @return
     */
    int nextNoVal();

    /**
     * 가게에 관한 정보를 저장한다
     * @param store
     */
    void insertStore(OStore store);

    /**
     * 가게 중복 이름 체크
     * @param storeName
     * @return
     */
    String getStoreStatus(String storeName);

}
