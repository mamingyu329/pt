package com.xxx.web.service;

import com.xxx.web.domain.Activity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 *
 */
public interface ActivityService extends IService<Activity> {

    List<Map<String,String>> listJoinActive();

    void addActive(Activity activity);

    void attendActive(Activity activity);

    void closeActive(Integer id,String even);

    void quitActive(Integer id, String even);
}
