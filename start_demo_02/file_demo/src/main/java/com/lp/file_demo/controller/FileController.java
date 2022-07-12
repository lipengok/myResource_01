package com.lp.file_demo.controller;

import com.lp.file_demo.entity.pojo.ExportData;
import com.lp.file_demo.enums.CodeEnum;
import com.lp.file_demo.enums.MsgEnum;
import com.lp.file_demo.modle.response.BaseResponse;
import com.lp.file_demo.service.StudentService;
import com.lp.file_demo.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

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

    @Autowired
    private UploadService uploadService;

    // todo 上传文件
    @PostMapping("/upload/server")
    public BaseResponse upload(@RequestParam("file") MultipartFile file) throws Exception {
        boolean res = uploadService.uploadServer(file);
        if (res){
            return new BaseResponse(MsgEnum.UPLOAD_SUCCESS.value(), CodeEnum.COMMON_SUCCESS_CODE.value(), file.getName());
        }else {
            return new BaseResponse(MsgEnum.UPLOAD_DEFAULT.value(), CodeEnum.COMMON_DEFAULT_CODE.value(), null);
        }
    }

    // todo 下载文件
    @GetMapping("/download/{name}")
    public BaseResponse download(@PathVariable String name, HttpServletResponse response){
        return null;
    }

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
