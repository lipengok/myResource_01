package com.lp.file_demo.files.base;

import com.alibaba.fastjson2.JSONObject;
import com.lp.file_demo.globe.DataGlobe;
import com.lp.file_demo.globe.ExceptionGlobe;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 文件上传
 * @Author lipeng
 * @Date 2022/7/12 14:17
 * @Version 1.0
 */
public class FileUpload {

    // todo 文件上传到oss-仅上传图片

    // todo 文件上传到数据库-仅上传内容较小的纯文本

    // 文件上传到服务器
    public boolean serverUpload(MultipartFile file) throws Exception {
        boolean flag = false;
        if (file == null || file.isEmpty()) {
            throw new Exception(ExceptionGlobe.NO_SELECT_FILE_EXCEPTION);
        }

        String filePath = new File(DataGlobe.uploadPath).getAbsolutePath();
        File fileUpload = new File(filePath);
        if (!fileUpload.exists()) {
            fileUpload.mkdirs();
        }

        fileUpload = new File(filePath, file.getOriginalFilename());
        if (fileUpload.exists()) {
            throw new Exception(ExceptionGlobe.FILE_HAVE_EXCEPTION);
        }

        try {
            file.transferTo(fileUpload);
            flag = true;
        } catch (IOException e) {
            throw new Exception(ExceptionGlobe.FILE_UPLOAD_EXCEPTION + e.toString());
        }
        return flag;
    }

}
