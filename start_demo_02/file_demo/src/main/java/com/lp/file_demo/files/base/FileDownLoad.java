package com.lp.file_demo.files.base;

import com.lp.file_demo.globe.DataGlobe;
import com.lp.file_demo.globe.ExceptionGlobe;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

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

    /**
     * oss远端文件资源下载到本地
     * oss文件下载，直接访问上传后返回的url路径
     * @return
     * @throws Exception
     */
    public List<String> ossDownload() throws Exception {
        // todo 从数据库里面查询oss上传的url列表
        return null;
    }
}
