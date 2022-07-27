package com.lp.login_jwt.service.impl;

import com.lp.login_jwt.model.dto.UserTokenDto;
import com.lp.login_jwt.model.entity.User;
import com.lp.login_jwt.model.vo.UserLoginVo;
import com.lp.login_jwt.model.vo.UserUpdatePswVo;
import com.lp.login_jwt.repository.UserRepository;
import com.lp.login_jwt.service.UserService;
import com.lp.login_jwt.util.JWTUtil;
import com.lp.login_jwt.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author lipeng
 * @Date 2022/7/27 13:57
 * @Version 1.0
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private UserRepository userRepository;

    @Override
    public String login(UserLoginVo userLoginVo) throws Exception{
        // 根据用户名查询用户
        String userName = userLoginVo.getName();
        String psw = userLoginVo.getPsw();
        List<User> list = userRepository.getUserByName(userName);
        User user = null;
        if (null == list){
            throw new Exception("登录失败：未查询到用户信息");
        }
        if (list.size() == 1){
            user = list.get(0);
        }else {
            throw new Exception("登录失败：查询到多条用户信息，用户名违法");
        }
        if (!psw.equals(user.getPsw())){
            throw new Exception("登录失败：用户名密码错误");
        }
        // 根据用户id和当前时间生成token
        Integer id = user.getId();
        UserTokenDto userTokenDto = new UserTokenDto();
        userTokenDto.setCreateTime(System.currentTimeMillis());
        userTokenDto.setUserId((long)id);
        String token = JWTUtil.generateToken(userTokenDto);

        // 将token存储到redis
        redisUtil.set(String.valueOf(id), token);
        return token;
    }

    @Override
    public boolean loginOut(Integer userId){
        boolean res = false;
        try {
            redisUtil.delete(String.valueOf(userId));
            res = true;
        }catch (Exception e){
            log.error("退出登陆失败：redis操作有问题", e);
        }
        return res;
    }

    @Override
    public String updatePsw(UserUpdatePswVo userUpdatePswVo) throws Exception {
        // 根据用户名查询用户
        String userName = userUpdatePswVo.getName();
        String psw = userUpdatePswVo.getPsw();
        List<User> list = userRepository.getUserByName(userName);
        User user = null;
        if (null == list){
            log.error("密码修改失败：未查询到用户信息");
        }
        if (list.size() == 1){
            user = list.get(0);
        }else {
            log.error("密码修改失败：查询到多条用户信息，用户名违法");
        }
        if (psw != user.getPsw()){
            log.error("密码修改失败：用户名密码错误");
        }
        // 修改密码，生成新token
        Integer id = user.getId();
        String newPsw = userUpdatePswVo.getNewPsw();
        try {
            userRepository.updateByName(userName, newPsw);
        }catch (Exception e){
            log.error("密码修改失败：操作数据库失败", e);
        }
        UserTokenDto userTokenDto = new UserTokenDto();
        userTokenDto.setCreateTime(System.currentTimeMillis());
        userTokenDto.setUserId((long)id);
        String token = JWTUtil.generateToken(userTokenDto);

        // 将token存储到redis
        redisUtil.set(String.valueOf(id), token);

        return token;
    }
}
