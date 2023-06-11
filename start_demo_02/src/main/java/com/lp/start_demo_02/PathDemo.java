package com.lp.start_demo_02;

import java.io.File;

/**
 * @Author lipeng
 * @Date 2023/5/25 16:32
 * @Version 1.0
 */
public class PathDemo {

    public static void main(String[] args) {
        // 获取当前项目路径
        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);

    }

    private static void filePath(File file){
        // 获取文件的绝对路径
        String absolutePath = file.getAbsolutePath();
        System.out.println("绝对路径: " + absolutePath);

        // 获取文件的相对路径
        String relativePath = file.getPath();
        System.out.println("相对路径: " + relativePath);

        // 获取文件的父目录路径
        String parentPath = file.getParent();
        System.out.println("父目录路径: " + parentPath);
    }
}
