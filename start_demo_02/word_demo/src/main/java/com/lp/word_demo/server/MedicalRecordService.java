package com.lp.word_demo.server;

import com.lp.word_demo.dao.MedicalRecordDao;
import com.lp.word_demo.enity.MedicalRecord;
import com.lp.word_demo.util.WordUtil;
import com.lp.word_demo.util.WordUtil2;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author lipeng
 * @Date 2023/3/2 14:31
 * @Version 1.0
 */
@Slf4j
@Service
public class MedicalRecordService {

    @Autowired
    private MedicalRecordDao medicalRecordDao;

    @Autowired
    private WordUtil2 wordUtil2;

    private Map<String,Object> transRecord(MedicalRecord record){
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
        Map<String,Object> params = new HashMap<>();
        params.put("patientId",record.getPatientId() == null ? "暂无": record.getPatientId());
        params.put("name",record.getName() == null ? "暂无": record.getName());
        params.put("gender",record.getGender()==1? "男":"女");
        params.put("doctorName",record.getDoctorName() == null ? "暂无": record.getDoctorName());
        params.put("birthday", record.getBirthday() == null ? "暂无": dateFormat.format(record.getBirthday()));
        params.put("height",record.getHeight() == null ? "暂无": record.getHeight());
        params.put("weight",record.getWeight() == null ? "暂无": record.getWeight());
        params.put("disease",record.getDisease() == null ? "暂无": record.getDisease());
        params.put("chfCmp",record.getChfCmp() == null ? "暂无": record.getChfCmp());
        params.put("hisPreIll",record.getHisPreIll() == null ? "暂无": record.getHisPreIll());
        params.put("hisTre",record.getHisTre() == null ? "": record.getHisTre());
        params.put("prvMedHis",record.getPrvMedHis() == null ? "暂无": record.getPrvMedHis());
        params.put("perHis",record.getPerHis() == null ? "暂无": record.getPerHis());
        params.put("famHis",record.getFamHis() == null ? "暂无": record.getFamHis());
        params.put("treAdv",record.getTreAdv() == null ? "暂无": record.getTreAdv());

        return params;
    }

    public List<MedicalRecord> findAll(){
        return medicalRecordDao.findAll();
    }

    public MedicalRecord findById(String id){
        return medicalRecordDao.findById(id).get();
    }

    public void downloadBatchMedicalRecord(String docPath, HttpServletRequest request, HttpServletResponse response){
        List<MedicalRecord> list = findAll();
        for (int i = 0; i < list.size(); i++) {
            downloadOneMedicalRecord(list.get(i), i+1, docPath, request, response);
        }
    }

    /**
     * easy-poi--导出word文档
     */
    public void downloadOneMedicalRecord(MedicalRecord record, Integer id, String docPath, HttpServletRequest request, HttpServletResponse response){
        Map<String,Object> params = transRecord(record);
        WordUtil.exportWord(docPath+"电子病历"+id+".docx",docPath+"test/","medica.docx",params,request,response);
    }


    /**
     * apache-poi--导出word文档
     * @param record    实体类对象
     * @param path      word模板路径
     * @param filName   导出文件名
     * @param response  响应对象
     */
    public void exportWord(MedicalRecord record, String path, String filName,  HttpServletResponse response) throws IOException, InvalidFormatException {
        Map<String,Object> params = transRecord(record);
        wordUtil2.exportWord(path, params, filName, response);
        log.info("导出成功");
    }
}
