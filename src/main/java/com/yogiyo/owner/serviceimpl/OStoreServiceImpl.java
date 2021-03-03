package com.yogiyo.owner.serviceimpl;

import com.yogiyo.owner.dao.OStoreDao;
import com.yogiyo.owner.form.StoreForm;
import com.yogiyo.owner.service.OStoreService;
import com.yogiyo.owner.utils.SessionUtils;
import com.yogiyo.owner.vo.OStore;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Repository
public class OStoreServiceImpl implements OStoreService {

	/**
	 * 가게 관련 이미지 저장 장소
	 */
	@Value("${upload.img.path}")
	private String uploadDir;

	@Autowired
	OStoreDao storeDao;

	@Override
	@Transactional
	public boolean insertStore(StoreForm form) throws IOException {
		String ownerNo = (String)SessionUtils.getAttribute("OWNER_NO");
		if (form.getName() != null) {
			OStore store = new OStore();
			store.setOwnerNo(ownerNo);
			store.setThumbnail(form.getThumbnail().getOriginalFilename());
			store.setNo(DigestUtils.sha256Hex(String.valueOf(storeDao.nextNoVal())));
			BeanUtils.copyProperties(form, store);

			storeDao.insertStore(store);
			
			if (!new File(uploadDir + "/" + ownerNo).isDirectory()) {
				boolean isOk = new File(uploadDir + "/" + ownerNo).mkdir();
				System.out.println("만들어졌나?" + isOk);
			}

			// 가게 이미지 저장 장소 생성
			if (!new File(uploadDir + "/" + ownerNo).isDirectory()) {
				new File(uploadDir + "/" + ownerNo).mkdir();
			}

			// 가게 메뉴 이미지 저장 장소 생성
			if (!new File(uploadDir + "/" + ownerNo + "/menu").isDirectory()) {
				new File(uploadDir + "/" + ownerNo + "/menu").mkdir();
			}

			// 가게 옵션 메뉴 이미지 저장 장소 생성
			if (!new File(uploadDir + "/" + ownerNo + "/optionMenu").isDirectory()) {
				new File(uploadDir + "/" + ownerNo + "/optionMenu").mkdir();
			}

			FileCopyUtils.copy(form.getThumbnail().getBytes(), new File(uploadDir + "/" + ownerNo, form.getThumbnail().getOriginalFilename()));

			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<OStore> getAllStore(String address) {
		return storeDao.getAllStore(address);
	}

	@Override
	public OStore getStore(String storeNo) {
		return storeDao.getStore(storeNo);
	}

	@Override
	public String getStoreName(String storeNo) {
		return storeDao.getStoreName(storeNo);
	}

	@Override
	public String getStoreNo(String ownerNo) {
		return storeDao.getStoreNo(ownerNo);
	}

	@Override
	public int nextNoVal() {
		return storeDao.nextNoVal();
	}

	@Override
	public String getStoreStatus(String storeName) {
		return storeDao.getStoreStatus(storeName);
	}

}
