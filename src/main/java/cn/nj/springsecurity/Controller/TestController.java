package cn.nj.springsecurity.Controller;

import cn.nj.springsecurity.MQ.test;
import cn.nj.springsecurity.Service.RocketMqService;
import com.alibaba.fastjson.JSON;
import org.apache.rocketmq.client.producer.SendResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * /**
 * Package: cn.nj.springsecurity.Controller
 *   消息发送测试
 * @Author: zhaotianyu
 * @Date: 2020/1/16
 */
@RequestMapping("/mq")
@RestController
public class TestController {
     private static final Logger logger= LoggerFactory.getLogger(TestController.class);

    @Autowired
    private RocketMqService mqService;


    @GetMapping("/send")
    public SendResult send(){
        test test = new test();
        test.setLoginName("逍遥");
        test.setPwd("1");
        test test2 = new test();
        test2.setLoginName("乐言");
        test2.setPwd("2");
        List<test> list = new ArrayList<>();
        list.add(test);
        list.add(test2);
        String msg = JSON.toJSONString(list);
        SendResult sendResult=null;
        try {
            sendResult=mqService.openAccountMsg(msg);
        }catch (Exception e){
            logger.error("控制层发送消费者报错={}",e.getMessage());
            e.printStackTrace();
        }
        return sendResult;

    }
}
