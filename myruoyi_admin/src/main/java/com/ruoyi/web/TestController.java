package com.ruoyi.web;


import com.github.pagehelper.PageInfo;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.system.domain.SysUserEntity;
import com.ruoyi.system.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController extends BaseController {

    @Autowired
    private SysUserMapper userMapper;

    @GetMapping("/test")
    public AjaxResult test() {
        startPage();
        List<SysUserEntity> list = userMapper.selectList(null);
        TableDataInfo info = getDataTable(list);
        return AjaxResult.success(info);
    }

}
