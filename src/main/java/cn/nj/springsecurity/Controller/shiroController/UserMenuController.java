package cn.nj.springsecurity.Controller.shiroController;

import cn.nj.springsecurity.POJO.shiroentity.SysMenuEntity;
import cn.nj.springsecurity.POJO.shiroentity.SysRoleEntity;
import cn.nj.springsecurity.POJO.shiroentity.SysRoleMenuEntity;
import cn.nj.springsecurity.POJO.shiroentity.SysUserEntity;
import cn.nj.springsecurity.Service.shiro.SysMenuService;
import cn.nj.springsecurity.Service.shiro.SysRoleMenuService;
import cn.nj.springsecurity.Service.shiro.SysRoleService;
import cn.nj.springsecurity.Service.shiro.SysUserService;
import cn.nj.springsecurity.common.ShiroUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * /**
 * Copyright 2008-2018 OPPO Mobile Comm Corp., Ltd, All rights reserved.*
 * Package: cn.nj.springsecurity.Controller.shiroController
 *  权限测试
 * @Author: zhaotianyu
 * @Date: 2019/12/26
 */
@RestController
@RequestMapping("/menu")
public class UserMenuController {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysMenuService sysMenuService;
    @Autowired
    private SysRoleMenuService sysRoleMenuService;


    /**
     * 获取用户信息集合
     * @Return Map<String,Object> 返回结果
     */
    @GetMapping("/getUserInfoList")
    @RequiresPermissions("sys:user:info")
    public Map<String,Object> getUserInfoList(){
        Map<String,Object> map = new HashMap<>();
        List<SysUserEntity> list = sysUserService.list();
        map.put("sysUserEntityList",list);
        return map;
    }

    /**
     * 获取角色信息集合
     * @Return Map<String,Object> 返回结果
     */
    @GetMapping("/getRoleInfoList")
    @RequiresPermissions("sys:role:info")
    public Map<String,Object> getRoleInfoList(){
        Map<String,Object> map = new HashMap<>();
        List<SysRoleEntity> list = sysRoleService.list();
        map.put("sysRoleEntityList",list);
        return map;
    }

    /**
     * 获取权限信息集合
     * @Return Map<String,Object> 返回结果
     */
    @GetMapping("/getMenuInfoList")
    @RequiresPermissions("sys:menu:info")
    public Map<String,Object> getMenuInfoList(){
        Map<String,Object> map = new HashMap<>();
        List<SysMenuEntity> list = sysMenuService.list();
        map.put("sysMenuEntityList",list);
        return map;
    }

    /**
     * 获取所有数据
     * @Return Map<String,Object> 返回结果
     */
    @RequestMapping("/getInfoAll")
    @RequiresPermissions("sys:info:all")
    public Map<String,Object> getInfoAll(){
        Map<String,Object> map = new HashMap<>();
        List<SysUserEntity> sysUserEntityList = sysUserService.list();
        map.put("sysUserEntityList",sysUserEntityList);
        List<SysRoleEntity> sysRoleEntityList = sysRoleService.list();
        map.put("sysRoleEntityList",sysRoleEntityList);
        List<SysMenuEntity> sysMenuEntityList = sysMenuService.list();
        map.put("sysMenuEntityList",sysMenuEntityList);
        return map;
    }

    /**
     * 添加管理员角色权限(测试动态权限更新)
     * @Param  username 用户ID
     * @Return Map<String,Object> 返回结果
     */
    @GetMapping("/addMenu")
    public Map<String,Object> addMenu(){
        //添加  管理员角色权限
        SysRoleMenuEntity sysRoleMenuEntity = new SysRoleMenuEntity();
        sysRoleMenuEntity.setMenuId(4L);
        sysRoleMenuEntity.setRoleId(1L);
        sysRoleMenuService.save(sysRoleMenuEntity);
        //清除缓存
        String name ="admin";
        ShiroUtils.deleteCache(name,false);
        Map<String,Object> map = new HashMap<>();
        map.put("code",200);
        map.put("msg","权限添加成功");
        return map;
    }


}
