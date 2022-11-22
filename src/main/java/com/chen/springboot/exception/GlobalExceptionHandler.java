package com.chen.springboot.exception;

import com.chen.springboot.utils.R;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 如果抛出的的是ServiceException，则调用该方法
     * @param se 业务异常
     * @return R
     */
    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public R handle(ServiceException se){
        return R.error(se.getCode(), se.getMessage());
    }
}
