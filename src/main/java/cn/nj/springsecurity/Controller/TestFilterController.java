package cn.nj.springsecurity.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * Package: cn.nj.springsecurity.Controller
 *
 * @Author: zhaotianyu
 * @Date: 2019/11/18
 */
@RestController
@RequestMapping("/filter")
public class TestFilterController {


    @GetMapping("/get")
    public String aa(String a,int b,String c){
        StringBuilder builder = new StringBuilder();
        StringBuilder append = builder.append(a).append(":第一轮:").append(b).append(",名字：").append(c);
        return  append.toString();

    }


}
