package com.lp.file_demo.entity.pojo;

import com.lp.file_demo.entity.Student;
import lombok.Data;

import java.util.List;

/**
 * @Author lipeng
 * @Date 2022/7/11 9:16
 * @Version 1.0
 */
@Data
public class ExportData {
    // 导出的数据
    private List<Student> students;
    // 导出的文件名
    private String fileName;
    // 导出的excel表格的sheet名字
    private String sheetName;
}
