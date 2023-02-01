package com.lp.excel_demo.excel.imp;

import com.alibaba.excel.EasyExcel;
import com.lp.excel_demo.entity.User;
import com.lp.excel_demo.excel.imp.listener.ExcelImportListener;
import com.lp.excel_demo.mapper.BatchInsertMapper;
import com.lp.excel_demo.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * 导入excel文件
 *
 * @Author lipeng
 * @Date 2023/2/1 10:01
 * @Version 1.0
 */
@Slf4j
@Component
public class ExcelImport {

    @Resource
    private UserMapper userMapper;

    /**
     * Excel文件分批导入数据库
     *
     * @param file 上传的文件
     * @throws IOException 读取文件异常
     */
    public void importPersonFile(MultipartFile file) throws IOException {
        log.info("开始进行文件导入");
        EasyExcel.read(file.getInputStream())
                .head(User.class)
                .registerReadListener(new ExcelImportListener<User>() {
                    @Override
                    protected BatchInsertMapper<User> getMapper() {
                        return userMapper;
                    }
                }).sheet().doRead();
        log.info("文件导入完成");
    }
}
