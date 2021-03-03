package com.yogiyo.owner.service;

import com.yogiyo.owner.form.OwnerForm;

import org.springframework.stereotype.Service;

@Service
public interface OwnerService {

    void insertNewOwner(OwnerForm ownerForm);

}
