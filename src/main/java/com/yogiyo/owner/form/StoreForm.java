package com.yogiyo.owner.form;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@ToString
public class StoreForm {

    private String name;
    private MultipartFile thumbnail;
    private String openTime;
    private String closeTime;
    private String place;
    private String card;
    private int minPrice;
    private String tel;
    private String address;

}
