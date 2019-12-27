package cn.nj.springsecurity.Service.Impl;

import cn.nj.springsecurity.Mappper.UserMapper;
import cn.nj.springsecurity.POJO.user;
import cn.nj.springsecurity.Service.IuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * /**
 * Copyright 2008-2018 OPPO Mobile Comm Corp., Ltd, All rights reserved.*
 * Package: cn.nj.springsecurity.Service.Impl
 *
 * @Author: zhaotianyu
 * @Date: 2019/11/15
 */
@Service
public class UserServiceImpl implements IuserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<user> getall() {
        return userMapper.getall();
    }
}
