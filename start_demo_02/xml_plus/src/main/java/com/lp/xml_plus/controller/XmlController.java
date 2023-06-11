package com.lp.xml_plus.controller;

import com.lp.xml_plus.entity.response.ResponseMode;
import com.lp.xml_plus.util.XmlDomUtil;
import com.lp.xml_plus.util.XmlSAXUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author lipeng
 * @Date 2023/5/25 15:22
 * @Version 1.0
 */
@RestController
@RequestMapping("/xml")
public class XmlController {

    @GetMapping("/dom")
    public ResponseMode xmlDomParse(){
        try {
            String pathName = System.getProperty("user.dir");
            pathName = pathName +"/xml_plus/target/classes/test.xml";
            Object data = XmlDomUtil.parseTest(pathName);
            return new ResponseMode().success(data);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseMode().error(e.getMessage());
        }
    }

    @GetMapping("/sax")
    public ResponseMode xmlSAXParse(){
        try {
            String fileName = "test.xml";
            Object data = XmlSAXUtil.parseTest(fileName);
            return new ResponseMode().success(data);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseMode().error(e.getMessage());
        }
    }
}
