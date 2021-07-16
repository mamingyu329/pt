package com.xxx.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxx.web.domain.Activity;
import com.xxx.web.domain.Au;
import com.xxx.web.domain.Bill;
import com.xxx.web.domain.User;
import com.xxx.web.exception.MyException;
import com.xxx.web.mapper.AuMapper;
import com.xxx.web.mapper.BillMapper;
import com.xxx.web.service.ActivityService;
import com.xxx.web.mapper.ActivityMapper;
import com.xxx.web.utils.ActiveEnum;
import com.xxx.web.utils.RequestHolder;
import com.xxx.web.utils.UserEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 */
@Service
public class ActivityServiceImpl extends ServiceImpl<ActivityMapper, Activity> implements ActivityService{

    @Autowired
    ActivityMapper activityMapper;

    @Autowired
    AuMapper auMapper;

    @Autowired
    BillMapper billMapper;

    @Override
    public List<Map<String,String>> listJoinActive() {
        User user = RequestHolder.getCurrentSysUser();
        List<Map<String,String>> activities =  activityMapper.listJoinActive(user.getId());
        activities.forEach(System.out::println);
        return activities;
    }

    @Override
    @Transactional
    public void addActive(Activity activity) {
        // 创建活动
        User currentSysUser = RequestHolder.getCurrentSysUser();
        activity.setCreateUser(currentSysUser.getName());
        activity.setRealPerson(1);
        activity.setStatus(ActiveEnum.WAIT_REPORT.getDesc());
        Date date = new Date();
        activity.setCreateDate(date);
        activityMapper.insert(activity);
        // 创建 au 中间关系
        Au au = new Au();
        au.setUid(currentSysUser.getId());
        au.setAid(activity.getId());
        au.setStatus(UserEnum.ATTEND.getDesc());
        auMapper.insert(au);
        //创建订单
        Bill bill = new Bill();
        bill.setAid(activity.getId());
        bill.setUid(currentSysUser.getId());
        billMapper.insert(bill);
    }

    @Override
    public void attendActive(Activity activity) {
        User currentUser = RequestHolder.getCurrentSysUser();
        Au au = new Au();
        au.setStatus(UserEnum.ATTEND.getDesc());
        au.setAid(activity.getId());
        au.setUid(currentUser.getId());
        auMapper.insert(au);
    }

    @Override
    public void closeActive(Integer id ,String even) {
        // 通过id找到对应活动
        QueryWrapper<Activity> activityQueryWrapper = new QueryWrapper<>();
        activityQueryWrapper.eq("id",id);
        Activity one = super.getOne(activityQueryWrapper);

        // 根据oper来设置状态
        if("close_report".equals(even)){
            if(one.getStatus().equals(ActiveEnum.ENDED.getDesc())){
                throw new MyException("活动已结束， 不允许更新状态");
            }
            one.setStatus(ActiveEnum.STARTED.getDesc());
        }else if("close_active".equals(even)){
            one.setStatus(ActiveEnum.ENDED.getDesc());
        }
        UpdateWrapper<Activity> activityUpdateWrapper = new UpdateWrapper<>();
        activityUpdateWrapper.eq("id",one.getId());
        super.update(one,activityUpdateWrapper);
    }

    @Override
    @Transactional
    public void quitActive(Integer id, String even) {
        // 根据oper来设置状态,0代表关闭报名活动开始， 1代表关闭活动 活动结束
        User user = RequestHolder.getCurrentSysUser();
        if("attend_active".equals(even)){
            Au au = new Au();
            au.setAid(id);
            au.setUid(user.getId());
            au.setStatus(UserEnum.ATTEND.getDesc());
            auMapper.insert(au);
        }else if("quit_active".equals(even)){
            QueryWrapper<Au> auQueryWrapper = new QueryWrapper<>();
            auQueryWrapper.eq("aid",id).eq("uid",user.getId());
            Au au = auMapper.selectOne(auQueryWrapper);
            au.setStatus(UserEnum.UNATTEND.getDesc());
            auMapper.updateById(au);
        }

    }


}




