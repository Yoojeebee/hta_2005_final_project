package com.yogiyo.owner.serviceimpl;

import com.yogiyo.owner.dao.OwnerDao;
import com.yogiyo.owner.form.OwnerForm;
import com.yogiyo.owner.service.OwnerService;
import com.yogiyo.owner.vo.Owner;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class OwnerServiceImpl implements OwnerService {

	@Autowired
    private OwnerDao ownerDao;

    @Override
    @Transactional
    public void insertNewOwner(OwnerForm ownerForm) {
        Owner owner = new Owner();

        BeanUtils.copyProperties(ownerForm, owner);
		owner.setNo(DigestUtils.sha256Hex(String.valueOf(ownerDao.nextNoVal())));
		owner.setPassword(DigestUtils.sha256Hex(ownerForm.getPassword()));
		owner.setStatus("Y");
		ownerDao.insertNewOwner(owner);
    }

//    @Override
//    public void insertNewOwner(Owner owner) {
//        ownerDao.insertNewOwner(owner);
//    }
//
//    @Override
//    public int nextNoVal() {
//        return ownerDao.nextNoVal();
//    }
//
//    @Override
//    public List<Owner> getAllOwner() {
//        return ownerDao.getAllOwner();
//    }
//
//    @Override
//    public String getOwnerNo(String col) {
//        return ownerDao.getOwnerNo(col);
//    }
//
//	@Override
//	public Owner getOnwerData(String id, String password) {
//		return ownerDao.getOnwerData(id, password);
//	}

}
