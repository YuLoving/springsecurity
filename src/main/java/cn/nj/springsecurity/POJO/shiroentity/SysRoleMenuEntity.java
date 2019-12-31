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
public class SysRoleMenuEntity  implements Serializable {

    private Long id;
    /**
     * 角色ID
     */
    private Long roleId ;

    /**
     * 权限ID
     */
    private Long menuId;


}
