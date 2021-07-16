package com.xxx.web.utils;

import lombok.Data;

import java.util.Map;

/**
 * 统一返回结果类
 */
@Data
public class Result {
    private Boolean success;

    private Integer code;

    private String message;

    private Object data ;

    //把构造方法私有化
    private Result() {};

    //成功静态方法
    public static Result ok(){
        Result r = new Result();
        r.setSuccess(true);
        r.setMessage("成功");
        r.setCode(ResultCode.SUCCESS);
        return r;
    }
    public static Result ok(Object data){
        Result r = new Result();
        r.setSuccess(true);
        r.setMessage("成功");
        r.setData(data);
        r.setCode(ResultCode.SUCCESS);
        return r;
    }
    public static Result ok(String message){
        Result r = new Result();
        r.setSuccess(true);
        r.setCode(ResultCode.SUCCESS);
        r.setMessage(message);
        return r;
    }
    public static Result ok(String message,Object data ){
        Result r = new Result();
        r.setSuccess(true);
        r.setCode(ResultCode.SUCCESS);
        r.setMessage(message);
        r.setData(data);
        return r;
    }


    //失败静态方法
    public static Result error(){
        Result r = new Result();
        r.setSuccess(false);
        r.setCode(ResultCode.ERROR);
        r.setMessage("失败");
        return r;
    }
    public static Result error(String message){
        Result r = new Result();
        r.setSuccess(false);
        r.setCode(ResultCode.ERROR);
        r.setMessage(message);
        return r;
    }

    /*以下方法返回this是为了能够实现链式编程，如Result.success().message()...*/
    public Result success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    public Result message(String message){
        this.setMessage(message);
        return this;
    }

    public Result code(Integer code){
        this.setCode(code);
        return this;
    }

    public Result data(Object obj){
        this.data = obj;
        return this;
    }

    public Result data(Map<String, Object> map){
        this.setData(map);
        return this;
    }
}
