package com.lp.file_demo.globe;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * @Author lipeng
 * @Date 2022/7/11 14:04
 * @Version 1.0
 */
public class DataGlobe {
    // 项目的物理路径
    public static final String basePath = System.getProperty("user.dir");

    // 用户密码的密钥
    public static char key = 'a';

    // student的工作簿对象
    public static HSSFWorkbook wkStudent = null;

    // user的工作簿对象
    public static HSSFWorkbook wkUser = null;

    // 文件上传到服务器的根目录
    public static final String uploadPath = "uploads";

}
