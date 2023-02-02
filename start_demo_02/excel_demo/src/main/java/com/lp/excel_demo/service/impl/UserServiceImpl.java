package com.lp.excel_demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lp.excel_demo.entity.User;
import com.lp.excel_demo.globe.ParamGlobe;
import com.lp.excel_demo.mapper.UserMapper;
import com.lp.excel_demo.service.UserService;
import com.lp.excel_demo.utils.Encrypt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author lipeng
 * @Date 2022/11/3 11:32
 * @Version 1.0
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private UserMapper userMapper;

    /**
     * 批量插入数据
     *
     */
    public void batchUsers(List<User> list){
        try {
            log.info("正在插入数据[{}]", list);
            userMapper.batchInsert(list);
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }

    /**
     * 获取所有的用户信息，密码加密
     *
     * @return
     */
    public List<User> listEncryptPwd(){
        List<User> list = this.list();
        for (User user : list) {
            user.setPsw(Encrypt.dealStr(user.getPsw(), ParamGlobe.salt));
        }
        return list;
    }
}
