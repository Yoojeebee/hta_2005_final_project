package com.yogiyo.owner.service;

import com.yogiyo.owner.form.StoreForm;
import com.yogiyo.owner.vo.OStore;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public interface OStoreService {

    List<OStore> getAllStore(String address);

    OStore getStore(String storeNo);

    String getStoreName(String storeNo);

    String getStoreNo(String ownerNo);

    int nextNoVal();

    /**
     * 가게 추가
     * @param store
     * @throws IOException 
     */
    boolean insertStore(StoreForm form) throws IOException;

    String getStoreStatus(String storeName);

}
