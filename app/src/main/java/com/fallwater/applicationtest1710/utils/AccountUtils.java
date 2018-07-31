package com.fallwater.applicationtest1710.utils;

import android.support.annotation.NonNull;
import android.text.TextUtils;

/**
 * @author Fallwater潘建波 on 2018/7/31
 * @mail 1667376033@qq.com
 * 功能描述:
 */
public class AccountUtils {
    /**
     * 产品规定显示的固定位数
     */
    private final static int FIX_LENGTH = 16;

    /**
     * [姓名]
     * 1. 16位字符；
     * 2. 显示第一个单词，后面全部显示*（例如：pan jian bo -> pan*************）
     * 3. 当第一个单词过长>=显示长度，
     * 或者只有一个单词的时候，显示第一个单词的一半（可多取一位字符），其余位数用*补齐
     * （例如：Akulaku->Akul************）
     */
    public static String maskAccountName(String accountName) {
        if (TextUtils.isEmpty(accountName)) {
            return "";
        }
        String result;
        String[] words = accountName.split("\\s+");
        //只有一个单词的时候
        if (words.length == 1) {
            int length = accountName.length();
            if (length>FIX_LENGTH){
                length = FIX_LENGTH;
            }
            result = StringUtil.mask(accountName, half(length), 0);
            return forString2(result);
        }

        String maskName = "";
        int firstWordIndex = -1;
        for (int i = 0; i < words.length; i++) {
            if (!TextUtils.isEmpty(words[i]) && firstWordIndex == -1) {
                //当第一个单词过长>=显示长度，
                if (words[i] != null && words[i].length() >= FIX_LENGTH) {
                    int length = words[i].length();
                    if (length>FIX_LENGTH){
                        length = FIX_LENGTH;
                    }
                    return forString2(StringUtil.mask(accountName, half(length), 0));
                }

                maskName = maskName + words[i];
                firstWordIndex = i;
                continue;
            }
            if (i > firstWordIndex && firstWordIndex != -1) {
                maskName = maskName + StringUtil.mask(words[i], 0, 0);
            }
        }
        return forString2(maskName);
    }

    /**
     * [账号]
     * 1. 16位字符；
     * 2. 显示后4位，前面全部用*(例如：************1234)
     * 3. 如果账号不足4位，显示最后一位，前面全部*(例如：***************4)
     */
    public static String maskAccountNumber(String accountNumber) {
        if (TextUtils.isEmpty(accountNumber)) {
            return "";
        }

        String result;
        if (accountNumber.length() <= 4) {
            result = StringUtil.mask(accountNumber, 0, 1);
        } else {
            result = StringUtil.mask(accountNumber, 0, 4);
        }
        return forString(result);
    }

    @NonNull
    private static String forString(String accountNumber) {
        if (accountNumber.length() <= FIX_LENGTH) {
            StringBuilder builder = new StringBuilder(accountNumber);
            for (int i = 0; i < FIX_LENGTH - accountNumber.length(); i++) {
                builder.insert(0,"*");
            }
            return builder.toString();
        }

        return accountNumber.substring(accountNumber.length() - FIX_LENGTH, accountNumber.length());
    }

    @NonNull
    private static String forString2(String accountNumber) {
        if (accountNumber.length() <= FIX_LENGTH) {
            StringBuilder builder = new StringBuilder(accountNumber);
            for (int i = 0; i < FIX_LENGTH - accountNumber.length(); i++) {
                builder.append("*");
            }
            return builder.toString();
        }

        return accountNumber.substring(0, FIX_LENGTH);
    }

    private static int half(double number) {
        return (int) Math.round(number / 2);
    }
}
