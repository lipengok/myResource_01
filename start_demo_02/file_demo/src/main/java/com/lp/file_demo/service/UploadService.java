package com.lp.file_demo.service;

import com.lp.file_demo.files.base.FileUpload;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author lipeng
 * @Date 2022/7/12 15:26
 * @Version 1.0
 */
@Service
public class UploadService {
    FileUpload fileUpload = new FileUpload();

    public boolean uploadServer(MultipartFile file) throws Exception {
        return fileUpload.serverUpload(file);
    }
}
