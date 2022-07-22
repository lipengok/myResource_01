package com.lp.es_demo.es.service;

import com.lp.es_demo.entity.Bag;
import com.lp.es_demo.es.repository.BagEsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author lipeng
 * @Date 2022/7/19 14:27
 * @Version 1.0
 */
@Service
public class BagEsService {

    @Autowired
    BagEsRepository bagEsRepository;

    public void add(Bag bag) throws Exception {
        if (null == bag){
            throw new Exception("bag不为空");
        }
        bagEsRepository.save(bag);
    }
}
