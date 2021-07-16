package com.xxx.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxx.web.domain.Activity;
import com.xxx.web.domain.Au;
import com.xxx.web.domain.Bill;
import com.xxx.web.domain.User;
import com.xxx.web.service.ActivityService;
import com.xxx.web.service.AuService;
import com.xxx.web.service.BillService;
import com.xxx.web.mapper.BillMapper;
import com.xxx.web.service.UserService;
import com.xxx.web.vo.BillVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 */
@Service
public class BillServiceImpl extends ServiceImpl<BillMapper, Bill> implements BillService{

    @Autowired
    ActivityService activityService;

    @Autowired
    UserService userService;

    @Autowired
    AuService auService;

    @Override
    @Transactional
    public BillVO buildBill(Integer activeId) {
        //根据aid找到的对应的活动
        QueryWrapper<Activity> activityQueryWrapper = new QueryWrapper<>();
        activityQueryWrapper.eq("id",activeId);
        Activity activity = activityService.getOne(activityQueryWrapper);
        // 根据au找到对应所有参加的用户
        QueryWrapper<Au> auQueryWrapper = new QueryWrapper<>();
        auQueryWrapper.eq("aid",activeId);
        List<Integer> uids = auService.list(auQueryWrapper).stream().map(Au::getUid).collect(Collectors.toList());
        //根据au的list 找到所有的用户
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.in("id",uids);
        List<User> users = userService.list(userQueryWrapper);

        //根据aid和uid，找到对应额外补充的会费
        QueryWrapper<Bill> billQueryWrapper = new QueryWrapper<>();
        billQueryWrapper.eq("aid",activeId);
        billQueryWrapper.in("uid",uids);
        List<Bill> bills = super.list(billQueryWrapper);

        BillVO billVO = new BillVO();
        BeanUtils.copyProperties(activity,billVO);

        Map<String,Object> map;
        List<Map<String,Object>> list = new ArrayList();
        List<String> moneys;
        for (User user : users) {
            map = new HashMap<>();
            moneys = new ArrayList<>();
            for (Bill bill : bills) {
                if(user.getId().equals(bill.getUid())){
                    if(!map.containsKey("name")){
                        map.put("name",user.getName());
                    }
                    String money = bill.getMoney().toString();
                    moneys.add(money);

                }
            }
            map.put("money",moneys);
            list.add(map);
        }
        billVO.setBills(list);

        return billVO;
    }
}




