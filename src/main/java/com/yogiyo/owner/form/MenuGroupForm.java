package com.yogiyo.owner.form;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MenuGroupForm {

    private String groupName;
    private String groupDescription;
    private int[] menuNo;

}
