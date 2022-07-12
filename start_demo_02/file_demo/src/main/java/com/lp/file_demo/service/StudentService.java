package com.lp.file_demo.service;

import com.lp.file_demo.entity.Student;
import com.lp.file_demo.files.excel.export.StudentExportExcel;
import com.lp.file_demo.files.excel.imports.StudentImportExcel;
import com.lp.file_demo.globe.ExceptionGlobe;
import com.lp.file_demo.globe.InfoGlobe;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * @Author lipeng
 * @Date 2022/7/11 9:45
 * @Version 1.0
 */
@Service
public class StudentService {
    private final static Logger logger = Logger.getLogger(StudentService.class);
    StudentExportExcel studentExportExcel = new StudentExportExcel();
    StudentImportExcel studentImportExcel = new StudentImportExcel();

    // 导出
    public boolean exportStudent(List<Student> students, String exportName, String sheetNAme) throws Exception {
        boolean res = false;
        try {
            res = studentExportExcel.export(students, exportName, sheetNAme);
            logger.info(InfoGlobe.EXPORT_INFO);
            logger.debug("【表格】=>"+exportName+"【sheet】=>"+sheetNAme+"【students】=>"+students);
        }catch (Exception e){
            throw new Exception(ExceptionGlobe.EXPORT_DEFAULT);
        }
        return res;
    }

    // 导入
    public List<Student> importStudent(String exportName, String sheetName) throws IOException {
        return studentImportExcel.imports(exportName, sheetName);
    }
}
