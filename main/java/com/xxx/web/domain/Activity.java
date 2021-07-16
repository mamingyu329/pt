package com.xxx.web.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.With;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 活动表
 * @TableName activity
 */
@TableName(value ="activity")
@Data
public class Activity implements Serializable {
    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
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

    /**
     * 已到账收费
     */
    private Integer realMoney;


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}