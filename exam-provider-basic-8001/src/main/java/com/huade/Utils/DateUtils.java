package com.huade.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    /**
     * 获取当前时间
     * @return Date
     */
    public static Date getNow(){
        Date date_now = new Date();
        return date_now;
    }

    /**
     * 获取当前时间String
     * @return String
     */
    public static String getNow_String(){
        Date date=new Date();   //这里的时util包下的
        SimpleDateFormat temp=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  //这是24时
        String Date=temp.format(date);
        return Date;
    }

}
