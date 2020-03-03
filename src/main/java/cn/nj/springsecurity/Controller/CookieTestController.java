package cn.nj.springsecurity.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * /**
 * Package: cn.nj.springsecurity.Controller
 *
 * @Author: zhaotianyu
 * @Date: 2020/3/2
 */
@RestController
@RequestMapping("/cookie")
public class CookieTestController {

    private static  final Logger logger= LoggerFactory.getLogger(CookieTestController.class);

    /**
     * 设置cookie返回给客户端
     */

    @GetMapping("/change-username")
    public String setCookie(HttpServletResponse response){
        //创建一个cookie
        Cookie cookie = new Cookie("username","jovan");
        //设置cookie过期时间  expires in 7 days
        cookie.setMaxAge(7*24*60*60);
        //添加到response中
        response.addCookie(cookie);
        return "username is changed!";
    }

    /**
     * 使用Spring框架提供的@CookieValue注解获取特定的 cookie的值
     */

    @GetMapping
    public String readCookie(@CookieValue(value = "username" ,defaultValue = "atta") String username ){
        return  "my name  is "+username;
    }


    /**
     * 读取所有的 Cookie 值
     */
    @GetMapping("/all-cookies")
    public String allCookie(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        String collect="";
        if(cookies!=null){
           collect = Arrays.stream(cookies).map(c -> c.getName() + "=" + c.getValue()).collect(Collectors.joining(","));
        }
        logger.info("collect={}",collect);
        return collect;
    }





}
