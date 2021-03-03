package com.yogiyo.owner.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@ToString
public class OOptionMenu {

    private int no;
    private String optionName;
    private String optionThumbnail;
    private int optionPrice;
    private String storeNo;

}
