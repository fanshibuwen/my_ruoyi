package com.ruoyi.web.controller.system;


import com.ruoyi.system.domain.SysUserEntity;
import com.ruoyi.system.service.ISysUserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author zhaol
 * @since 2022-09-09
 */
@RestController
@RequestMapping("/sys-user-entity")
public class SysUserController {

    @Autowired
    private ISysUserService userService;

    @RequestMapping("/find")
    public SysUserEntity findById(@Param("userId") Long userId){
        SysUserEntity user = userService.findById(userId);
        return user;
    }


}
