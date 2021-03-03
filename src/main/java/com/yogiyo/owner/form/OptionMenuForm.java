package com.yogiyo.owner.form;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@ToString
public class OptionMenuForm {

    private int no;
    private String optionName;
    private MultipartFile optionThumbnail;
    private int optionPrice;
    private String storeNo;

}
