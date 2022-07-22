package com.lp.es_demo.es.init;

import com.lp.es_demo.entity.Bag;
import lombok.SneakyThrows;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

/**
 * @Author lipeng
 * @Date 2022/7/19 14:04
 * @Version 1.0
 */
public class EsInit implements ApplicationListener<ContextRefreshedEvent> {
    @SneakyThrows
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        ApplicationContext applicationContext = contextRefreshedEvent.getApplicationContext();
        ElasticsearchTemplate elasticsearchTemplate = applicationContext.getBean(ElasticsearchTemplate.class);
        try {
            // 创建es的索引
            elasticsearchTemplate.createIndex(Bag.class);
            // 创建es的映射
            elasticsearchTemplate.putMapping(Bag.class);
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("ES初始化失败");
        }
    }
}
