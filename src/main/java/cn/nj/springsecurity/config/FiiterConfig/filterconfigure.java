package cn.nj.springsecurity.config.FiiterConfig;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

/**
 * /**
 * Copyright 2008-2018 OPPO Mobile Comm Corp., Ltd, All rights reserved.*
 * Package: cn.nj.springsecurity.config.FiiterConfig
 *
 * @Author: zhaotianyu
 * @Date: 2019/11/18
 */
@Configuration
public class filterconfigure {

    //过滤的地址
    static final  String  PATH="/filter/*";


    @Bean
    public FilterRegistrationBean filterRegistration(){
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();
        bean.setFilter(this.openMyfilter());
        bean.addUrlPatterns(PATH);
        bean.setName("myfirstFilter");
        //优先级，越低越优先   1是顶级
        bean.setOrder(1);
        return bean;
    }

    @Bean
    public Filter openMyfilter(){
        return new Myfilter();
    }


}
