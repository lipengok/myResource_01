package com.lp.medium_demo.controller;

import com.lp.medium_demo.globe.CommonGlobe;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author lipeng
 * @Date 2023/4/17 9:04
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/medium")
@AllArgsConstructor
public class MediumController {

    // 不使用模板返回页面，默认访问static目录下的文件
    @GetMapping("/index")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(CommonGlobe.webIndexPath);
        return modelAndView;
    }
}
