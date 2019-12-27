package cn.nj.springsecurity.Mappper;

import cn.nj.springsecurity.POJO.MyUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * /**
 * Copyright 2008-2018 OPPO Mobile Comm Corp., Ltd, All rights reserved.*
 * Package: cn.nj.springsecurity.Mappper
 *
 * @Author: zhaotianyu
 * @Date: 2019/11/26
 */
@Mapper
public interface MyUserMapper {

    /**
     * 保存
     */
    void save(MyUser user);

    /**
     * 查询
     * @param id
     * @return
     */
    MyUser get(Long id);
}
