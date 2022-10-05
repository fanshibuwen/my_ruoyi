package com.ruoyi.web.controller;

import com.ruoyi.common.core.constant.HttpStatus;
import com.ruoyi.common.core.domain.AjaxResult;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Author zhaoL
 * @Time 2022/9/18 21:25
 */

/**
 * 在springboot中，处理全局异常有两种，一种是继承BasicErrorController，另一种是加@ControllerAdvice注解
 * 两种的区别是处理的异常种类不同，@ControllerAdvice搭配@ExceptionHandler处理，处理控制类抛出的异常，而继承了BasicErrorController的类处理非业务类异常，例如404
 * 其实BasicErrorController也是一个控制器，专门处理/error的接口，当访问/error的时候，会被重定向到/error，然后执行里面的errorHtml方法（处理html网页）或者error方法（处理json字符串）
 */

@RestController
public class ErrorController extends BasicErrorController {


    public ErrorController() {
        super(new DefaultErrorAttributes(),new ErrorProperties());
    }

    @Override
    @RequestMapping(produces = {"text/html"})
    public ModelAndView errorHtml(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("/404");
    }

    @Override
    @RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
        AjaxResult error = AjaxResult.error(HttpStatus.NOT_FOUND, "资源未找到");
        return new ResponseEntity<>(error, org.springframework.http.HttpStatus.NOT_FOUND);
    }

    @Override
    protected ErrorProperties getErrorProperties() {
        return super.getErrorProperties();
    }
}
