package com.yogiyo.owner.form;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@ToString
public class MenuForm {

    // 메뉴
    private String name;
    private MultipartFile thumbnail;
    private String detail;
    private int price;

    // 옵션
    private String groupName;
    private String []optName;
    private String []optPrice;
    
    // 옵션 메뉴
    private int[] optionGroupNo;

}
