package com.lp.file_demo.service;

import com.lp.file_demo.entity.User;
import com.lp.file_demo.entity.pojo.BaseExportData;
import com.lp.file_demo.entity.pojo.BaseImportData;
import com.lp.file_demo.files.excel.export.UserExportExcel;
import com.lp.file_demo.globe.ExceptionGlobe;
import com.lp.file_demo.globe.InfoGlobe;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author lipeng
 * @Date 2022/7/11 14:15
 * @Version 1.0
 */
@Service
public class UserService {
    private final static Logger logger = Logger.getLogger(UserService.class);
    UserExportExcel userExportExcel = new UserExportExcel();

    // user导出excel表格
    public boolean exportExcel(BaseExportData<User> baseExportData) throws Exception {
        List<User> users = baseExportData.getList();
        String exportName = baseExportData.getFileName();
        String sheetNAme = baseExportData.getSheetName();
        boolean res = false;
        try {
            logger.info(InfoGlobe.EXPORT_INFO);
            logger.debug("【表格】=>"+exportName+"【sheet】=>"+sheetNAme+"【users】=>"+users);
            res = userExportExcel.export(users, exportName, sheetNAme);
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception(ExceptionGlobe.EXPORT_DEFAULT);
        }
        return res;
    }

    // todo excel表格导入user
    public List<User> importExcel(BaseImportData baseImportData){
        return null;
    }
}
