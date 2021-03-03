package com.yogiyo.owner.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Menu {

    private int no;
    private String name;
    private String thumbnail;
    private String detail;
    private int price;
    private int groupNo;
    private String storeNo;

}
