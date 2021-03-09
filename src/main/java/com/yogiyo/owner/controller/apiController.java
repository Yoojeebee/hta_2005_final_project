package com.yogiyo.owner.controller;

import com.yogiyo.owner.dao.OwnerDao;
import com.yogiyo.owner.dao.OStoreDao;
import com.yogiyo.owner.dao.OptionMenuGroupDao;
import com.yogiyo.owner.vo.Owner;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("api/json")
public class apiController {

	@Autowired
	OwnerDao ownerDao;

	@Autowired
	OStoreDao storeDao;
	
	@Autowired
	OptionMenuGroupDao optionMenuGroupDao;

	@PostMapping("/getOwnerId")
	public String getOwnerId(@RequestParam("id") String id) {
		return ownerDao.getOwnerNo(id);
	}

	@PostMapping("/getOwnerEmail")
	public String getOwnerEmail(@RequestParam("email") String email) {
		return ownerDao.getOwnerNo(email);
	}
	
	@PostMapping("/getOwnerLogin")
	public Owner getOwnerLogin(@RequestParam String id, @RequestParam String password) {
		return ownerDao.getOnwerData(id, DigestUtils.sha256Hex(password));
	}

	/**
	 * 가게 이름 중복 여부 체크
	 * @param storeName 중복 여부를 체크할 가게 이름
	 * @return 가게 이름이 있으면 가게 이름 반환, 가게 이름이 없으면 null 반환
	 */
	@PostMapping("/getStoreStatus")
	public String getStoreStatus(@RequestParam("storeName") String storeName) {
		return storeDao.getStoreStatus(storeName);
	}
	
	@GetMapping("/getOptionMenuGroupNoByStoreNo")
	public int[] getOptionMenuGroupNoByStoreNo(@RequestParam("storeNo") String storeNo) {
		return optionMenuGroupDao.selectOptionMenuGroupNo(storeNo);
	}

}
