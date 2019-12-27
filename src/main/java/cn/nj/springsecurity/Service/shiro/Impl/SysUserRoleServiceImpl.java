package cn.nj.springsecurity.Service.shiro.Impl;

import cn.nj.springsecurity.Mappper.ShiroDao.SysUserRoleDao;
import cn.nj.springsecurity.Service.shiro.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * /**
 * Copyright 2008-2018 OPPO Mobile Comm Corp., Ltd, All rights reserved.*
 * Package: cn.nj.springsecurity.Service.shiro.Impl
 *  用户与角色业务实现
 * @Author: zhaotianyu
 * @Date: 2019/12/26
 */
@Service
public class SysUserRoleServiceImpl  implements SysUserRoleService {

    @Autowired
    private SysUserRoleDao userRoleDao;
}
