package cn.nj.springsecurity.Service.Impl;

import cn.nj.springsecurity.MQ.ParamConfigService;
import cn.nj.springsecurity.Service.RocketMqService;
import com.alibaba.fastjson.JSON;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * /**
 * Package: cn.nj.springsecurity.Service.Impl
 *
 * @Author: zhaotianyu
 * @Date: 2020/1/21
 */
@Service
public class RocketMqServiceImpl implements RocketMqService {

    private static final Logger logger= LoggerFactory.getLogger(RocketMqServiceImpl.class);

    @Autowired
    private DefaultMQProducer producer;

    @Autowired
    private ParamConfigService paramConfigService;


    @Override
    public SendResult openAccountMsg(String msgInfo) {
        // 可以不使用Config中的Group
        producer.setProducerGroup(paramConfigService.rocketGroup);
        SendResult sendResult=null;
        try {
            Message message = new Message(paramConfigService.rocketTopic, paramConfigService.rocketTag, "open_account_key", msgInfo.getBytes());
            logger.info("====message中的内容===="+ JSON.toJSONString(message));
            sendResult = producer.send(message);
        }catch (Exception e){
            logger.error("发送消息报错:"+e.getMessage());
        }

        return sendResult;
    }
}
