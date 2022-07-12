package com.lp.file_demo.controller;

import com.lp.file_demo.entity.User;
import com.lp.file_demo.entity.pojo.BaseExportData;
import com.lp.file_demo.entity.pojo.ExportData;
import com.lp.file_demo.enums.CodeEnum;
import com.lp.file_demo.enums.MsgEnum;
import com.lp.file_demo.modle.response.BaseResponse;
import com.lp.file_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author lipeng
 * @Date 2022/7/11 14:14
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/export")
    public BaseResponse exportExcel(@RequestBody BaseExportData<User> baseExportData) throws Exception {
        boolean res = userService.exportExcel(baseExportData);
        if (res){
            return new BaseResponse(MsgEnum.EXPORT_SUCCESS.value(), CodeEnum.COMMON_SUCCESS_CODE.value(), baseExportData.getFileName());
        }else {
            return new BaseResponse(MsgEnum.EXPORT_DEFAULT.value(), CodeEnum.COMMON_DEFAULT_CODE.value(), null);
        }
    }

}
