package com.ruoyi.system.service;

import com.ruoyi.system.domain.SysUserEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author zhaol
 * @since 2022-09-09
 */
public interface ISysUserService extends IService<SysUserEntity> {
    SysUserEntity findById(Long userId);
}
