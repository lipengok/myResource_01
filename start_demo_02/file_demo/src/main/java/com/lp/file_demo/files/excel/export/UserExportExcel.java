package com.lp.file_demo.files.excel.export;

import com.lp.file_demo.entity.User;
import com.lp.file_demo.globe.DataGlobe;
import com.lp.file_demo.utils.Encrypt;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * POI导出
 *
 * @Author lipeng
 * @Date 2022/7/11 11:19
 * @Version 1.0
 */
public class UserExportExcel {

    public boolean export(List<User> users, String excelName, String sheetName) throws IOException {
        boolean result = false;
        // 工作簿
        HSSFWorkbook wk = null;
        // sheet
        HSSFSheet sheet = null;
        String path = DataGlobe.basePath+"\\excels\\"+excelName+".xls";
        File file = new File(path);
        if (!file.exists()){
            // 创建文件夹
            file.getParentFile().mkdir();
            // 创建文件夹
            file.createNewFile();
            wk = new HSSFWorkbook();
            DataGlobe.wkUser = wk;
        }else {
            if (null != DataGlobe.wkUser){
                wk = DataGlobe.wkUser;
            }else {
                wk = new HSSFWorkbook();
                DataGlobe.wkUser = wk;
            }
        }
        if (null == wk.getSheet(sheetName)){
            sheet = wk.createSheet(sheetName);
        }else {
            sheet = wk.getSheet(sheetName);
        }

        // ##################样式设计##################
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

        // ##################数据格式设计##################
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

        // ##################设计标题内容##################
        //设置表头高度为525
        HSSFRow row = sheet.createRow(0);
        row.setHeight((short)525);
        HSSFCell cell0 = row.createCell(0);
        cell0.setCellStyle(headStyle);
        cell0.setCellValue("用户ID");
        HSSFCell cell1 = row.createCell(1);
        cell1.setCellStyle(headStyle);
        cell1.setCellValue("用户名称");
        HSSFCell cell2 = row.createCell(2);
        cell2.setCellStyle(headStyle);
        cell2.setCellValue("用户密码");
        HSSFCell cell3 = row.createCell(3);
        cell3.setCellStyle(headStyle);
        cell3.setCellValue("用户简介");
        HSSFCell cell4 = row.createCell(4);
        cell4.setCellStyle(headStyle);
        cell4.setCellValue("用户头像地址");
        HSSFCell cell5 = row.createCell(5);
        cell5.setCellStyle(headStyle);
        cell5.setCellValue("用户学校名称");

        // ##################设计正文内容##################
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            HSSFRow rowData = sheet.createRow(i+1);
            HSSFCell cellData0 = rowData.createCell(0);
            cellData0.setCellStyle(bodyStyle);
            cellData0.setCellValue(user.getId());
            HSSFCell cellData1 = rowData.createCell(1);
            cellData1.setCellStyle(bodyStyle);
            cellData1.setCellValue(user.getName());
            HSSFCell cellData2 = rowData.createCell(2);
            cellData2.setCellStyle(bodyStyle);
            cellData2.setCellValue(Encrypt.dealStr(user.getPsw(), DataGlobe.key));
            HSSFCell cellData3 = rowData.createCell(3);
            cellData3.setCellStyle(bodyStyle);
            cellData3.setCellValue(user.getInformation());
            HSSFCell cellData4 = rowData.createCell(4);
            cellData4.setCellStyle(bodyStyle);
            cellData4.setCellValue(user.getPhoto());
            HSSFCell cellData5 = rowData.createCell(5);
            cellData5.setCellStyle(bodyStyle);
            cellData5.setCellValue(user.getSchool());

            FileOutputStream fs = null;
            try {
                fs = new FileOutputStream(file);
                wk.write(fs);
                result = true;
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                fs.close();
            }
        }
        return result;
    }

    // 检查工作簿名称是否已经存在
    public boolean checkWorkBook(){
        return false;
    }
}
