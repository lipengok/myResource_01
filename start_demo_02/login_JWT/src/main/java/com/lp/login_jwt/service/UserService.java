package com.lp.login_jwt.service;

import com.lp.login_jwt.model.vo.UserLoginVo;
import com.lp.login_jwt.model.vo.UserUpdatePswVo;

/**
 * @Author lipeng
 * @Date 2022/7/27 10:47
 * @Version 1.0
 */
public interface UserService {

    String login(UserLoginVo userLoginVo) throws Exception;

    boolean loginOut(Integer userId);

    String updatePsw(UserUpdatePswVo userUpdatePswVo) throws Exception;
}
