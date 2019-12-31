package cn.nj.springsecurity.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 *
 * Package: cn.nj.springsecurity.common
 *  Spring上下文工具类
 * @Author: zhaotianyu
 * @Date: 2019/12/26
 */
@Component
public class SpringUtil implements ApplicationContextAware {

    private static ApplicationContext context;
    /**
     * Spring在bean初始化后会判断是不是ApplicationContextAware的子类
     * 如果该类是,setApplicationContext()方法,会将容器中ApplicationContext作为参数传入进去
     * @Author Sans
     * @CreateTime 2019/6/17 16:58
     */
    @Override
    public void setApplicationContext(org.springframework.context.ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
    /**
     * 通过Name返回指定的Bean
     * @Author Sans
     * @CreateTime 2019/6/17 16:03
     */
    public static <T> T getBean(Class<T> beanClass) {
        return context.getBean(beanClass);
    }
}
