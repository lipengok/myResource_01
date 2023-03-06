package com.lp.word_demo.controller;

import com.lp.word_demo.dao.MedicalRecordDao;
import com.lp.word_demo.enity.MedicalRecord;
import com.lp.word_demo.mode.response.ResponseTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 病例表
 *
 * @Author lipeng
 * @Date 2023/3/3 9:41
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("medical")
public class MedicalController {

    @Autowired
    private MedicalRecordDao medicalRecordDao;

    @GetMapping("/list")
    public ResponseTemplate list(){
        return new ResponseTemplate().success(medicalRecordDao.findAll());
    }

    @GetMapping("/{id}")
    public ResponseTemplate findById(@PathVariable String id){
        return new ResponseTemplate().success(medicalRecordDao.findById(id));
    }
}
