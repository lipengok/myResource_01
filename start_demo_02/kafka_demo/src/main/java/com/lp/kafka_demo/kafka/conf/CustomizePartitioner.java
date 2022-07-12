package com.lp.kafka_demo.kafka.conf;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;

import java.util.Map;

/**
 * 自定义分区规则类（使用分区0）
 * @Author lipeng
 * @Date 2022/6/29 16:50
 * @Version 1.0
 */
// 自定义分区规则，使用分区0
public class CustomizePartitioner implements Partitioner {
    @Override
    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
        // 自定义分区规则(这里假设全部发到0号分区)
        return 0;
    }
    @Override
    public void close() { }
    @Override
    public void configure(Map<String, ?> configs) {}
}
