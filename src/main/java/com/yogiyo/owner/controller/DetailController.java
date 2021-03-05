package com.yogiyo.owner.controller;

import com.yogiyo.owner.dao.MenuDao;
import com.yogiyo.owner.dao.MenuDetailGroupDao;
import com.yogiyo.owner.dao.OOptionMenuDao;
import com.yogiyo.owner.dao.OStoreDao;
import com.yogiyo.owner.dto.DetailMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DetailController {

    @Autowired
    OStoreDao storeDao;

    @Autowired
    MenuDao menuDao;

    @Autowired
    OOptionMenuDao optionMenuDao;

    @Autowired
    MenuDetailGroupDao menuDetailGroupDao;

    @RequestMapping("/detail")
    public String detail(@RequestParam("storeNo") String storeNo, Model model) {

        model.addAttribute("store", storeDao.getStore(storeNo));

        model.addAttribute("menu", menuDao.selectAll(storeNo));

        int[] menuNo = menuDao.selectMenuNo(storeNo);
        List<DetailMenu> group = new ArrayList<>();
        if(menuNo[0] != 0) {
            for (int num : menuNo) {
            	DetailMenu[] list = menuDetailGroupDao.selectAllMenuGroup(num);
            	for(DetailMenu detail  : list) {
            		group.add(detail);
            	}
            }
            model.addAttribute("group", group);
        }

        model.addAttribute("option", optionMenuDao.selectAllOptionMenu(storeNo));

        return "detail";
    }

}
