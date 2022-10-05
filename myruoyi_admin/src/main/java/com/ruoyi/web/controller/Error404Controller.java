package com.ruoyi.web.controller;

import com.ruoyi.common.core.constant.HttpStatus;
import com.ruoyi.common.core.domain.AjaxResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zhaoL
 * @Time 2022/9/18 21:48
 */
@RestController
public class Error404Controller {
    @GetMapping("/404")
    public AjaxResult error404() {
        return AjaxResult.error(HttpStatus.NOT_FOUND,"资源未找到");
    }
}
