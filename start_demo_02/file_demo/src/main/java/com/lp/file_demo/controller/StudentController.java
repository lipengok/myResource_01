package com.lp.file_demo.controller;

import com.lp.file_demo.entity.Student;
import com.lp.file_demo.entity.pojo.BaseImportData;
import com.lp.file_demo.enums.CodeEnum;
import com.lp.file_demo.enums.MsgEnum;
import com.lp.file_demo.modle.response.BaseResponse;
import com.lp.file_demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * @Author lipeng
 * @Date 2022/7/11 15:16
 * @Version 1.0
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/import")
    public BaseResponse importStu(@RequestBody BaseImportData baseImportData) throws IOException {
        List<Student> list = studentService.importStudent(baseImportData.getXslName(), baseImportData.getSheetName());
        return new BaseResponse(MsgEnum.IMPORT_SUCCESS.value(), CodeEnum.COMMON_SUCCESS_CODE.value(), list);
    }
}
