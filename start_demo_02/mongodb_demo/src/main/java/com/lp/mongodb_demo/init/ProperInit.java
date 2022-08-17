package com.lp.mongodb_demo.init;

import com.lp.mongodb_demo.common.DbGlobe;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.Properties;

/**
 * 初始化配置文件
 * @Author lipeng
 * @Date 2022/8/17 16:12
 * @Version 1.0
 */
public class ProperInit {

    public static void initDbProperties() throws IOException {
        // 生产环境
        // String basePath = System.getProperty("user.dir");

        // 测试环境
        File file = ResourceUtils.getFile("classpath:db.properties");
        InputStream inputStream = new FileInputStream(file);
        Properties properties = new Properties();
        properties.load(inputStream);

        DbGlobe.dbNameUser = properties.getProperty("mongodb.db.user");
        DbGlobe.dbNameStu = properties.getProperty("mongodb.db.student");
    }
}
