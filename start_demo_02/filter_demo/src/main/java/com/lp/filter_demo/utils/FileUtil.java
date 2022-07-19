package com.lp.filter_demo.utils;

import java.io.*;

/**
 * @Author lipeng
 * @Date 2022/7/15 14:39
 * @Version 1.0
 */
public class FileUtil {

    /**
     * 输入流读取字符串
     * @param inputStream
     * @return
     * @throws IOException
     */
    public String readInputStream(InputStream inputStream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line = null;
        String res = "";
        while ((line = reader.readLine()) != null) {
            res += line;
        }
        return res;
    }

    /**
     * 带有后缀名的文件路径
     * @param path
     * @return
     */
    public File createFile(String path) throws IOException {
        File file = new File(path);
        if (!file.exists()){
            if (file.isDirectory()){
                file.mkdirs();
            }else {
                file.createNewFile();
            }
        }
        return file;
    }
}
