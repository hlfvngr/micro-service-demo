package com.hlfv.democommon.exception;

import com.hlfv.democommon.vo.CommonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class   ExceptionGlobalHandler {

    @ExceptionHandler(value = DemoException.class)
    public CommonResult<Boolean> handleDemoException(DemoException e) {
        return CommonResult.fail(40700, e.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public CommonResult<Boolean> handleException(Exception e) {
        return CommonResult.fail(50000, e.getMessage());
    }
}
