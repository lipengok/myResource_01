package com.lp.file_demo.files.excel.export;

import com.lp.file_demo.entity.Student;
import com.lp.file_demo.globe.DataGlobe;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * POI导出
 *
 * student表的excel表格导出
 * @Author lipeng
 * @Date 2022/7/8 15:47
 * @Version 1.0
 */
public class StudentExportExcel {

    // excel文件导出
    public boolean export(List<Student> students, String excelName, String sheetName) throws SQLException {
        boolean resultStu = false;
        HSSFWorkbook wk = new HSSFWorkbook();
        //表头的样式
        HSSFCellStyle headStyle = wk.createCellStyle();
        //表头内容水平居中
        headStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        //表头内容垂直居中
        headStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        //表头中字体
        HSSFFont headFont = wk.createFont();
        //表头字体为宋体
        headFont.setFontName("宋体");
        //表头字体大小为16
        headFont.setFontHeightInPoints((short)16);
        //表头字体加粗
        headFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        //字体样式放入表头样式
        headStyle.setFont(headFont);
        //填充背景色
        headStyle.setFillForegroundColor(HSSFColor.LIME.index);
        headStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        //自定义颜色
        HSSFPalette palette = wk.getCustomPalette();
        //设置RGB颜色
        palette.setColorAtIndex(HSSFColor.LIME.index, (byte) 149, (byte) 179, (byte) 215);
        //设置表头下边框
        headStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        //设置表头左边框
        headStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        //设置表头上边框
        headStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        //设置表头右边框
        headStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);

        //数据内容的样式
        HSSFCellStyle bodyStyle = wk.createCellStyle();
        //数据内容水平居中
        bodyStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        //数据内容垂直居中
        bodyStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        //设置数据内容下边框
        bodyStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        //设置数据内容左边框
        bodyStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        //设置数据内容上边框
        bodyStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        //设置数据内容右边框
        bodyStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        //设置sheet页名为查询条件的内容
        HSSFSheet sheet = wk.createSheet(sheetName);

        //设置表头高度为525
        HSSFRow row = sheet.createRow(1);
        row.setHeight((short)525);
        //每个表头的单元格设置样式
        HSSFCell cell1 = row.createCell(1);
        cell1.setCellStyle(headStyle);
        cell1.setCellValue("学号");
        HSSFCell cell2 = row.createCell(2);
        cell2.setCellStyle(headStyle);
        cell2.setCellValue("姓名");
        HSSFCell cell3 = row.createCell(3);
        cell3.setCellStyle(headStyle);
        cell3.setCellValue("性别");
        HSSFCell cell4 = row.createCell(4);
        cell4.setCellStyle(headStyle);
        cell4.setCellValue("年龄");
        HSSFCell cell5 = row.createCell(5);
        cell5.setCellStyle(headStyle);
        cell5.setCellValue("年级");
        HSSFCell cell6 = row.createCell(6);
        cell6.setCellStyle(headStyle);
        cell6.setCellValue("班级");
        HSSFCell cell7 = row.createCell(7);
        cell7.setCellStyle(headStyle);
        cell7.setCellValue("学科1");
        HSSFCell cell8 = row.createCell(8);
        cell8.setCellStyle(headStyle);
        cell8.setCellValue("学科2");
        HSSFCell cell9 = row.createCell(9);
        cell9.setCellStyle(headStyle);
        cell9.setCellValue("学科3");
        HSSFCell cell10 = row.createCell(10);
        cell10.setCellStyle(headStyle);
        cell10.setCellValue("总分");
        HSSFCell cell11 = row.createCell(11);
        cell11.setCellStyle(headStyle);
        cell11.setCellValue("排名");
        for(int i=0;i<students.size();i++){
            Student student = students.get(i);
            //每行的每个数据单元格设置样式
            HSSFRow dataRow = sheet.createRow(i+2);
            HSSFCell dataCell1 = dataRow.createCell(1);
            dataCell1.setCellStyle(bodyStyle);
            dataCell1.setCellValue(student.getStuNo());
            HSSFCell dataCell2 = dataRow.createCell(2);
            dataCell2.setCellStyle(bodyStyle);
            dataCell2.setCellValue(student.getName());
            HSSFCell dataCell3 = dataRow.createCell(3);
            dataCell3.setCellStyle(bodyStyle);
            dataCell3.setCellValue(student.getSex());
            HSSFCell dataCell4 = dataRow.createCell(4);
            dataCell4.setCellStyle(bodyStyle);
            dataCell4.setCellValue(student.getAge());
            HSSFCell dataCell5 = dataRow.createCell(5);
            dataCell5.setCellStyle(bodyStyle);
            dataCell5.setCellValue(student.getStuGrade());
            HSSFCell dataCell6 = dataRow.createCell(6);
            dataCell6.setCellStyle(bodyStyle);
            dataCell6.setCellValue(student.getStuClass());
            HSSFCell dataCell7 = dataRow.createCell(7);
            dataCell7.setCellStyle(bodyStyle);
            dataCell7.setCellValue(student.getScore1());
            HSSFCell dataCell8 = dataRow.createCell(8);
            dataCell8.setCellStyle(bodyStyle);
            dataCell8.setCellValue(student.getScore2());
            HSSFCell dataCell9 = dataRow.createCell(9);
            dataCell9.setCellStyle(bodyStyle);
            dataCell9.setCellValue(student.getScore3());
            HSSFCell dataCell10 = dataRow.createCell(10);
            dataCell10.setCellStyle(bodyStyle);
            dataCell10.setCellValue(student.getScore());
            HSSFCell dataCell11 = dataRow.createCell(11);
            dataCell11.setCellStyle(bodyStyle);
            dataCell11.setCellValue(student.getLevel());
        }
        FileOutputStream fs = null;
        //导出的Excel文件存放路径
        String path = DataGlobe.basePath+"\\excels\\"+excelName+".xls";
        try {
            File file = new File(path);
            if (!file.exists()){
                // 创建文件夹
                file.getParentFile().mkdir();
                // 创建文件夹
                file.createNewFile();
            }
            fs = new FileOutputStream(file);
            wk.write(fs);
            resultStu = true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try {
                fs.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return resultStu;
    }


}
