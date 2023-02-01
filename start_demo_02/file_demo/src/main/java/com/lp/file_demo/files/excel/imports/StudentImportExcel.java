package com.lp.file_demo.files.excel.imports;

import com.lp.file_demo.entity.Student;
import com.lp.file_demo.globe.DataGlobe;
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
 * student表的excel表格导入
 * @Author lipeng
 * @Date 2022/7/11 11:17
 * @Version 1.0
 */
public class StudentImportExcel {

    public List<Student> imports(String xslName, String sheetName) throws IOException {
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
            List<Student> students = new ArrayList<>();

            //遍历获取单元格里的信息
            for (int i = 2; i <=hs.getLastRowNum(); i++) {
                Student student = new Student();
                HSSFRow row=hs.getRow(i);
                HSSFCell cell1 = row.getCell(1);
                String stuNo = cell1.getStringCellValue();
                HSSFCell cell2 = row.getCell(2);
                String name = cell2.getStringCellValue();
                HSSFCell cell3 = row.getCell(3);
                String sex = cell3.getStringCellValue();
                HSSFCell cell4 = row.getCell(4);
                double age = cell4.getNumericCellValue();
                HSSFCell cell5 = row.getCell(5);
                String grade = cell5.getStringCellValue();
                HSSFCell cell6 = row.getCell(6);
                String stuClass = cell6.getStringCellValue();
                HSSFCell cell7 = row.getCell(7);
                double score1 = cell7.getNumericCellValue();
                HSSFCell cell8 = row.getCell(8);
                double score2 = cell8.getNumericCellValue();
                HSSFCell cell9 = row.getCell(9);
                double score3 = cell9.getNumericCellValue();
                HSSFCell cell10 = row.getCell(10);
                double score = cell10.getNumericCellValue();
                student.setStuNo(stuNo);
                student.setName(name);
                student.setSex(sex);
                student.setAge((int) age);
                student.setStuGrade(grade);
                student.setStuGrade(stuClass);
                student.setScore1(score1);
                student.setScore2(score2);
                student.setScore3(score3);
                student.setScore(score);
                students.add(student);
            }
            list.addAll(students);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            fs.close();
        }
        return list;
    }
}
