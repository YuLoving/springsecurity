package cn.nj.springsecurity.config.shiroConfig;

import cn.nj.springsecurity.POJO.shiroentity.SysMenuEntity;
import cn.nj.springsecurity.POJO.shiroentity.SysRoleEntity;
import cn.nj.springsecurity.POJO.shiroentity.SysUserEntity;
import cn.nj.springsecurity.Service.shiro.SysMenuService;
import cn.nj.springsecurity.Service.shiro.SysRoleService;
import cn.nj.springsecurity.Service.shiro.SysUserService;
import cn.nj.springsecurity.common.ShiroUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * Package: cn.nj.springsecurity.config.shiroConfig
 *  Shiro核心类   Shiro权限匹配和账号密码匹配
 * @Author: zhaotianyu
 * @Date: 2019/12/26
 */
public class ShiroRealm  extends AuthorizingRealm {

    @Autowired
    private SysUserService userService;

    @Autowired
    private SysRoleService roleService;

    @Autowired
    private SysMenuService menuService;

    /**
     * 授权权限
     * 用户进行权限验证时候Shiro会去缓存中找,如果查不到数据,会执行这个方法去查权限,并放入缓存中
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        SysUserEntity  userEntity = (SysUserEntity) principals.getPrimaryPrincipal();
        //获取用户ID
        Long userId = userEntity.getUserId();
        //这里可以进行授权和处理
        Set<String> rolesSet = new HashSet<>();
        Set<String> permsSet  = new HashSet<>();
        //查询角色和权限(这里根据业务自行查询)
        List<SysRoleEntity> entityList = roleService.selectSysRoleByUserId(userId);
        for (SysRoleEntity SysRoleEntity:entityList) {
            //遍历该用户的所有角色集合，把所有的角色名添加到rolesSet中
            rolesSet.add(SysRoleEntity.getRoleName());
            List<SysMenuEntity> sysMenuEntities = menuService.selectSysMenuByRoleId(SysRoleEntity.getRoleId());
            //遍历该角色对应的所有权限，再把权限全部添加到permsSet中
            for (SysMenuEntity sysMenuEntity:sysMenuEntities){
                permsSet.add(sysMenuEntity.getPerms());
            }
        }
       //将查到的权限和角色分别传入authorizationInfo中
        authorizationInfo.setStringPermissions(permsSet);
        authorizationInfo.setRoles(rolesSet);
        return authorizationInfo;
    }

    /**
     * 身份认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取用户输入的帐号
        String username = (String) token.getPrincipal();
        //通过username从数据库中查找 User对象，如果找到进行验证
        //实际项目中,这里可以根据实际情况做缓存,如果不做,Shiro自己也是有时间间隔机制,2分钟内不会重复执行该方法
        SysUserEntity user = userService.selectUserByName(username);
        //判断账号是否存在
        if (user == null) {
            throw new AuthenticationException();
        }
        //判断账号是否被冻结
        if(user.getState()==null ||user.getState().equals("PROHIBIT") ){
            throw  new LockedAccountException();
        }
        //进行验证
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user,             //用户
                user.getPassword(),   //密码  
                ByteSource.Util.bytes(user.getSalt()),   //设置盐值
                getName()
        );
        //验证成功开始踢人(清除缓存和Session)
        ShiroUtils.deleteCache(username,true);
        return authenticationInfo;
    }
}
