package com.ruoyi;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.system.domain.SysUserEntity;
import com.ruoyi.system.mapper.SysUserMapper;
import com.ruoyi.system.service.ISysUserService;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@SpringBootTest
@RunWith(SpringRunner.class)
public class Test01 extends BaseController {
    @Autowired
    private SysUserMapper userMapper;

    @Autowired
    private ISysUserService userService;


    @Test
    public void test01() {
        //条件构造      就相当于是where email = "ry@163.com"
        QueryWrapper<SysUserEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("email","ry@163.com");
        List<SysUserEntity> list = userMapper.selectList(wrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void test02() {
        userMapper.deleteById(1L);
    }

    @Test
    public void test03() {
        SysUserEntity user = new SysUserEntity();
        user.setNickName("赵龙");
        user.setUserName("zl");
        user.setEmail("1976915593@qq.com");
        int i = userMapper.insert(user);
        System.out.println(i);
    }

    @Test
    public void test04() {
        List<SysUserEntity> userList1 = userMapper.selectList(null);
        for (SysUserEntity sysUserEntity : userList1) {
            System.out.println(sysUserEntity);
        }
        System.out.println("==================================");
        PageHelper.startPage(2,2);
        List<SysUserEntity> userList = userMapper.selectList(null);
        for (SysUserEntity user : userList) {
            System.out.println(user);
        }
        /**
         * 导入依赖
         * 调用静态方法 PageHelper.startPage，页码从1开始算
         * 调用MP中的方法查询之后显示出来的结果就是分完页之后的结果
         */

        /**
         * 创建一个PageInfo对象，将刚刚查询出来的分页结果进行封装
         * 这个对象也是PageHelper自带的         */
        PageInfo<SysUserEntity> info = new PageInfo<>(userList);
        System.out.println(info.getPageSize());
        System.out.println(info.getPages());
        for (SysUserEntity user : info.getList()) {
            System.out.println(user);
        }
    }

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test05() {
        SysUserEntity user = new SysUserEntity();
        user.setUserName("zhaolong");
        user.setPassword("123123");
        redisTemplate.opsForValue().set("user",user);
    }
    @Test
    public void test05_1() {
        Object user = redisTemplate.opsForValue().get("user");
        System.out.println(user);
    }

}
