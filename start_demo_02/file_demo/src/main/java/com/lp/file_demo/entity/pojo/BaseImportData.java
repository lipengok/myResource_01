package com.lp.file_demo.entity.pojo;

import lombok.Data;

/**
 * @Author lipeng
 * @Date 2022/7/11 15:20
 * @Version 1.0
 */
@Data
public class BaseImportData {
    // excel文件的详细路径
    private String xslName;

    // sheet的名称
    private String sheetName;
}
