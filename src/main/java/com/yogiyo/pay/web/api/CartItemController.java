package com.yogiyo.pay.web.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yogiyo.pay.dto.CartItemDto;
import com.yogiyo.pay.service.CartItemService;
import com.yogiyo.pay.util.SessionUtils;
import com.yogiyo.pay.web.form.CartForm;

@CrossOrigin("*")
@RestController("apiCartItemController")
@RequestMapping("/api/cart")
public class CartItemController {
	
	@Autowired
	CartItemService cartItemService;
	
	@GetMapping("/items.do")
	public Map<String, Object> items(){
		String userNo = "1"; //(String) SessionUtils.getAttribute("LOGINED_USER_NO");
		return cartItemService.getAllCartItems(userNo);
	}
	
	@PostMapping("/items/insert.do")
	public Map<String, Object> insert(@RequestBody CartForm cartForm) {
		Map<String, Object> result = cartItemService.insertCartItem(cartForm);
		
		return result;
	}
	
	@PostMapping("/items/update.do")
	public CartItemDto update(@RequestBody CartItemDto cartItemDto) {
		 
		 System.out.println("전달된 dto: " + cartItemDto);
		
		 CartItemDto dto = cartItemService.getCartItemByCartItemNo(cartItemDto.getNo());
		 cartItemService.updateCartItem(cartItemDto);
		 
		 return dto;
	}
	
	@DeleteMapping("/items/delete.do/{cartItemNo}")
	public CartItemDto delete(@PathVariable("cartItemNo") int cartItemNo) {
		CartItemDto cartItemDto = cartItemService.getCartItemByCartItemNo(cartItemNo);

		cartItemService.deleteCartItems(cartItemNo);
		
		return cartItemDto;
	}
	
	@DeleteMapping("/items/deleteAll.do")
	public List<CartItemDto> deleteAll() {
		String loginedUserNo = (String) SessionUtils.getAttribute("LOGINED_USER_NO");
		List<CartItemDto> cartItemDtos = cartItemService.getAllCartList();
		
		cartItemService.deleteAllCartItemsByUserNo(loginedUserNo);
		
		return cartItemDtos;
	}
	
}
