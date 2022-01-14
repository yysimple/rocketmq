package com.simple.rocketmq.enums;

/**
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2022-01-14 10:52
 **/
public enum SendStatusEnum {
    /**
     * 发送成功
     */
    SEND_OK,

    /**
     * 刷盘超时。当Broker设置的刷盘策略为同步刷盘时才可能出现这种异常状态。异步刷盘不会出现
     */
    FLUSH_DISK_TIMEOUT,

    /**
     * Slave同步超时。当Broker集群设置的Master-Slave的复制方式为同步复制时才可能出现这种异常状态。异步复制不会出现
     */
    FLUSH_SLAVE_TIMEOUT,

    /**
     * 没有可用的Slave。当Broker集群设置为Master-Slave的复制方式为同步复制时才可能出现这种异常状态。异步复制不会出现
     */
    SLAVE_NOT_AVAILABLE,
}
