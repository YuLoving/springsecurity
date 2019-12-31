package cn.nj.springsecurity.Service.shiro;

import cn.nj.springsecurity.POJO.shiroentity.SysUserEntity;

import java.util.List;

/**
 *
 * Package: cn.nj.springsecurity.Service.shiro
 *    系统用户业务接口
 * @Author: zhaotianyu
 * @Date: 2019/12/26
 */
public interface  SysUserService {
    /**
     * 根据用户名查询实体
     * @Author Sans
     * @CreateTime 2019/6/14 16:30
     * @Param  username 用户名
     * @Return SysUserEntity 用户实体
     */
    SysUserEntity selectUserByName(String username);

    /**
     * 根据用户ID获取用户记录
     */
    SysUserEntity getUserByid(long userId);

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
     * 用户信息集合
     */
    List<SysUserEntity> list();
}
