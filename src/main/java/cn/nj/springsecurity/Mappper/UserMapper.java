package cn.nj.springsecurity.Mappper;

import cn.nj.springsecurity.POJO.user;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * /**
 * Copyright 2008-2018 OPPO Mobile Comm Corp., Ltd, All rights reserved.*
 * Package: cn.nj.springsecurity.Mappper
 *
 * @Author: zhaotianyu
 * @Date: 2019/11/15
 */
@Mapper
public interface UserMapper {
    List<user> getall();
}
