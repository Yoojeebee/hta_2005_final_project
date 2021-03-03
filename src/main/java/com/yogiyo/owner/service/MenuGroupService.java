package com.yogiyo.owner.service;

import com.yogiyo.owner.form.MenuGroupForm;
import org.springframework.stereotype.Service;

@Service
public interface MenuGroupService {

    void insertMenuGroup(MenuGroupForm menuGroupForm);

}
