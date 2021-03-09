package com.yogiyo.owner.controller;

import com.yogiyo.owner.dao.MenuDao;
import com.yogiyo.owner.dao.MenuDetailGroupDao;
import com.yogiyo.owner.dao.OOptionMenuDao;
import com.yogiyo.owner.dao.OStoreDao;
import com.yogiyo.owner.dto.DetailMenu;
import com.yogiyo.owner.dto.StoreMenuGroupDto;
import com.yogiyo.owner.dto.StoreOptionMenuGroupDto;
import com.yogiyo.owner.form.MenuForm;
import com.yogiyo.owner.form.MenuGroupForm;
import com.yogiyo.owner.form.OptionGroupForm;
import com.yogiyo.owner.form.OptionMenuForm;
import com.yogiyo.owner.form.StoreForm;
import com.yogiyo.owner.serviceimpl.MenuGroupServiceImpl;
import com.yogiyo.owner.serviceimpl.MenuServiceImpl;
import com.yogiyo.owner.serviceimpl.OStoreServiceImpl;
import com.yogiyo.owner.serviceimpl.OptionMenuGroupServiceImpl;
import com.yogiyo.owner.serviceimpl.OptionMenuServiceImpl;
import com.yogiyo.owner.utils.SessionUtils;
import com.yogiyo.owner.vo.Menu;
import com.yogiyo.owner.vo.MenuDetail;
import com.yogiyo.owner.vo.MenuDetailGroup;
import com.yogiyo.owner.vo.OOptionMenu;
import com.yogiyo.owner.vo.OStore;
import com.yogiyo.pay.vo.OptionMenu;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Controller
@RequestMapping("/store")
public class StoreController {

	@Value("${upload.img.path}")
	private String uploadDir;

	@Autowired
	OStoreDao storeDao;
	
	@Autowired
	OStoreServiceImpl storeService;

	@Autowired
	MenuDao menuDao;

	@Autowired
	MenuDetailGroupDao menuDetailGroupDao;

	@Autowired
	OptionMenuServiceImpl optionMenuService;
	
	@Autowired
	OOptionMenuDao optionMenuDao;

	@Autowired
	MenuServiceImpl menuService;

	@Autowired
	MenuGroupServiceImpl menuGroupService;
	
	@Autowired
	OptionMenuGroupServiceImpl optionMenuGroupService;

	/**
	 * 가게 생성, 메뉴 관리, 정산 관리 등 오너 관리자 페이지
	 * @param model
	 * @return
	 */
	@RequestMapping("/home")
	public String home(Model model) {
		model.addAttribute("no", storeDao.getStoreNo((String)SessionUtils.getAttribute("OWNER_NO")));
		return "store/home";
	}

	/**
	 * 오너가 가게가 없을 경우 가게를 생성하는 페이지
	 * @return
	 */
	@RequestMapping("/manage/joinStore")
	public String open() {
		return "store/manage/joinStore";
	}

	/**
	 * 가게를 생성하는 페이지에서 넘겨 온 데이터를 검사<br/>
	 * 성공 -> 오너 관리자 페이지
	 * @param form
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@PostMapping("/manage/form")
	public String form(StoreForm form, Model model) throws IOException {
		boolean isOk = storeService.insertStore(form);
		if(isOk == true) { 
			return "redirect:/store/home";
		}
		else {
			model.addAttribute("error", "에러!");
			return "redirect:/manage/joinStore";
		}
	}

	/**
	 * 오너의 가게 메뉴 관리 페이지<br/>
	 * 오너가 등록한 모든 메뉴를 관리 및 수정 삭제 등의 작업을 할 수 있다
	 * @param storeNo
	 * @param model
	 * @return
	 */
	@GetMapping("/manage/menu/menu")
	public String menu(@RequestParam("storeNo") String storeNo, Model model) {
		if( storeNo == null ) {
			model.addAttribute("error", "error");
			return "redirect:/store/home";
		} else {
			model.addAttribute("name", storeDao.getStoreName(storeNo));
			model.addAttribute("ownerNo", (String)SessionUtils.getAttribute("OWNER_NO"));
			model.addAttribute("storeNo", storeNo);

			Map<String, Object> map = menuService.selectAll(storeNo);
			if(!map.isEmpty()) {
				List<Menu> menu = (List<Menu>) map.get("menu");
				List<DetailMenu> detailGroup = (List<DetailMenu>)map.get("menuGroup");
				List<OOptionMenu> optionMenu = (List<OOptionMenu>)map.get("optionMenu");
				
				model.addAttribute("menu", menu);
				model.addAttribute("detailGroup", detailGroup);
				model.addAttribute("optionMenu", optionMenu);
				
				model.addAttribute("distictMenuGroup", menuGroupService.distinctSelectMenuGroup(storeNo));
				model.addAttribute("distictOptionGroup", optionMenuService.distinctSelectOptionGroup(storeNo));
			}

			return "store/manage/menu/menu";
		}
	}

