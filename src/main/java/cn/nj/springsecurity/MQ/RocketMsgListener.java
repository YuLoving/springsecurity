package cn.nj.springsecurity.MQ;

import com.alibaba.fastjson.JSON;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * /**
 * Package: cn.nj.springsecurity.MQ
 *  消息消费监听
 * @Author: zhaotianyu
 * @Date: 2020/1/21
 */
@Component
public class RocketMsgListener  implements MessageListenerConcurrently {

    private static final Logger logger= LoggerFactory.getLogger(RocketMsgListener.class);

    @Autowired
    private ParamConfigService configService;

    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
            logger.info("消息消费监听中的list的数量={}", list.size());
            logger.info("消息消费监听中的list={}", JSON.toJSONString(list));
            if(CollectionUtils.isEmpty(list)){
                return  ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
            MessageExt messageExt = list.get(0);
            logger.info("接收的消息为={}",new String(messageExt.getBody()));
            int reConsume = messageExt.getReconsumeTimes();
            // 消息已经重试了3次，如果不需要再次消费，则返回成功
            if(reConsume ==3){
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
            if(messageExt.getTopic().equals(configService.rocketTopic)){
                String tags = messageExt.getTags();
                switch (tags){
                    case "rocketTag":
                        logger.info("开户 tag==>>"+tags);
                        break;
                    default:
                        logger.info("未匹配到 tag==>>"+tags);
                        break;
                }
            }
            //消息消费成功
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }
}
