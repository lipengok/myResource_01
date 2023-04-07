package com.lp.es_demo.es.init;

import com.alibaba.fastjson.JSON;
import com.lp.es_demo.entity.Bag;
import com.lp.es_demo.utils.LogUtil;
import lombok.SneakyThrows;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author lipeng
 * @Date 2022/7/19 14:04
 * @Version 1.0
 */
@Component
public class EsInit implements ApplicationListener<ContextRefreshedEvent> {

    Logger logger = LogUtil.getLog();

    @SneakyThrows
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
//        ApplicationContext applicationContext = contextRefreshedEvent.getApplicationContext();
//        ElasticsearchTemplate elasticsearchTemplate = applicationContext.getBean(ElasticsearchTemplate.class);
        try {
            // 创建es的索引
            // elasticsearchRestTemplate.createIndex(Bag.class);
            // 创建es的映射
            // elasticsearchRestTemplate.putMapping(Bag.class);
            // 初始化数据
//            Bag bag = new Bag();
//            bag.setId(10);
//            bag.setName("tebu");
//            bag.setColor("red");
//            bag.setPrice(120.0);
//            bag.setSize(20.0);
//            bag.setType(1);
//            bag.setUId(1);
//            bag.setUnit("sport");
            // todo 创建es的索引,映射

            logger.info("ES初始化结束");
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("ES初始化失败");
        }
    }
}
