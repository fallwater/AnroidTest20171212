package com.fallwater.applicationtest1710.utils;

import android.text.TextUtils;

/**
 * @author Fallwater潘建波 on 2018/8/22
 * @mail 1667376033@qq.com
 * 功能描述:
 */
public class CommonUtils {

    /**
     * 得到百分比字符创对应的值
     * @param percent -34%
     * @return -0.34
     */
    public static double getPercentValue(String percent){
        if (TextUtils.isEmpty(percent)||!percent.contains("%")){
            return 0;
        }
        String temp = percent.replaceAll("%","");
        double result = 0;
        try {
            result = Double.parseDouble(temp);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        return result*0.01;
    }

    /**
     * 比较百分比字符串的大小
     */
    public static boolean comparePercentString(String a,String b){
        return getPercentValue(a)<=getPercentValue(b);
    }

}
