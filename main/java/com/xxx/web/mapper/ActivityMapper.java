package com.xxx.web.mapper;

import com.xxx.web.domain.Activity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @Entity com.xxx.web.domain.Activity
 */
public interface ActivityMapper extends BaseMapper<Activity> {

    List<Map<String, String>> listJoinActive(Integer uid);
}




