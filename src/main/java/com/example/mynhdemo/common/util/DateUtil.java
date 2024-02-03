package com.example.mynhdemo.common.util;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
/**
 * @author xiadewang
 */
public class DateUtil {
    /**
     * 得到系统当前日期
     * "yyyyMMdd"
     */
    public static String getCurentDate() {
        SimpleDateFormat tempDate = new SimpleDateFormat("yyyyMMdd");
        String datetime = tempDate.format(new Date());
        return datetime;
    }

/*    public static void main(String[] args) throws ParseException {
        DateFormat beijingFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        beijingFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));

//        Date date = beijingFormat.parse("20120815225602");

        DateFormat utcFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        utcFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

        System.out.println(utcFormat.format(new Date()));
    }*/

    /**
     * 获取utc时间戳字符串
     * @param date 北京时间
     * @return
     */
    public static String getUtcTimeString(Date date){
        DateFormat utcFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        utcFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return utcFormat.format(date);
    }

    /**
     * 获取当前时间戳精确到毫秒
     * @return
     */
    public static String getCurrnetTimeMs(){
        return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
    }
}

