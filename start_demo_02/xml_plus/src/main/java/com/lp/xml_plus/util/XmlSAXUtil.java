package com.lp.xml_plus.util;

import java.net.MalformedURLException;
import java.net.URL;

import com.lp.xml_plus.entity.Item;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.ArrayList;
import java.util.List;

/**
 * SAX Parser
 *
 * SAX Parser是基于事件
 * 不会会将整个XML文档加载到内存中，它在解析过程中逐个处理XML元素。
 *
 * @Author lipeng
 * @Date 2023/5/25 14:08
 * @Version 1.0
 */
public class XmlSAXUtil {

    public static ArrayList<Item> parseTest(String fileName) throws DocumentException {
        ArrayList<Item> resItems = new ArrayList<>();

        SAXReader reader = new SAXReader();
        URL sources = XmlSAXUtil.class.getClassLoader().getResource(fileName);
        Document document = reader.read(sources);
        List<Element> elements = document.getRootElement().elements();
        for (Element element : elements) {
            String id = element.attribute("id").getValue();
            // String dataItemId = element.element("dataItemId").getTextTrim();
            String dataItemId = element.elementTextTrim("dataItemId");
            String dataItemName = element.elementTextTrim("dataItemName");

            Item resItem = new Item();
            resItem.setId(id);
            resItem.setDataItemId(dataItemId);
            resItem.setDataItemName(dataItemName);
            resItems.add(resItem);
        }
        return resItems;
    }


    public static void main(String[] args) throws DocumentException {
        // 获取文件
        String fileName = "test.xml";
        XmlSAXUtil.parseTest(fileName);
    }
}
