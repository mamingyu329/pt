package com.xxx.web.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 活动用户关系表
 * @TableName au
 */
@TableName(value ="au")
@Data
public class Au implements Serializable {
    /**
     * 活动id
     */
    private Integer aid;

    /**
     * 用户id
     */
    private Integer uid;

    /**
     * 用户对活动的状态
参加中
未参加

     */
    private String status;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}