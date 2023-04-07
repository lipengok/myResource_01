package com.lp.es_demo.controller;

import com.lp.es_demo.entity.Bag;
import com.lp.es_demo.es.service.BagEsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @Author lipeng
 * @Date 2022/7/22 15:35
 * @Version 1.0
 */
@RestController
@RequestMapping("/bag/es")
public class BagController {

    @Autowired
    BagEsService bagEsService;

    @GetMapping("/list")
    public ArrayList<Bag> list() {
        ArrayList list = new ArrayList();
        for (Bag bag : bagEsService.list()) {
            list.add(bag);
        }
        return list;
    }
}
