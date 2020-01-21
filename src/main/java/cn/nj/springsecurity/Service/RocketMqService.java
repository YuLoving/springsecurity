package cn.nj.springsecurity.Service;

import org.apache.rocketmq.client.producer.SendResult;

/**
 * /**
 * Package: cn.nj.springsecurity.Service
 *
 * @Author: zhaotianyu
 * @Date: 2020/1/21
 */
public interface RocketMqService {
    SendResult openAccountMsg (String msgInfo) ;
}
