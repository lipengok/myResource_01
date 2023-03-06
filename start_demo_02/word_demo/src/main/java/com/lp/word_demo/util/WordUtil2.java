package com.lp.word_demo.util;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.*;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * word导出相关2
 *
 * @Author lipeng
 * @Date 2023/3/6 8:50
 * @Version 1.0
 */
@Component
public class WordUtil2 {

    /**
     * 导出World文档
     *
     * @param path
     * @param params
     * @param filename
     * @param response
     * @throws IOException
     * @throws InvalidFormatException
     * @author 小辰哥哥
     */
    public void exportWord(String path, Map<String, Object> params, String filename, HttpServletResponse response) throws IOException, InvalidFormatException {
        InputStream is = new FileInputStream(path);
        XWPFDocument docx = new XWPFDocument(is);
        iteraTable(params, docx);
        OutputStream os = response.getOutputStream();
        // 设置导出的内容是doc
        response.setContentType("application/octet-stream; charset=utf-8");
        response.setHeader("Content-disposition", "attachment; filename=" + filename);
        docx.write(os);
        close(os);
    }

    /**
     * 开始遍历文档中的表格
     *
     * @param params
     * @param doc
     * @throws IOException
     * @throws InvalidFormatException
     * @author 小辰哥哥
     */
    private void iteraTable(Map<String, Object> params, XWPFDocument doc) throws IOException, InvalidFormatException {
        List<XWPFTableRow> rows = null;
        List<XWPFTableCell> cells = null;

        List<XWPFTable> tables = doc.getTables();
        // 遍历这个word文档的所有table表格
        for (XWPFTable table : tables) {
            rows = table.getRows();

            // 遍历这个表格的所有行
            for (XWPFTableRow row : rows) {
                cells = row.getTableCells();

                // 遍历这一行的单元格
                for (XWPFTableCell cell : cells) {

                    // 判断该单元格的内容是否是字符串字段
                    if (strMatcher(cell.getText()).find()) {
                        // 替换字符串 字符串可以多行 也可以一行
                        replaceInStr(cell, params, doc);
                        continue;
                    }
                    // 判断该单元格内容是否是需要替换的图片
                    if (imgMatcher(cell.getText()).find()) {
                        // 把模板中的内容替换成图片 图片可以多张
                        replaceInImg(cell, params, doc);
                        continue;
                    }
                }
            }
        }
    }

    /**
     * 返回模板中匹配Matcher类（图片）
     *
     * @param imgstr
     * @return
     * @author 小辰哥哥
     */
    private Matcher imgMatcher(String imgstr) {
        Pattern pattern = Pattern.compile("@\\{(.+?)\\}");
        Matcher matcher = pattern.matcher(imgstr);
        return matcher;
    }

    /**
     * 返回模板中匹配Matcher类（字符串）
     *
     * @param str
     * @return
     * @author 小辰哥哥
     */
    private Matcher strMatcher(String str) {
        Pattern pattern = Pattern.compile("\\$\\{(.+?)\\}");
        Matcher matcher = pattern.matcher(str);
        return matcher;
    }

    /**
     * 替换模板Table中相应字段为对应的字符串值
     *
     * @param cell
     * @param params
     * @param doc
     * @author 小辰哥哥
     */
    private void replaceInStr(XWPFTableCell cell, Map<String, Object> params, XWPFDocument doc) {

        // 两种数据类型：一种是直接String，还有一种是List<String>
        String key = cell.getText().substring(2, cell.getText().length() - 1);

        Integer datatype = getMapStrDataTypeValue(params, key);

        List<XWPFParagraph> parags = cell.getParagraphs();

        // 先清空单元格中所有的段落
        for (int i = 0; i < parags.size(); i++) {
            cell.removeParagraph(i);
        }
        if (datatype.equals(0)) {
            return;
        } else if (datatype.equals(2)) {

            // 如果类型是2 说明数据类型是List<String>
            List<String> strs = (List<String>) params.get(key);
            Iterator<String> iterator = strs.iterator();
            while (iterator.hasNext()) {
                XWPFParagraph para = cell.addParagraph();
                XWPFRun run = para.createRun();
                run.setText(iterator.next());
            }
        } else if (datatype.equals(3)) {
            String str = (String) params.get(key).toString();
            cell.setText(str);
        }
    }

