package cn.nj.springsecurity.MQ.producer;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * /**
 * Package: cn.nj.springsecurity.MQ.producer
 *  RocketMQ 生产者配置
 * @Author: zhaotianyu
 * @Date: 2020/1/21
 */
@Configuration
public class ProducerConfig {

    private   static  final Logger logger= LoggerFactory.getLogger(ProducerConfig.class);

    @Value("${rocketmq.producer.groupName}")
    private String groupName;
    @Value("${rocketmq.producer.namesrvAddr}")
    private String namesrvAddr;
    @Value("${rocketmq.producer.maxMessageSize}")
    private Integer maxMessageSize ;
    @Value("${rocketmq.producer.sendMsgTimeout}")
    private Integer sendMsgTimeout;
    @Value("${rocketmq.producer.retryTimesWhenSendFailed}")
    private Integer retryTimesWhenSendFailed;


    @Bean
    public DefaultMQProducer getRocketMQProducer(){
        DefaultMQProducer producer = new DefaultMQProducer();
        producer.setProducerGroup(groupName);
        producer.setNamesrvAddr(namesrvAddr);
        //如果需要同一个jvm中不同的producer往不同的mq集群发送消息，需要设置不同的instanceName
        if(this.maxMessageSize!=null){
            producer.setMaxMessageSize(maxMessageSize);
        }
        if(this.sendMsgTimeout!=null){
            producer.setSendMsgTimeout(sendMsgTimeout);
        }
        //如果发送消息失败，设置重试次数，默认为2次
        if(this.retryTimesWhenSendFailed!=null){
            producer.setRetryTimesWhenSendFailed(retryTimesWhenSendFailed);
        }

        //启动的时候，必须先初始化启动
        try {
            producer.start();
        }catch (MQClientException e){
            logger.error("===producer 初始化启动失败=｛｝",e.getMessage());
            System.err.println("producer 初始化启动失败："+e.getMessage());
        }
        return producer;
    }





}
