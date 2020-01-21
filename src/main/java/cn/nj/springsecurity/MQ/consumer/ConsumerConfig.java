package cn.nj.springsecurity.MQ.consumer;

import cn.nj.springsecurity.MQ.RocketMsgListener;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * /**
 * Package: cn.nj.springsecurity.MQ.consumer
 *
 * RocketMQ 消费者配置
 *
 * @Author: zhaotianyu
 * @Date: 2020/1/21
 */
@Configuration
public class ConsumerConfig {

    private static final Logger logger = LoggerFactory.getLogger(ConsumerConfig.class) ;

    @Value("${rocketmq.consumer.namesrvAddr}")
    private String namesrvAddr;
    @Value("${rocketmq.consumer.groupName}")
    private String groupName;
    @Value("${rocketmq.consumer.consumeThreadMin}")
    private int consumeThreadMin;
    @Value("${rocketmq.consumer.consumeThreadMax}")
    private int consumeThreadMax;
    @Value("${rocketmq.consumer.topics}")
    private String topics;
    @Value("${rocketmq.consumer.consumeMessageBatchMaxSize}")
    private int consumeMessageBatchMaxSize;

    @Autowired
    private RocketMsgListener msgListener;

    @Bean
    public DefaultMQPushConsumer pushConsumer(){
        DefaultMQPushConsumer Consumer = new DefaultMQPushConsumer();
        Consumer.setConsumerGroup(groupName);
        Consumer.setNamesrvAddr(namesrvAddr);
        Consumer.setConsumeThreadMin(consumeThreadMin);
        Consumer.setConsumeThreadMax(consumeThreadMax);
        Consumer.registerMessageListener(msgListener);
        Consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);
        Consumer.setConsumeMessageBatchMaxSize(consumeMessageBatchMaxSize);

        try {
            String[] topicTagsArr  = topics.split(";");
            for (String topicTags  : topicTagsArr) {
                String[] topicTag  = topicTags.split("~");
                Consumer.subscribe(topicTag[0],topicTag[1]);
            }
            Consumer.start();
        }catch (MQClientException e){
            logger.error("消费订阅报错={}",e.getMessage());
            System.err.println("消费者报错了");
        }
        return Consumer;

    }

}
