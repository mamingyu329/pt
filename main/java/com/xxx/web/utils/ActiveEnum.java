package com.xxx.web.utils;

import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
public enum ActiveEnum {

   UNSTART(10,"未开始"),
   STARTED(11,"已开始"),
   WAIT_REPORT(12,"待报名"),
   ENDED(13,"已结束");

    private Integer id ;
    private String desc ;

    ActiveEnum(Integer id, String desc) {
        this.id = id;
        this.desc = desc;
    }

}
