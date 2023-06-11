package com.lp.xml_plus.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import com.alibaba.fastjson2.JSON;
import com.lp.xml_plus.entity.Item;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


/**
 * Java DOM
 *
 * Java DOM Parser是一个标准的Java库，用于解析和操作XML文档
 * 会将整个XML文档加载到内存中
 *
 * @Author lipeng
 * @Date 2023/5/25 14:08
 * @Version 1.0
 */
public class XmlDomUtil {

    public static ArrayList<Item> parseTest(String pathName){
        ArrayList<Item> resItems = new ArrayList<>();

        try {
            File inputFile = new File(pathName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("items");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Element root = (Element) nodeList.item(i);
                NodeList items = root.getElementsByTagName("item");
                for (int i1 = 0; i1 < items.getLength(); i1++) {
                    Element item = (Element) items.item(i1);
                    Item resItem = new Item();
                    resItem.setId(item.getAttribute("id"));
                    resItem.setDataItemId(item.getElementsByTagName("dataItemId").item(0).getTextContent().trim());
                    resItem.setDataItemName(item.getElementsByTagName("dataItemName").item(0).getTextContent().trim());
                    resItems.add(resItem);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resItems;
    }

    public static void main(String[] args) throws FileNotFoundException {
        // 获取文件路径
        String pathName = System.getProperty("user.dir");
        pathName = pathName +"/xml_plus/target/classes/test.xml";
        System.out.println(pathName);
        XmlDomUtil.parseTest(pathName);
    }
}
