package com.hnsdksx.app_counterpartapi.exception;


import com.hnsdksx.app_counterpartapi.constant.AssertException;
import com.hnsdksx.app_counterpartapi.response.GlobalConstant;
import com.hnsdksx.app_counterpartapi.response.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 全局异常处理器
 *
 * @author kuangbaoting
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 是否打印断言异常
     */
    @Value("${app-counterpart.global-exception.assert-exception}")
    private Boolean assertException = false;

    /**
     * 处理断言异常
     */
    @ExceptionHandler(AssertException.class)
    @ResponseBody
    public Response<Object> handlerAssertException(AssertException e) {
        if (assertException) {
            System.out.println("AssertException : "+e.getMessage());
        }
        return Response.error(e.getCode(),e.getMessage());
    }

    /**
     * 其他异常
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Response<Object> handlerException(Exception e) {
        e.printStackTrace();
        return Response.error(GlobalConstant.ERROR.getCode(), GlobalConstant.ERROR.getMessage());
    }
}
