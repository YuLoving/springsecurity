package cn.nj.springsecurity.Service.shiro.Impl;

import cn.nj.springsecurity.Mappper.ShiroDao.SysUserDao;
import cn.nj.springsecurity.POJO.shiroentity.SysUserEntity;
import cn.nj.springsecurity.Service.shiro.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * /**
 * Copyright 2008-2018 OPPO Mobile Comm Corp., Ltd, All rights reserved.*
 * Package: cn.nj.springsecurity.Service.shiro.Impl
 *  系统用户业务实现
 * @Author: zhaotianyu
 * @Date: 2019/12/26
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserDao userDao;

    @Override
    public SysUserEntity selectUserByName(String username) {
        return userDao.getUserByname(username);
    }

    @Override
    public SysUserEntity getUserByid(long userId) {
        return userDao.getUserByid(userId);
    }


    @Override
    public boolean update(SysUserEntity userEntity) {
        return userDao.update(userEntity);
    }

    @Override
    public boolean del(long userId) {
        return userDao.del(userId);
    }

    @Override
    public boolean add(SysUserEntity userEntity) {
        return userDao.add(userEntity);
    }

    @Override
    public List<SysUserEntity> list() {
        return userDao.list();
    }
}
