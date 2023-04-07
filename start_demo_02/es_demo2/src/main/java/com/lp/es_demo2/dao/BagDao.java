package com.lp.es_demo2.dao;

import com.lp.es_demo2.entity.Bag;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @Author lipeng
 * @Date 2023/4/7 14:23
 * @Version 1.0
 */
public interface BagDao extends ElasticsearchRepository<Bag, Integer> {
}
