package cn.nj.springsecurity.Service.shiro.Impl;

import cn.nj.springsecurity.Mappper.ShiroDao.SysRoleMenuDao;
import cn.nj.springsecurity.POJO.shiroentity.SysRoleMenuEntity;
import cn.nj.springsecurity.Service.shiro.SysRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * Package: cn.nj.springsecurity.Service.shiro.Impl
 *  角色与权限业务实现
 * @Author: zhaotianyu
 * @Date: 2019/12/26
 */
@Service
public class SysRoleMenuServiceImpl  implements SysRoleMenuService {
    @Autowired
    private SysRoleMenuDao roleMenuDao;

    @Override
    public boolean save(SysRoleMenuEntity sysRoleMenuEntity) {
        System.err.println("roleid:"+sysRoleMenuEntity.getRoleId()+",menuid:"+sysRoleMenuEntity.getMenuId());
        return roleMenuDao.save(sysRoleMenuEntity);
    }
}
