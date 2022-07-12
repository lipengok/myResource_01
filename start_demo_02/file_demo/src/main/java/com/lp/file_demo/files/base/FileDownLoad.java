package com.lp.file_demo.files.base;

import com.lp.file_demo.globe.DataGlobe;
import com.lp.file_demo.globe.ExceptionGlobe;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * 文件下载
 * @Author lipeng
 * @Date 2022/7/12 14:17
 * @Version 1.0
 */
public class FileDownLoad {
    private String filePath = DataGlobe.basePath + "\\files\\file_demo\\logs\\";

    // 服务器文件下载到本地-一般是日志文件
    public void serverDownload(String name, HttpServletResponse response) throws Exception {
        // 文件资源位置
        File file = new File(filePath + name);

        if (!file.exists()) {
            throw new Exception(name + ExceptionGlobe.NO_FILE_EXCEPTION);
        }
        response.setContentType("application/force-download");
        response.addHeader("Content-Disposition", "attachment;fileName=" + name);

        byte[] buffer = new byte[1024];
        try (FileInputStream fis = new FileInputStream(file);
             BufferedInputStream bis = new BufferedInputStream(fis)) {

            OutputStream os = response.getOutputStream();

            int i = bis.read(buffer);
            while (i != -1) {
                os.write(buffer, 0, i);
                i = bis.read(buffer);
            }
        }
    }

    // oss远端文件资源下载到本地
    public void ossDownload(String name, HttpServletResponse response) throws Exception {
        // 文件资源位置
        File file = new File(name);

        if (!file.exists()) {
            throw new Exception(name + "文件不存在");
        }
        response.setContentType("application/force-download");
        response.addHeader("Content-Disposition", "attachment;fileName=" + name);

        byte[] buffer = new byte[1024];
        try (FileInputStream fis = new FileInputStream(file);
             BufferedInputStream bis = new BufferedInputStream(fis)) {

            OutputStream os = response.getOutputStream();

            int i = bis.read(buffer);
            while (i != -1) {
                os.write(buffer, 0, i);
                i = bis.read(buffer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
