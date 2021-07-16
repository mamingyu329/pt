package com.xxx.web.controller;

import com.xxx.web.domain.Activity;
import com.xxx.web.service.ActivityService;
import com.xxx.web.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RequestMapping("activity")
@RestController
public class ActivityController {

    final
    ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }


    /**
     * 根据uid得到当前用户参加过的所有活动,如果uid为null，则默认为当前用户
     *
     * @return
     */
    @GetMapping("listJoinActive")
    public Result listJoinActive(){
        return Result.ok(activityService.listJoinActive());
    }

    @GetMapping("list")
    public Result list(){
        return Result.ok(activityService.list());
    }

    /**
     * 创建一个活动，
     * @return
     */
    @PostMapping("addActive")
    public Result addActive(@RequestBody Activity activity){
        activityService.addActive(activity);
        return Result.ok("创建成功");
    }

    @PostMapping("closeActive/{id}/{even}")
    public Result closeActive(@PathVariable Integer id , @PathVariable String even){
        activityService.closeActive(id,even);
        return Result.ok();
    }


    @PostMapping("quitActive/{id}/{even}")
    public Result quitActive(@PathVariable Integer id , @PathVariable String even){
        activityService.quitActive(id,even);
        return Result.ok();
    }

    /**
     * 报名一个活动，用户可以找到对应的活动并参加
     */
    @PostMapping("attendActive")
    public Result attendActive(@RequestBody Activity activity){
        activityService.attendActive(activity);
        return Result.ok("参与成功");
    }

    @PostMapping("payActive")
    public Result payActive(@RequestBody Activity activity){
        activityService.attendActive(activity);
        return Result.ok("支付成功");
    }
}