    /**
     * 替换模板Table中相应字段为图片
     *
     * @param cell
     * @param params
     * @param doc
     * @throws IOException
     * @throws InvalidFormatException
     * @author 小辰哥哥
     */
    private void replaceInImg(XWPFTableCell cell, Map<String, Object> params, XWPFDocument doc) throws IOException, InvalidFormatException {
        String key = cell.getText().substring(2, cell.getText().length() - 1);
        Integer dataType = getMapImgDataType(params, key);
        List<XWPFParagraph> parags = cell.getParagraphs();

        // 先清空单元格中所有的段落
        for (int i = 0; i < parags.size(); i++) {
            cell.removeParagraph(i);
        }
        if (dataType.equals(0)) {
            return;
        } else if (dataType.equals(1)) {

            // 处理单张图片
            XWPFParagraph parag = cell.addParagraph();
            Map<String, Object> pic = (Map<String, Object>) params.get(key);
            insertImg(pic, parag);
        } else if (dataType.equals(2)) {

            // 处理多张图片
            List<Map<String, Object>> pics = (List<Map<String, Object>>) params.get(key);
            Iterator<Map<String, Object>> iterator = pics.iterator();
            XWPFParagraph para = cell.addParagraph();
            Integer count = 0;
            while (iterator.hasNext()) {
                Map<String, Object> pic = iterator.next();

                // 图片并排插入
                if (Integer.parseInt(pic.get("style").toString()) == 1) {

                }

                // 图片竖排插入
                if (Integer.parseInt(pic.get("style").toString()) == 2) {
                    if (count > 0) {
                        para = cell.addParagraph();
                    }
                }
                insertImg(pic, para);
                count++;
            }
        }
    }

    /**
     * 模板中插入图片
     *
     * @param pic
     * @param para
     * @throws IOException
     * @throws InvalidFormatException
     * @author 小辰哥哥
     */
    private void insertImg(Map<String, Object> pic, XWPFParagraph para) throws IOException, InvalidFormatException {
        if (pic.get("imgPath").toString() == null) {
            return;
        }
        String picPath = pic.get("imgPath").toString();
        InputStream is = new FileInputStream(picPath);
        BufferedImage bi = ImageIO.read(new File(picPath));
        XWPFRun run = para.createRun();

        // 原图片的长宽
        Integer width = bi.getWidth();
        Integer heigh = bi.getHeight();
        Double much = 80.0 / width;

        // 图片按宽80 比例缩放
        run.addPicture(is, getPictureType(picPath.substring(picPath.lastIndexOf(".") + 1)), "", Units.toEMU(80), Units.toEMU(heigh * much));

        // 图片原长宽
//        run.addPicture(is, getPictureType(picPath.substring(picPath.lastIndexOf(".") + 1)), "", Units.toEMU(width), Units.toEMU(heigh));
        close(is);
        bi = null;
    }

    /**
     * 处理模板中的变量名字，去掉${}，然后根据这个变量名在参数map中查找对应的Value值
     *
     * @param params
     * @param key
     * @return
     * @author 小辰哥哥
     */
    private Integer getMapStrDataTypeValue(Map<String, Object> params, String key) {
        if (params.get(key) == null) {
            return 0;
        } else if (params.get(key) instanceof List) {
            return 2;
        } else if (params.get(key) instanceof String) {
            return 3;
        } else {
            throw new RuntimeException("String Data Type Error!");
        }
    }

    /**
     * 从参数中找到模板中key对应的value值
     *
     * @param params
     * @param key
     * @return
     * @author 小辰哥哥
     */
    private Integer getMapImgDataType(Map<String, Object> params, String key) {
        if (params.get(key) == null) {
            return 0;
        } else if (params.get(key) instanceof Map) {
            return 1;
        } else if (params.get(key) instanceof List) {
            return 2;
        } else {
            throw new RuntimeException("Image Data Type Error!");
        }
    }

    /**
     * 根据图片类型，获取对应的图片类型代码
     *
     * @param picType
     * @return int
     * @author 小辰哥哥
     */
    private int getPictureType(String picType) {
        int result = XWPFDocument.PICTURE_TYPE_PICT;
        if (picType != null) {
            if (picType.equalsIgnoreCase("png")) {
                result = XWPFDocument.PICTURE_TYPE_PNG;
            } else if (picType.equalsIgnoreCase("dib")) {
                result = XWPFDocument.PICTURE_TYPE_DIB;
            } else if (picType.equalsIgnoreCase("emf")) {
                result = XWPFDocument.PICTURE_TYPE_EMF;
            } else if (picType.equalsIgnoreCase("jpg") || picType.equalsIgnoreCase("jpeg")) {
                result = XWPFDocument.PICTURE_TYPE_JPEG;
            } else if (picType.equalsIgnoreCase("wmf")) {
                result = XWPFDocument.PICTURE_TYPE_WMF;
            }
        }
        return result;
    }

    /**
     * 关闭输入流
     *
     * @param is
     * @author 小辰哥哥
     */
    private void close(InputStream is) {
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭输出流
     *
     * @param os
     * @author 小辰哥哥
     */
    private void close(OutputStream os) {
        if (os != null) {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

