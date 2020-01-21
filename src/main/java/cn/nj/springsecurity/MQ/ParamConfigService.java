package cn.nj.springsecurity.MQ;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * /**
 * Package: cn.nj.springsecurity.MQ
 *配置参数绑定
 * @Author: zhaotianyu
 * @Date: 2020/1/21
 */
@Service
public class ParamConfigService {

    @Value("${rocket.group}")
    public String rocketGroup ;
    @Value("${rocket.topic}")
    public String rocketTopic ;
    @Value("${rocket.tag}")
    public String rocketTag ;

}
