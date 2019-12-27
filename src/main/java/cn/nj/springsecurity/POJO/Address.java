package cn.nj.springsecurity.POJO;

import lombok.Data;

/**
 * /**
 * Copyright 2008-2018 OPPO Mobile Comm Corp., Ltd, All rights reserved.*
 * Package: cn.nj.springsecurity.POJO
 *
 * @Author: zhaotianyu
 * @Date: 2019/11/26
 */
@Data
public class Address {


    private Long id;
    /**
     * 编码
     */
    private String code;
    /**
     * 名称
     */
    private String name;
    /**
     * 父id
     */
    private String pid;
    /**
     * 1国家2省3市4县区
     */
    private Integer type;
    private Integer lit;
}
