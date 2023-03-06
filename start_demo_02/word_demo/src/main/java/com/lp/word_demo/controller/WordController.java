package com.lp.word_demo.controller;

import com.lp.word_demo.enity.MedicalRecord;
import com.lp.word_demo.mode.response.ResponseTemplate;
import com.lp.word_demo.server.MedicalRecordService;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * word文档导出
 *
 * @Author lipeng
 * @Date 2023/3/2 14:31
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("word")
public class WordController {

    @Autowired
    private MedicalRecordService medicalRecordService;

    /**
     * 自定义文档导出
     * @param record
     * @param request
     * @param response
     */
    @PostMapping("/download")
    public void downloadOneMedicalRecord(@RequestBody MedicalRecord record, HttpServletRequest request, HttpServletResponse response) {
        String docPath = "E:/github/myResource_02/start_demo_02/word_demo/docxs/";
        medicalRecordService.downloadOneMedicalRecord(record, 1, docPath, request,response);
    }
    @PostMapping("/download2")
    public void downloadOneMedicalRecord2(@RequestBody MedicalRecord record, HttpServletRequest request, HttpServletResponse response) throws IOException, InvalidFormatException {
        String docPath = "E:\\github\\myResource_02\\start_demo_02\\word_demo\\docxs\\电子病历1.docx";
        medicalRecordService.exportWord(record, docPath, "exportFile.docx", response);
    }
    // 测试使用，在浏览器上测试
    @GetMapping("/download2")
    public void downloadRecordTest2(HttpServletRequest request, HttpServletResponse response) throws IOException, InvalidFormatException {
        String docPath = "E:\\github\\myResource_02\\start_demo_02\\word_demo\\docxs\\电子病历1.docx";
        MedicalRecord record = medicalRecordService.findById("1");
        medicalRecordService.exportWord(record, docPath, "exportFile.docx", response);
    }

    /**
     * 导出所有的文档
     * @param request
     * @param response
     */
    @GetMapping("/downloadAll")
    public void downloadBatchMedicalRecord(HttpServletRequest request, HttpServletResponse response) {
        String docPath = "E:/github/myResource_02/start_demo_02/word_demo/docxs/";
        medicalRecordService.downloadBatchMedicalRecord(docPath, request,response);
    }

}
