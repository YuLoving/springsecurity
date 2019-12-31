package cn.nj.springsecurity.Mappper.ShiroDao;

import cn.nj.springsecurity.POJO.shiroentity.SysMenuEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *
 * Package: cn.nj.springsecurity.Mappper.ShiroDao
 *
 * @Author: zhaotianyu
 * @Date: 2019/12/26
 */
@Mapper
public interface SysMenuDao {

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
