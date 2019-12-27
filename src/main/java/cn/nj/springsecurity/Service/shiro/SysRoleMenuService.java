package cn.nj.springsecurity.Service.shiro;

import cn.nj.springsecurity.POJO.shiroentity.SysRoleMenuEntity;

/**
 * /**
 * Copyright 2008-2018 OPPO Mobile Comm Corp., Ltd, All rights reserved.*
 * Package: cn.nj.springsecurity.Service.shiro
 *  角色与权限业务接口
 * @Author: zhaotianyu
 * @Date: 2019/12/26
 */
public interface SysRoleMenuService {
    /**
     *  添加 角色与对应的权限
     */
    boolean save(SysRoleMenuEntity sysRoleMenuEntity);
}
