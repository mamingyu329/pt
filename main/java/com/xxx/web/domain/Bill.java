package com.xxx.web.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 账单表
 * @TableName bill
 */
@TableName(value ="bill")
@Data
public class Bill implements Serializable {
    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 活动id
     */
    private Integer aid;

    /**
     * 用户id
     */
    private Integer uid;

    /**
     * 金额
     */
    private Integer money;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}