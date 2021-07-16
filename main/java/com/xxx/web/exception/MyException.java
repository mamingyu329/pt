package com.xxx.web.exception;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 自定义的异常类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyException extends RuntimeException{
    private Integer code;

    private String message;

    public MyException(String message){
        this.message = message;
        this.code = 500;
    }

    @Override
    public String toString() {
        return "GuliException{" +
                "message=" + this.getMessage() +
                ", code=" + code +
                '}';
    }
}
