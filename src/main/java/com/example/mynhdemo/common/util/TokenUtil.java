package com.example.mynhdemo.common.util;


import org.springframework.util.DigestUtils;

/**token生成工具类
 * @author xiadewang
 */
public class TokenUtil {
    public static String generateTokenValue(String clientType,long userid,String password){
        String originalTokenValue = userid+clientType+password+DateUtil.getCurrnetTimeMs();
        return DigestUtils.md5DigestAsHex(originalTokenValue.getBytes());
    }
}

