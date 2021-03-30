package com.huade.utils;

import org.springframework.util.DigestUtils;

public class UtilsTools {

    /**
     * Spring提供的MD5加密方法
     * 将字符串转化为 32 位的MD5字符串
     * @param str 需要加密的字符串
     * @return String 加密后的MD5字符串
     */
    public static String Encrypted_MD5(String str){
        return DigestUtils.md5DigestAsHex(str.getBytes());
    }


    /**
     * 随机生成密码
     * 生成的密码共6位数字
     * @return String RandomPassword
     */
    public static String RandomPassword(){
        StringBuilder RandomPassword = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            int num = (int) (Math.random() * 99) + 1;
            if (num < 10)
                RandomPassword.append(0);
            RandomPassword.append(num);
        }
        return RandomPassword.toString();
    }

    /**
     * 随机生成课程编号
     * 课程编号共10位 2位大写字母 + 8位随机数字（例如'TC75491231'）
     * @return String cou_Id
     */
    public static String RandomCourseId(){
        String[] arr = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        StringBuilder CourseId = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            CourseId.append(arr[(int) ((Math.random())*26)]);
        }
        for (int i = 0; i < 4; i++) {
            int num = (int) (Math.random() * 99) + 1;
            if (num < 10)
                CourseId.append(0);
            CourseId.append(num);
        }
        return CourseId.toString();
    }

    /**
     * 字符串转字符数组
     * @param str 数组
     * @return String
     */
    public static String[] StringToStringArr(String str){
        return str.split(",");
    }

}
