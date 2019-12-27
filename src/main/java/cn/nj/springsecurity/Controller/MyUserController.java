package cn.nj.springsecurity.Controller;

import cn.nj.springsecurity.Mappper.MyUserMapper;
import cn.nj.springsecurity.POJO.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * /**
 * Copyright 2008-2018 OPPO Mobile Comm Corp., Ltd, All rights reserved.*
 * Package: cn.nj.springsecurity.Controller
 *
 * @Author: zhaotianyu
 * @Date: 2019/11/26
 */
@RestController
public class MyUserController {

    @Autowired
    private MyUserMapper myUserMapper;

    @GetMapping("/myuser/save")
    public String save(){
        for(int i=0;i<10;i++){
            MyUser user = new MyUser();
            user.setName("test"+i);
            user.setCityId(1%2==0?1:2);
            user.setCreateTime(new Date());
            user.setSex(i%2==0?1:2);
            user.setPhone("11111111"+i);
            user.setEmail("xxxxx");
            user.setPassword("eeeeeeeeeeee");
            myUserMapper.save(user);
        }
        return "success";
    }


    @GetMapping("/myuser/get/{id}")
    public MyUser get(@PathVariable Long id) {
        MyUser user =  myUserMapper.get(id);
        System.out.println(user.getId());
        return user;
    }

}
