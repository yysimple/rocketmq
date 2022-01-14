package com.simple.rocketmq.general;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;

/**
 * 功能描述: 单向发送
 *
 * @author: WuChengXing
 * @create: 2022-01-14 11:48
 **/
public class SingleSendProducer {
    public static void main(String[] args) throws Exception{
        DefaultMQProducer producer = new DefaultMQProducer("ssp");
        producer.setNamesrvAddr("192.168.109.101:9876");
        producer.start();
        // 设置发送超时时限为5s，默认3s
        producer.setSendMsgTimeout(5000);
        for (int i = 0; i < 10; i++) {
            byte[] body = ("Hi," + i).getBytes();
            Message msg = new Message("singleTopic", "singleTag", body);
            // 单向发送
            producer.sendOneway(msg);
        }
        producer.shutdown();
        System.out.println("producer shutdown");
    }
}
