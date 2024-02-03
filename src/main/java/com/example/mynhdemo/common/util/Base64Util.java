package com.example.mynhdemo.common.util;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * @author xiadewang
 */
public class Base64Util {

    /**
     * 加密JDK1.8
     */
    public static String encode(String str) throws UnsupportedEncodingException {

        byte[] encodeBytes = Base64.getEncoder().encode(str.getBytes("utf-8"));
        return new String(encodeBytes);

    }

    public static String encode(byte[] str) {
        byte[] encodeBytes = Base64.getEncoder().encode(str);
        return new String(encodeBytes);
    }

    /**
     * 解密JDK1.8
     */
    public static String decode(String str) throws UnsupportedEncodingException {
        byte[] decodeBytes = Base64.getDecoder().decode(str.getBytes("utf-8"));
        return new String(decodeBytes);
    }

    /**
     * 加密JDK1.8
     */
    public static String encodeThrowsException(String str) throws UnsupportedEncodingException {
        byte[] encodeBytes = Base64.getEncoder().encode(str.getBytes("utf-8"));
        return new String(encodeBytes);
    }

    /**
     * 解密JDK1.8
     */
    public static String decodeThrowsException(String str) throws UnsupportedEncodingException {
        byte[] decodeBytes = Base64.getDecoder().decode(str.getBytes("utf-8"));
        return new String(decodeBytes);
    }

    public static void main(String[] args) throws Exception {


//        initKey();

        String datastr = "10-" + System.currentTimeMillis();
        System.out.println("待加密数据：\n" + datastr);

        long time = System.currentTimeMillis();
        //公匙加密
        String pubKeyStr = Base64Util.encode(datastr);
        System.out.println("公匙加密结果：\n" + pubKeyStr);
        System.out.println("公匙加密时间：\n" + (System.currentTimeMillis() - time));
        // 私匙解密
        String priKeyStr = Base64Util.decode(pubKeyStr);
        System.out.println("私匙解密结果：\n" + priKeyStr);
        time = System.currentTimeMillis();
        System.out.println("私匙解密时间：\n" + (System.currentTimeMillis() - time));
//
//        // 数字签名
//        String str1 = "汉兵已略地";
//        String str2 = "四面楚歌声";
//        System.out.println("正确的签名：" + str1 + "\n错误的签名：" + str2);
//        String sign = RSAUtils.sign(str1.getBytes(), pri_key);
//        System.out.println("数字签名：\n" + sign);
//        boolean vflag1 = das.verify(str1.getBytes(), Base64.decodeBase64(sign), pub_key);
//        System.out.println("数字签名验证结果1：\n" + vflag1);
//        boolean vflag2 = das.verify(str2.getBytes(), Base64.decodeBase64(sign), pub_key);
//        System.out.println("数字签名验证结果2：\n" + vflag2);

    }
}

