package cn.nj.springsecurity.POJO.shiroentity;

import com.alibaba.fastjson.JSON;
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
public class SysRoleEntity implements Serializable {
    /**
     * 角色ID
     */
    private Long roleId;
    /**
     * 角色名称
     */
    private String roleName;



}