	@GetMapping("/manage/menugroup/group")
	public String group(@RequestParam("storeNo") String storeNo, Model model) {
		if( storeNo == null ) {
			model.addAttribute("error", "error");
			return "redirect:/store/home";
		} else {
			model.addAttribute("name", storeDao.getStoreName(storeNo));
			model.addAttribute("ownerNo", (String)SessionUtils.getAttribute("OWNER_NO"));
			model.addAttribute("storeNo", storeNo);

			Map<String, Object> map2 = menuService.selectAll(storeNo);
			List<Menu> menu = (List<Menu>)map2.get("menu");
			List<OOptionMenu> optionMenu = (List<OOptionMenu>)map2.get("optionMenu");
			model.addAttribute("menu", menu);
			model.addAttribute("optionMenu", optionMenu);
			
			model.addAttribute("distictMenuGroup", menuGroupService.distinctSelectMenuGroup(storeNo));
			model.addAttribute("distictOptionGroup", optionMenuService.distinctSelectOptionGroup(storeNo));

			return "store/manage/menugroup/group";
		}
	}

	/**
	 * 오너가 자신의 가게에 등록할 메뉴를 검사
	 * @param form
	 * @return
	 * @throws IOException
	 */
	@PostMapping("/manage/menu/menuForm")
	public String menuForm(MenuForm form, Model model) throws IOException {
		String storeNo = storeDao.getStoreNo((String) SessionUtils.getAttribute("OWNER_NO"));
		System.out.println(form.toString());
		boolean isOk = menuService.insertMenu(form);
		return "redirect:/store/manage/menu/menu?storeNo=" + storeNo;
	}

	/**
	 * 오너가 자신의 가게에 등록할 옵션 메뉴(== 사이드 메뉴)를 검사
	 * @param form
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/manage/menu/optionForm", method = RequestMethod.POST)
	public String optionForm(OptionMenuForm form) throws IOException {
		String storeNo = storeDao.getStoreNo((String) SessionUtils.getAttribute("OWNER_NO"));

		optionMenuService.insertOptionMenu(form);

		return "redirect:/store/manage/menu/menu?storeNo=" + storeNo;
	}

	/**
	 * 가게에 등록된 여러가지 메뉴를 하나의 그룹으로 묶는 것
	 * @param form
	 * @return
	 */
	@RequestMapping(value = "/manage/menugroup/menuGroup", method = RequestMethod.POST)
	public String menuGroup(MenuGroupForm form) {
		String storeNo = storeDao.getStoreNo((String) SessionUtils.getAttribute("OWNER_NO"));

		menuGroupService.insertMenuGroup(form);

		return "redirect:/store/manage/menugroup/group?storeNo=" + storeNo;
	}
	
	/**
	 * 가게에 등록된 여러가지 옵션 메뉴를 하나의 그룹으로 묶는 것
	 * @param form
	 * @return
	 */
	@RequestMapping(value = "/manage/menugroup/optionMenuGroup", method = RequestMethod.POST)
	public String optionGroup(OptionGroupForm form) {
		String storeNo = storeDao.getStoreNo((String) SessionUtils.getAttribute("OWNER_NO"));

		System.out.println(form.toString());
		optionMenuGroupService.insertOptionMenuGroup(form);

		return "redirect:/store/manage/menugroup/group?storeNo=" + storeNo;
	}
	
	@RequestMapping("/detail")
	public String detail(Model model) {
		String storeNo = "4e07408562bedb8b60ce05c1decfe3ad16b72230967de01f640b7e4729b49fce";
		model.addAttribute("name", storeDao.getStoreName(storeNo));
		model.addAttribute("ownerNo", (String)SessionUtils.getAttribute("OWNER_NO"));
		model.addAttribute("storeNo", storeNo);

		Map<String, Object> map = menuService.selectAll(storeNo);
		if(!map.isEmpty()) {
			List<Menu> menu = (List<Menu>) map.get("menu");
			List<DetailMenu> menuGroup = (List<DetailMenu>)map.get("menuGroup");
			List<OOptionMenu> optionMenu = (List<OOptionMenu>)map.get("optionMenu");
			
			model.addAttribute("menu", menu);
			model.addAttribute("group", menuGroup);
			model.addAttribute("optionMenu", optionMenu);
		}
		return "store/detail";
	}

}
