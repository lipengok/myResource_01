package com.lp.login_jwt.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Verification;
import com.lp.login_jwt.model.dto.UserTokenDto;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author lipeng
 * @Date 2022/7/27 10:48
 * @Version 1.0
 */
@Slf4j
public class JWTUtil {

    // 私钥定义
    private static final String TOKEN_SECRET = "123456";

    /**
     * 生成token，设置过期时间
     * @param userTokenDto
     * @return
     */
    public static String generateToken(UserTokenDto userTokenDto){
        String token = null;
        try {
            // 设置私钥和加密算法
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            //设置头部信息
            Map head = new HashMap<String, Object>();
            head.put("type","JWT");
            head.put("algorithm", "HMAC256");
            token = JWT.create()
                    .withHeader(head)
                    .withClaim("token", JSON.toJSONString(userTokenDto))
                    .sign(algorithm);
        }catch (Exception e){
            log.error("生成token失败", e);
        }
        return token;
    }

    /**
     * 解析tocken
     * @param token
     * @return
     */
    public static UserTokenDto parseToken(String token){
        // 设置私钥和加密算法
        Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
        String tokenJson = JWT.require(algorithm).build().verify(token).getToken();
        return JSON.parseObject(tokenJson, UserTokenDto.class);
    }
}
