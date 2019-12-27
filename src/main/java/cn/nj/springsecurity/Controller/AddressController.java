package cn.nj.springsecurity.Controller;

import cn.nj.springsecurity.Mappper.AddressMapper;
import cn.nj.springsecurity.POJO.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * /**
 * Copyright 2008-2018 OPPO Mobile Comm Corp., Ltd, All rights reserved.*
 * Package: cn.nj.springsecurity.Controller
 *
 * @Author: zhaotianyu
 * @Date: 2019/11/26
 */

@RestController
public class AddressController {

    @Autowired
    private AddressMapper  addressMapper;

    @GetMapping("/address/save")
    public String save() {
        for (int i = 0; i <10 ; i++) {
            Address address=new Address();
            address.setCode("code_"+i);
            address.setName("name_"+i);
            address.setPid(i+"");
            address.setType(0);
            address.setLit(i%2==0?1:2);
            addressMapper.save(address);
        }

        return "success";
    }

    @RequestMapping("/address/get/{id}")
    @ResponseBody
    public Address get(@PathVariable Long id) {
        return addressMapper.get(id);
    }






}
