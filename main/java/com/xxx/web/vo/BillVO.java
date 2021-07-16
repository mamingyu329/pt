package com.xxx.web.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Map;



@Data
public class BillVO {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 活动名字
     */
    private String name;

    /**
     * 活动地点
     */
    private String position;

    /**
     * 活动内容
     */
    private String content;

    /**
     * 活动开始时间
     */
    private Date startTime;

    /**
     * 金额
     */
    private Integer money;

    /**
     * 预期人数
     */
    private Integer expectPerson;

    /**
     * 实际参与人数
     */
    private Integer realPerson;

    /**
     * 活动类型
     */
    private String activeType;

    /**
     * 创建者
     */
    private String createUser;

    /**
     * 账单id
     */
    private Integer bid;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 活动状态：
     未开始
     待报名
     已开始
     已结束
     */
    private String status;


    private List<Map<String,Object>> bills;


}
