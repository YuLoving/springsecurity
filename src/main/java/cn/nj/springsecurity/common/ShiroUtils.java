package cn.nj.springsecurity.common;

import cn.nj.springsecurity.POJO.shiroentity.SysUserEntity;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.Authenticator;
import org.apache.shiro.authc.LogoutAware;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.crazycake.shiro.RedisSessionDAO;

import java.util.Collection;
import java.util.Objects;

/**
 * /**
 * Copyright 2008-2018 OPPO Mobile Comm Corp., Ltd, All rights reserved.*
 * Package: cn.nj.springsecurity.common
 *      Shiro工具类
 * @Author: zhaotianyu
 * @Date: 2019/12/26
 */
public class ShiroUtils {

    /** 私有构造器 **/
    private ShiroUtils(){}

    private static RedisSessionDAO redisSessionDAO = SpringUtil.getBean(RedisSessionDAO.class);

    /**
     * 获取当前用户Session
     * @Author Sans
     * @CreateTime 2019/6/17 17:03
     * @Return SysUserEntity 用户信息
     */
    public static Session getSession(){
        return SecurityUtils.getSubject().getSession();
    }


    /**
     * 用户登出
     * @Author Sans
     * @CreateTime 2019/6/17 17:23
     */
    public static void  logout(){
         SecurityUtils.getSubject().logout();
    }

    /**
     * 获取当前用户信息
     * @Author Sans
     * @CreateTime 2019/6/17 17:03
     * @Return SysUserEntity 用户信息
     */
    public static SysUserEntity getUserInfo(){
        return (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
    }

    /**
     * 删除用户缓存信息
     * @Author Sans
     * @CreateTime 2019/6/17 13:57
     * @Param  username  用户名称
     * @Param  isRemoveSession 是否删除Session
     * @Return void
     */
    public static void deleteCache(String username,boolean isRemoveSession){
        //从缓存中获取Session
        Session session=null;
        Collection<Session> sessions = redisSessionDAO.getActiveSessions();
        SysUserEntity userEntity;
        Object attribute=null;
        for (Session sessionInfo:sessions) {
            //遍历Session,找到该用户名称对应的Session
            attribute = sessionInfo.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
            if (attribute == null) {
                continue;
            }
            userEntity = (SysUserEntity) ((SimplePrincipalCollection) attribute).getPrimaryPrincipal();
            if (userEntity == null) {
                continue;
            }
            if (Objects.equals(userEntity.getUsername(),username)){
                session=sessionInfo;
                //找到真正的session，跳出循环
                break;
            }

        }
        if(session==null || attribute ==null){
                return ;
        }
        //删除session
        if(isRemoveSession){
            redisSessionDAO.delete(session);
        }
        //删除Cache，在访问受限接口时会重新授权
         DefaultWebSecurityManager securityManager= (DefaultWebSecurityManager) SecurityUtils.getSecurityManager();
        Authenticator authenticator = securityManager.getAuthenticator();
        ((LogoutAware)authenticator).onLogout((SimplePrincipalCollection)attribute);

    }


}
