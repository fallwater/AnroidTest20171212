package com.fallwater.applicationtest1710.utils;

import android.text.TextUtils;
import android.widget.EditText;

/**
 * Created with Android Studio
 * Author:zhangjianliang
 * Date:2017/8/8
 */

public class StringUtil {

    /**
     * 判断字符串是否为空
     */
    public static boolean isEmpty(String content) {
        return (content == null || content.trim().equals("") || content.trim().equals("null"));
    }

    /**
     * 避免空指针异常
     */
    public static boolean contains(String string, String cs) {
        if (isEmpty(string) || isEmpty(cs)) {
            return false;
        }
        return string.contains(cs);
    }

    /**
     * 判断字符串中是否是空值，不是空则返回传入的字符串
     */
    public static String getNotNullStr(String content) {
        return isEmpty(content) ? "" : content;
    }

    public static String getMaskPassword(String content) {
        if (TextUtils.isEmpty(content)) {
            return "";
        }
        String result = content.replaceAll("\\w", "*");
        return result;
    }

    /**
     * 显示后四位，其他显示*
     */
    public static String getMaskPhoneNo(String phoneNo) {
        if (TextUtils.isEmpty(phoneNo) || phoneNo.length() <= 4) {
            return phoneNo;
        }
        String result = "";
        try {
            result = phoneNo.substring(0, phoneNo.length() - 4).replaceAll("\\w", "*") + phoneNo
                    .substring(phoneNo.length() - 4);
        } catch (Exception e) {
        }
        return StringUtil.isEmpty(result) ? "" : result;
    }

    /**
     * 1234********5678
     * 显示头四位和末四位，其他显示*
     */
    public static String getMaskAccount(String account) {
        if (TextUtils.isEmpty(account) || account.length() <= 8) {
            return account;
        }
        String result = "";
        try {
            result = account.substring(0, 4) + account.substring(4, account.length() - 4).replaceAll("\\w", "*")
                    + account.substring(account.length() - 4);
        } catch (Exception e) {
        }
        return StringUtil.isEmpty(result) ? "" : result;
    }

//    public static String getString(int resId) {
//        return MyApplication.getInstance().getString(resId);
//    }
//
//    public static String getString(int resId, Object... formatArgs) {
//        return MyApplication.getInstance().getString(resId, formatArgs);
//    }

    /**
     * 每4位添加一个空格
     */
    public static String addSpeaceByCredit(String content) {
        if (TextUtils.isEmpty(content)) {
            return "";
        }
        content = content.replaceAll(" ", "");
        if (TextUtils.isEmpty(content)) {
            return "";
        }
        StringBuilder newString = new StringBuilder();
        for (int i = 1; i <= content.length(); i++) {
            if (i % 4 == 0 && i != content.length()) {
                newString.append(content.charAt(i - 1) + " ");
            } else {
                newString.append(content.charAt(i - 1));
            }
        }
        return newString.toString();
    }

    /** 是否符合四位空一格的格式 */
    public static boolean isSpaceFormatNumber(String number) {
        if (TextUtils.isEmpty(number) || number.length() <= 4) {
            return true;
        }
        String[] splits = number.split(" ");//用空格截断后，判断各个碎片是否符合规则
        if (splits.length == 0) {
            return false;
        }
        for (int i = 0; i < splits.length; i++) {
            String segment = splits[i];
            if (TextUtils.isEmpty(segment) && i != splits.length - 1) {//非最后一节不能为空
                return false;
            }
            if (segment.contains(" ")) {//碎片中不能有空格
                return false;
            }
            if (i == splits.length - 1) {//最后一节字符数不能超过4
                return segment.length() <= 4;
            } else if (segment.length() != 4) {//非最后一节字符数必须等于4
                return false;
            }
        }
        return true;
    }

    public static String getTextTrim(EditText text) {
        return text.getText().toString().replaceAll(" ", "");
    }

    public static String getText(EditText text) {
        return text.getText().toString();
    }
}
