package cn.nj.springsecurity.Mappper.ShiroDao;

import cn.nj.springsecurity.POJO.shiroentity.SysUserEntity;
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
public interface SysUserDao {
    /**
     * 根据用户ID获取用户记录
     */
        SysUserEntity getUserByid(long userId);

    /**
     * 根据用户名获取用户记录
     */
    SysUserEntity getUserByname(String username);
    /**
     * 修改用户信息
     */
     boolean  update(SysUserEntity userEntity);
    /**
     * 根据用户ID删除
     */
    boolean  del(long userId);

    /**
     * 新增用户信息
     */
    boolean add(SysUserEntity userEntity);

    /**
     * 获取用户集合
     */
    List<SysUserEntity> list();


}
