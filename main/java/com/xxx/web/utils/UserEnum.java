package com.xxx.web.utils;

import lombok.Getter;

@Getter
public enum UserEnum {

   ATTEND(20,"已参加"),
   UNATTEND(11,"未参加");

    private Integer id ;
    private String desc ;

    UserEnum(Integer id, String desc) {
        this.id = id;
        this.desc = desc;
    }

}
