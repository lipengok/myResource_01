package com.lp.es_demo.es.repository;

import com.lp.es_demo.entity.Bag;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @Author lipeng
 * @Date 2022/7/19 14:02
 * @Version 1.0
 */
public interface BagEsRepository extends ElasticsearchRepository<Bag, Integer> {
}
