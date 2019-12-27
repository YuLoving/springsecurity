package cn.nj.springsecurity.Service.shiro.Impl;

import cn.nj.springsecurity.Mappper.ShiroDao.SysRoleDao;
import cn.nj.springsecurity.POJO.shiroentity.SysRoleEntity;
import cn.nj.springsecurity.Service.shiro.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * /**
 * Copyright 2008-2018 OPPO Mobile Comm Corp., Ltd, All rights reserved.*
 * Package: cn.nj.springsecurity.Service.shiro.Impl
 *  角色业务实现
 * @Author: zhaotianyu
 * @Date: 2019/12/26
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    private SysRoleDao sysRoleDao;

    @Override
    public List<SysRoleEntity> selectSysRoleByUserId(Long userId) {
        return sysRoleDao.selectSysRoleByUserId(userId);
    }

    @Override
    public List<SysRoleEntity> list() {
        return sysRoleDao.list();
    }
}
