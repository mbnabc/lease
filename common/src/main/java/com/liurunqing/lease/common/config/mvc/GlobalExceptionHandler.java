package com.liurunqing.lease.common.config.mvc;

import com.liurunqing.lease.common.exception.LeaseException;
import com.liurunqing.lease.common.result.Result;
import com.liurunqing.lease.common.result.ResultCodeEnum;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(LeaseException.class)
    public Result leaseException(LeaseException e) {
        e.printStackTrace();
        return Result.build(null, e.getResultCodeEnum());
    }
    @ExceptionHandler(Exception.class)
    public Result otherException(Exception e) {
        e.printStackTrace();
        return Result.build(null, ResultCodeEnum.FAIL);
    }
}
