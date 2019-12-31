package cn.nj.springsecurity.POJO;

import lombok.Data;

import java.util.Date;

/**
 *
 * Package: cn.nj.springsecurity.POJO
 *
 * @Author: zhaotianyu
 * @Date: 2019/11/26
 */
@Data
public class MyUser {

    private Long id;
    /**
    名称
     */
    private String name;
    /**
     * 电话
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 密码
     */
    private String password;
    /**
     *   城市
     */

    private Integer cityId;
    /**
     *    创建时间
     */

    private Date createTime;
    /**
     *  性别
     */

    private Integer sex;

}
