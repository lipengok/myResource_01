package com.lp.word_demo.enity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 病例表
 *
 * @Author lipeng
 * @Date 2023/3/2 15:02
 * @Version 1.0
 */
@Data
@Entity
@Table(name = "medical_record")
public class MedicalRecord {

    @Id
    private String id;

    // 患者id
    private String patientId;

    // 姓名
    private String name;

    // 性别
    private Integer gender;

    // 医生
    private String doctorName;

    // 出生日期
    private Date birthday;

    // 身高
    private Double height;

    // 体重
    private Double weight;

    private String disease;

    // 主诉
    private String chfCmp;

    // 病史
    private String hisPreIll;

    // 治疗史
    private String hisTre;

    // 既往史
    private String prvMedHis;

    // 个人史
    private String perHis;

    // 家族史
    private String famHis;

    // 治疗建议
    private String treAdv;


}
