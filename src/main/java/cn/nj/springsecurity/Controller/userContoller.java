package cn.nj.springsecurity.Controller;

import cn.nj.springsecurity.POJO.user;
import cn.nj.springsecurity.Service.IuserService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * Package: cn.nj.springsecurity.Controller
 *
 * @Author: zhaotianyu
 * @Date: 2019/11/15
 */
@RestController
public class userContoller {
    @Autowired
    private IuserService service;

    @GetMapping("/get")
    public String getall(){
        List<user> users = service.getall();
        System.out.println(users.toString());
        if(!CollectionUtils.isEmpty(users)){
            return JSON.toJSONString(users);
        }
        return "no";
    }
}
