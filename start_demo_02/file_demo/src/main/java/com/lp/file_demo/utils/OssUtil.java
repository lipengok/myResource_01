package com.lp.file_demo.utils;

import com.aliyun.oss.OSSClient;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.ByteArrayInputStream;
import java.io.File;

/**
 * @Author lipeng
 * @Date 2022/7/13 8:48
 * @Version 1.0
 */
@Data
@Configuration
@PropertySource("classpath:aliyun.properties")
public class OssUtil {

    @Value("${accessKeyId}")
    private String accessKeyId;

    @Value("${accessKeySecret}")
    private String accessKeySecret;

    @Value("${bucketName}")
    private String bucketName;

    @Value("${endpoint}")
    private  String  endPoint ;

    @Value("${urlPrefix}")
    private  String  urlPrefix ;

    //文件直接上传的方式，filename 为定义的文件名字
    public void upload(File obj, String fileName) {
        OSSClient ossClient = null;
        try {
            ossClient = new OSSClient(endPoint, accessKeyId, accessKeySecret);
            ossClient.putObject(bucketName, fileName, obj);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ossClient != null)
                ossClient.shutdown();
        }
    }


    //文件字节方式进行上传，filename 为定义的文件名字
    public void upload(byte[] array, String fileName) {
        long start = System.currentTimeMillis();
        OSSClient ossClient = null;
        try {
            ossClient = new OSSClient(endPoint, accessKeyId, accessKeySecret);
            ossClient.putObject(bucketName, fileName, new ByteArrayInputStream(array));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ossClient != null)
                ossClient.shutdown();
            System.out.println("上传时间：{}ms"+(System.currentTimeMillis() - start));
        }
    }

}
