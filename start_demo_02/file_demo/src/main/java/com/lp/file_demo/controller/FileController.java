package com.lp.file_demo.controller;

import com.lp.file_demo.entity.pojo.ExportData;
import com.lp.file_demo.enums.CodeEnum;
import com.lp.file_demo.enums.MsgEnum;
import com.lp.file_demo.modle.response.BaseResponse;
import com.lp.file_demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author lipeng
 * @Date 2022/7/8 15:37
 * @Version 1.0
 */
@RestController
@RequestMapping("file")
public class FileController {
    @Autowired
    private StudentService studentService;

    // 上传文件

    // 下载文件

    // excel导入

    // excel导出
    @PostMapping("/export")
    public BaseResponse exportExcel(@RequestBody ExportData exportData) throws Exception {
        boolean res = studentService.exportStudent(exportData.getStudents(), exportData.getFileName(), exportData.getSheetName());
        if (res){
            return new BaseResponse(MsgEnum.EXPORT_SUCCESS.value(), CodeEnum.COMMON_SUCCESS_CODE.value(), exportData.getFileName());
        }else {
            return new BaseResponse(MsgEnum.EXPORT_DEFAULT.value(), CodeEnum.COMMON_DEFAULT_CODE.value(), null);
        }
    }
}
