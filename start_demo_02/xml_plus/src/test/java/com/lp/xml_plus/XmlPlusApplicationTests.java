package com.lp.xml_plus;

import com.lp.xml_plus.util.XmlDomUtil;
import com.lp.xml_plus.util.XmlSAXUtil;
import org.dom4j.DocumentException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;

import java.net.MalformedURLException;

@SpringBootTest
class XmlPlusApplicationTests {

    @Test
    void contextLoads() throws MalformedURLException, DocumentException {
        // 获取文件
        String fileName = "test/xml";
        XmlSAXUtil.parseTest(fileName);
    }

}
