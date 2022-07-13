package com.lp.file_demo.files.base;

import com.alibaba.fastjson2.JSONObject;
import com.lp.file_demo.globe.DataGlobe;
import com.lp.file_demo.globe.ExceptionGlobe;
import com.lp.file_demo.utils.OssUtil;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * 文件上传
 * @Author lipeng
 * @Date 2022/7/12 14:17
 * @Version 1.0
 */
public class FileUpload {
    // 文件上传到oss-仅上传压缩文件
    public String ossUploadCompressFile(MultipartFile file) throws Exception {
        OssUtil ossUtil = new OssUtil();
        String[] suffixes = {".zip", ".rar", ".gz", ".iso"};
        if (file.isEmpty()){
            throw new Exception(ExceptionGlobe.NO_FILE_EXCEPTION);
        }
        // 仅仅上传压缩文件
        if (!checkFileSuffix(file, suffixes)){
            throw new Exception(ExceptionGlobe.FILE_MUST_IMAGE);
        }
        String filePath = getFilePath(file, "compress");
        ossUtil.upload(file.getBytes(),filePath);
        // todo 文件路径入数据库
        return ossUtil.getUrlPrefix()+filePath;
    }

    // 文件上传到oss-仅上传图片
    public String ossUploadImg(MultipartFile file) throws Exception {
        OssUtil ossUtil = new OssUtil();
        String[] suffixes = {".jpg", ".jpeg", ".gif", ".png"};
        if (file.isEmpty() || null == file){
            throw new Exception(ExceptionGlobe.NO_FILE_EXCEPTION);
        }
        // 仅仅上传图片
        if (!checkFileSuffix(file, suffixes)){
            throw new Exception(ExceptionGlobe.FILE_MUST_IMAGE);
        }
        String filePath = getFilePath(file, "img");
        ossUtil.upload(file.getBytes(),filePath);
        // todo 文件路径入数据库
        return ossUtil.getUrlPrefix()+filePath;
    }

    /**
     * 获取文件路径
     * @param file 文件object
     * @param fileDir 文件所在文件夹
     * @return
     */
    private String getFilePath(MultipartFile file, String fileDir){
        String fileName = file.getOriginalFilename();
        Date date = new Date();
        String filePath = fileDir+"/"
                +(date.getYear()+1900)+"/"
                +(date.getMonth()+1)+"/"
                +Math.random()*100
                +fileName.toLowerCase();
        return filePath;
    }
    /**
     * 判断文件后缀是否在后缀数组范围内
     * @param file
     * @param suffixes 后缀数组
     * @return
     */
    public boolean checkFileSuffix(MultipartFile file, String[] suffixes){
        boolean compressFlag = false;
        for (String suffix : suffixes) {
            if (file.getOriginalFilename().toLowerCase().endsWith(suffix)){
                compressFlag = true;
                break;
            }
        }
        return compressFlag;
    }

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
