package com.xxx.web.exception;
import com.xxx.web.utils.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 * @author xms
 * @since 1.0.0
 */
@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(MyException.class)
	public Result mySqlException(Exception e){
		e.printStackTrace(); //打印异常信息到控制台
		return Result.error(e.getMessage()); //把错误消息返回
	}

}
