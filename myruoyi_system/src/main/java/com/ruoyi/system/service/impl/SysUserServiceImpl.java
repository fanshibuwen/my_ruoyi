package com.ruoyi.system.service.impl;

import com.ruoyi.system.domain.SysUserEntity;
import com.ruoyi.system.mapper.SysUserMapper;
import com.ruoyi.system.service.ISysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author zhaol
 * @since 2022-09-09
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUserEntity> implements ISysUserService {

    @Autowired
    private SysUserMapper userMapper;

    @Override
    public SysUserEntity findById(Long userId) {
        SysUserEntity user = userMapper.selectById(userId);
        return user;
    }
}
