package com.lp.excel_demo.controller;

import com.lp.excel_demo.entity.User;
import com.lp.excel_demo.excel.exp.ExcelExport;
import com.lp.excel_demo.excel.imp.ExcelImport;
import com.lp.excel_demo.service.impl.UserServiceImpl;
import com.lp.excel_demo.templates.ResponseTmp;
import com.lp.excel_demo.templates.enums.CodeEnum;
import com.lp.excel_demo.templates.enums.MsgEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author lipeng
 * @Date 2023/2/1 10:02
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private ExcelExport excelExport;

    @Autowired
    private ExcelImport excelImport;

    /**
     * 将文件中的数据导入到数据库
     * @return
     */
    @PostMapping("/impAll")
    public ResponseTmp impAll(@RequestParam("file") MultipartFile file) throws IOException {
        excelImport.importPersonFile(file);
        return new ResponseTmp(MsgEnum.COMMON_SUCCESS_MSG.value(), CodeEnum.COMMON_SUCCESS_CODE.value(), "ok");
    }

    @PostMapping("/batchUsers")
    public ResponseTmp batchInsert(@RequestBody List<User> list){
        userService.batchUsers(list);
        return new ResponseTmp(MsgEnum.COMMON_SUCCESS_MSG.value(), CodeEnum.COMMON_SUCCESS_CODE.value(), "ok");
    }

    @GetMapping("/findAll")
    public ResponseTmp findAll(){
        List<User> list = userService.list();
        return new ResponseTmp(MsgEnum.COMMON_SUCCESS_MSG.value(), CodeEnum.COMMON_SUCCESS_CODE.value(), list);
    }

    @GetMapping("/expAll")
    public void expAll(HttpServletResponse response){
        List<User> list = userService.listEncryptPwd();
        excelExport.export(response,"userList", list, User.class);
    }
}
