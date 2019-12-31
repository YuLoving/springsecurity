package cn.nj.springsecurity.Controller.shiroController;

import cn.nj.springsecurity.Service.shiro.SysMenuService;
import cn.nj.springsecurity.Service.shiro.SysRoleMenuService;
import cn.nj.springsecurity.Service.shiro.SysRoleService;
import cn.nj.springsecurity.Service.shiro.SysUserService;
import cn.nj.springsecurity.common.ShiroUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Package: cn.nj.springsecurity.Controller.shiroController
 *  角色测试
 * @Author: zhaotianyu
 * @Date: 2019/12/26
 */

@RestController
@RequestMapping("/role")
public class UserRoleController {

    @Autowired
    private SysUserService userService;
    @Autowired
    private SysRoleService roleService;
    @Autowired
    private SysMenuService menuService;
    @Autowired
    private SysRoleMenuService sysRoleMenuService;

    /**
     * 管理员角色测试接口
     * @Return Map<String,Object> 返回结果
     */
    @GetMapping("/getAdminInfo")
    @RequiresRoles("ADMIN")
    public Map<String ,Object> getAdminInfo(){
        Map<String,Object> map = new HashMap<>();
        map.put("code",200);
        map.put("msg","这里是只有管理员角色能访问的接口");
        return map;
    }

    /**
     * 用户角色测试接口
     * @Return Map<String,Object> 返回结果
     */
    @GetMapping("/getUserInfo")
    @RequiresRoles("USER")
    public Map<String ,Object>  getUserInfo(){
        Map<String,Object> map = new HashMap<>();
        map.put("code",200);
        map.put("msg","这里是只有用户角色能访问的接口");
        return map;
    }

    /**
     * 角色测试接口
     * @Return Map<String,Object> 返回结果
     */
    @GetMapping("/getRoleInfo")
    @RequiresRoles(value = {"ADMIN","USER"},logical = Logical.OR)
    @RequiresUser
    public Map<String,Object> getRoleInfo(){
        Map<String,Object> map = new HashMap<>();
        map.put("code",200);
        map.put("msg","这里是只要有ADMIN或者USER角色能访问的接口");
        return map;
    }


    /**
     * 登出(测试登出)
     * @Return Map<String,Object> 返回结果
     */
    @GetMapping("/getLogout")
    @RequiresUser
    public Map<String,Object> getLogout(){
        ShiroUtils.logout();
        Map<String,Object> map = new HashMap<>();
        map.put("code",200);
        map.put("msg","登出");
        return map;
    }

}
