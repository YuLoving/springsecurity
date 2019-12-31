package cn.nj.springsecurity.Service.shiro;

import cn.nj.springsecurity.POJO.shiroentity.SysMenuEntity;

import java.util.List;

/**
 *
 * Package: cn.nj.springsecurity.Service.shiro
 *   权限业务接口
 * @Author: zhaotianyu
 * @Date: 2019/12/26
 */
public interface SysMenuService {
    /**
     * 根据角色查询用户权限
     * @Author Sans
     * @CreateTime 2019/6/19 10:14
     * @Param  roleId 角色ID
     * @Return List<SysMenuEntity> 权限集合
     */
    List<SysMenuEntity> selectSysMenuByRoleId(Long roleId);

    /**
     * 权限集合
     */
    List<SysMenuEntity> list();
}
