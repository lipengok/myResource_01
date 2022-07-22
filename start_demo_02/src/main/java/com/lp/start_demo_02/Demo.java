package com.lp.start_demo_02;

import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;

/**
 * @Author lipeng
 * @Date 2022/7/4 16:16
 * @Version 1.0
 */
public class Demo {
    public static void main(String[] args) throws IOException {
        ClassPathResource classPathResource = new ClassPathResource("test.txt");
        System.out.println(System.getProperty("user.dir"));
        File file = classPathResource.getFile();
        System.out.println(file.getPath());

        File file1 = new File(System.getProperty("user.dir")+"/test.txt");
        System.out.println(file1.getPath());

        File file2 = ResourceUtils.getFile("classpath:application.properties");
        System.out.println(file2.getPath());
    }
}
