package cn.nj.springsecurity.Mappper.ShiroDao;

import cn.nj.springsecurity.POJO.shiroentity.SysRoleMenuEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * /**
 * Copyright 2008-2018 OPPO Mobile Comm Corp., Ltd, All rights reserved.*
 * Package: cn.nj.springsecurity.Mappper.ShiroDao
 *  角色权限关系DAO
 * @Author: zhaotianyu
 * @Date: 2019/12/26
 */
@Mapper
public interface SysRoleMenuDao {

    /**
     *  添加 角色与对应的权限
     */
    boolean save(SysRoleMenuEntity sysRoleMenuEntity);
}
