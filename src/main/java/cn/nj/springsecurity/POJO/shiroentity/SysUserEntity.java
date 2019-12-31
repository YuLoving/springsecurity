package cn.nj.springsecurity.POJO.shiroentity;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * Package: cn.nj.springsecurity.POJO.shiroentity
 *
 * @Author: zhaotianyu
 * @Date: 2019/12/26
 */
@Data
public class SysUserEntity implements Serializable {
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 盐值
     */
    private String salt;
    /**
     * 状态:NORMAL正常  PROHIBIT禁用
     */
    private String state;



}
