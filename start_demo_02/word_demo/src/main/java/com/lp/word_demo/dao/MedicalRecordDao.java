package com.lp.word_demo.dao;

import com.lp.word_demo.enity.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author lipeng
 * @Date 2023/3/2 15:52
 * @Version 1.0
 */
public interface MedicalRecordDao extends JpaRepository<MedicalRecord, String> {
}
