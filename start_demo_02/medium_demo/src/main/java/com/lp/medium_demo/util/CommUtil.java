package com.lp.medium_demo.util;

import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;

/**
 * @Author lipeng
 * @Date 2023/4/17 9:02
 * @Version 1.0
 */
public class CommUtil {

    /**
     * 根据项目内路径获取文件
     *
     * @param classPath
     * @return
     * @throws IOException
     */
    public static File getFile(String classPath) throws IOException {
        ClassPathResource classPathResource = new ClassPathResource(classPath);
        return classPathResource.getFile();
    }
}
