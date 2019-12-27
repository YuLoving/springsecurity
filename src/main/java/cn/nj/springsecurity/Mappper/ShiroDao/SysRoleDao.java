package cn.nj.springsecurity.Mappper.ShiroDao;

import cn.nj.springsecurity.POJO.shiroentity.SysRoleEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * /**
 * Copyright 2008-2018 OPPO Mobile Comm Corp., Ltd, All rights reserved.*
 * Package: cn.nj.springsecurity.Mappper.ShiroDao
 *
 * @Author: zhaotianyu
 * @Date: 2019/12/26
 */
@Mapper
public interface SysRoleDao {

    /**
     * 通过用户ID查询角色集合
     * @Author Sans
     * @CreateTime 2019/6/18 18:01
     * @Param  userId 用户ID
     * @Return List<SysRoleEntity> 角色名集合
     */
    List<SysRoleEntity> selectSysRoleByUserId(Long userId);

    /**
     * 角色集合
     */
    List<SysRoleEntity>  list();
}
