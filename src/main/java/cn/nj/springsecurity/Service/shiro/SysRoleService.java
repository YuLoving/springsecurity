package cn.nj.springsecurity.Service.shiro;

import cn.nj.springsecurity.POJO.shiroentity.SysRoleEntity;

import java.util.List;

/**
 *
 * Package: cn.nj.springsecurity.Service.shiro
 *  角色业务接口
 * @Author: zhaotianyu
 * @Date: 2019/12/26
 */
public interface SysRoleService {

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
