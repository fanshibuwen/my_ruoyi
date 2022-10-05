package com.ruoyi.framework.web.exception;

import com.ruoyi.common.core.constant.HttpStatus;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.exception.base.BaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author zhaoL
 * @Time 2022/9/18 20:11
 * 处理全局的异常，就是说当Controller中抛出了异常的时候，将会被拦截到这个类中处理
 * 但是如果是404，那么根本就不会走Controller中的接口，出现了之后就不会出现在这个类中处理
 * 即 GlobalExceptionHandler类 不能处理404异常
 */
@RestControllerAdvice
public class GlobalExceptionHandler extends RuntimeException{

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 处理业务异常，比如 连接异常 空指针异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public AjaxResult runtimeException(Exception e) {
        return AjaxResult.error(HttpStatus.ERROR,e.getMessage());
    }

    /**
     * 基础异常
     * @param e
     * @return
     */
    @ExceptionHandler(BaseException.class) //这里面的参数只能是某一异常类的实例化对象  意思是专门来处理某种异常类
    public AjaxResult baseException(BaseException e) {
        return AjaxResult.error(e.getMessage());
    }
}
