package com.simple.rocketmq.general;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

/**
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2022-01-14 10:48
 **/
public class SyncProducer {
    public static void main(String[] args) throws MQClientException, MQBrokerException, RemotingException, InterruptedException {
        // 创建一个生产者，参数为生产者组的名称
        DefaultMQProducer producer = new DefaultMQProducer("sp");
        // 指定nameServer的地址
        producer.setNamesrvAddr("192.168.109.101:9876");
        // 设置当发送失败时重试发送的次数，默认为2次
        producer.setRetryTimesWhenSendFailed(3);
        // 设置发送超时时限为5s，默认3s
        producer.setSendMsgTimeout(5000);

        // 开启生产者
        // 开启生产者
        producer.start();

        // 生产并发送100条消息
        for (int i = 0; i < 10; i++) {
            byte[] body = ("Hi," + i).getBytes();
            Message msg = new Message("syncTopic", "syncTag", body);
            // 为消息指定key（业务key）
            msg.setKeys("key-" + i);
            // 同步发送消息
            SendResult sendResult = producer.send(msg);
            System.out.println(sendResult);
        }
        // 关闭producer
        producer.shutdown();
    }
}
