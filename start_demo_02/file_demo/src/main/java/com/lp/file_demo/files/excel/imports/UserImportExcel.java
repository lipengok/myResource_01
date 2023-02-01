package com.lp.file_demo.files.excel.imports;

import com.lp.file_demo.entity.Student;
import com.lp.file_demo.entity.User;
import com.lp.file_demo.globe.DataGlobe;
import com.lp.file_demo.utils.Encrypt;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * POI导入
 *
 * @Author lipeng
 * @Date 2022/7/12 8:46
 * @Version 1.0
 */
public class UserImportExcel {

    // excel导入
    public List<User> imports(String xslName, String sheetName) throws IOException {
        //需要解析的Excel文件
        String path = DataGlobe.basePath+"\\excels\\"+xslName+".xls";
        File file=new  File(path);
        FileInputStream fs = null;
        List list = new ArrayList();
        try {
            //获取工作簿
            fs= FileUtils.openInputStream(file);
            HSSFWorkbook workbook=new HSSFWorkbook(fs);
            //获取第一个工作表
            HSSFSheet hs = workbook.getSheet(sheetName);
            List<User> users = new ArrayList<>();

            //遍历获取单元格里的信息（导出的数据是从row-index：1；cell-index：0开始）
            for (int i = 1; i <=hs.getLastRowNum(); i++) {
                User user = new User();
                HSSFRow row=hs.getRow(i);
                HSSFCell cell0 = row.getCell(0);
                double id = cell0.getNumericCellValue();
                HSSFCell cell1 = row.getCell(1);
                String name = cell1.getStringCellValue();
                HSSFCell cell2 = row.getCell(2);
                String psw = cell2.getStringCellValue();
                HSSFCell cell3 = row.getCell(3);
                String information = cell3.getStringCellValue();
                HSSFCell cell4 = row.getCell(4);
                String photo = cell4.getStringCellValue();
                HSSFCell cell5 = row.getCell(5);
                String school = cell5.getStringCellValue();
                user.setId((int)id);
                user.setName(name);
                user.setPsw(Encrypt.dealStr(psw, DataGlobe.key));
                user.setInformation(information);
                user.setPhoto(photo);
                user.setSchool(school);
                users.add(user);
            }
            list.addAll(users);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            fs.close();
        }
        return list;
    }
}
