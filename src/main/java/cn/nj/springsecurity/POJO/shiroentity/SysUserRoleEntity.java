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
public class SysUserRoleEntity  implements Serializable {

    private Long id;
    private Long userId;
    private Long roleId;


}
