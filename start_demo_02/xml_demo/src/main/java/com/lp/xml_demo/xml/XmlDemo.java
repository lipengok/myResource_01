package com.lp.xml_demo.xml;

import java.net.URL;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import java.util.List;

/**
 * @Author lipeng
 * @Date 2023/5/7 13:00
 * @Version 1.0
 */
public class XmlDemo {

    public void readXml(String fileName) throws Exception {
        //创建SAXReader对象
        SAXReader reader = new SAXReader();
        //xml文件的位置
        URL sources = XmlDemo.class.getClassLoader().getResource(fileName);
        //创建document对象,并读取xml文件 （解析xml文件）
        Document document = reader.read(sources);
        //读取元素   getRootElement() --》 获取父节点  elements() --> 所有节点
        List<Element> elements = document.getRootElement().elements();

        for (Element element : elements) {
            String dataItemId = element.attributeValue("dataItemId");
            String dataItemName = element.attributeValue("dataItemName");
            System.out.println(dataItemId);
            System.out.println(dataItemName);
        }

    }

    public static void main(String[] args) throws Exception {
        new XmlDemo().readXml("test.xml");
    }
}
