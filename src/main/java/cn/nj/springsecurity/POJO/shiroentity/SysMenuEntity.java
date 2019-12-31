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
public class SysMenuEntity implements Serializable {
    /**
     * 权限ID
     */
    private Long menuId;
    /**
     * 权限名称
     */
    private String name;
    /**
     * 权限标识
     */
    private String perms;



}
