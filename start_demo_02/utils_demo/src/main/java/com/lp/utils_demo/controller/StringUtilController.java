package com.lp.utils_demo.controller;

import com.lp.utils_demo.model.io.ResponseModel;
import com.lp.utils_demo.utils.string.SimpleStringUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author lipeng
 * @Date 2022/9/27 10:26
 * @Version 1.0
 */
@RestController
@RequestMapping("/string")
public class StringUtilController {

    @GetMapping("/{str}")
    public ResponseModel urlDel(@PathVariable String str){
        String s = SimpleStringUtil.subStr(str,0);
        ResponseModel response = new ResponseModel("200", "success", s);
        return response;
    }
}
