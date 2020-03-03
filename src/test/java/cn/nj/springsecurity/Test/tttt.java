package cn.nj.springsecurity.Test;
import cn.nj.springsecurity.POJO.MyUser;

import java.net.URLDecoder;
import java.util.Date;

/**
 *
 * Package: cn.nj.springsecurity.Test
 *
 * @Author: zhaotianyu
 * @Date: 2019/12/27
 */
public class tttt {

    public static void main(String[] args) {
        String  a="%E4%BB%8A%E5%A4%A9%E5%A4%A9%E6%B0%94%E7%9C%9F%E5%A5%BD";
        String decode = URLDecoder.decode(a);
        System.out.println(decode);


        //测试插件 GenerateAllSetter
        MyUser user = new MyUser();
        user.setId(0L);
        user.setName("");
        user.setPhone("");
        user.setEmail("");
        user.setPassword("");
        user.setCityId(0);
        user.setCreateTime(new Date());
        user.setSex(0);



    }
}
