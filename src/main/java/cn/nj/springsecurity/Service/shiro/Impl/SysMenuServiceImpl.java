package cn.nj.springsecurity.Service.shiro.Impl;

import cn.nj.springsecurity.Mappper.ShiroDao.SysMenuDao;
import cn.nj.springsecurity.POJO.shiroentity.SysMenuEntity;
import cn.nj.springsecurity.Service.shiro.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * /**
 * Copyright 2008-2018 OPPO Mobile Comm Corp., Ltd, All rights reserved.*
 * Package: cn.nj.springsecurity.Service.shiro.Impl
 *  权限业务实现
 * @Author: zhaotianyu
 * @Date: 2019/12/26
 */
@Service
public class SysMenuServiceImpl implements SysMenuService {
    @Autowired
    private SysMenuDao menuDao;

    @Override
    public List<SysMenuEntity> selectSysMenuByRoleId(Long roleId) {
        return menuDao.selectSysMenuByRoleId(roleId);
    }

    @Override
    public List<SysMenuEntity> list() {
        return menuDao.list();
    }
}
