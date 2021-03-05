package com.yogiyo.search.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yogiyo.search.service.UserService;
import com.yogiyo.search.vo.User;

@RestController
public class AjaxUserController {
	
	@Autowired
	UserService userService;
	
	// yogiyo/checkUserId.do 요청에 대한 요청핸들러 메소드
	// 아이디를 전달받아서 사용가능한 아이디인지 아닌지를 응답으로 보낸다.
	@RequestMapping("/checkUserId.do")
	public Map<String, Boolean> checkUserId(@RequestParam("userId") String userId) {
		Map<String, Boolean> result = new HashMap<>();
		
		User user = userService.getUserById(userId);
		if(user == null) {
			result.put("exist", false);
		} else {
			result.put("exist", true);
		}
		return result;
	}
}

/* 요청핸들러 메소드                                          
		ajax요청에 대한 처리를 수행한 메소드                                    
		반환타입은 데이터를 담고 있는 객체, List, Map인 경우가 대부분이다.                        
		객체나 맵인 경우는 {name:value, name:value, name:value}로 변환되어서 전달됨 -------> JSON Object 표기법으로 작성된 텍스트로 변환됨   
		List인 경우는 [value, value, value]로 변환되어서 전달된다.            -------> JSON Array 표기법으로 작성된 텍스트로 변환됨   
		List인 경우 대부분은 [{name1:value1, name2:value2}, {name1:value1, name2:value2}, {name1:value1, name2:value2}]의 형태다.   
		이 요청핸들러 메소드는 최종적으로 {"exist":true} 혹은 {"exist":false}가 jQuery Ajax의 콜백함수의 매개변수로 전달된다.
 */