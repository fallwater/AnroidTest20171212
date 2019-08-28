package com.fallwater.applicationtest1710.mudule.algorithm;

import com.fallwater.applicationtest1710.define.Tag;

import android.util.Log;

/**
 * @author Fallwater潘建波
 * 版权 akulaku
 * 时间 2019-08-25
 * 描述
 */
public class Algorithm {

    //最长回文字符串
    public static String longestPalindrome() {
        //cbbd  abadd
        String s = "abcdbbfcba";
        Log.d(Tag.TAG, "input:" + s);
        if (s == null || s.length() <= 1) {
            return s;
        }
        int left = 0;
        int offset = 0;
        int right = 0;

        int desLeft = left;
        int desRight = right;
        int desOffset = offset;
        for (; left < s.length(); left++,right++,offset = 0) {
            //当前位置和下一位置字符相同
            if (left < s.length() - 1 && s.substring(left, left + 1).equals(s.substring(left + 1, left + 2))) {
                right = left + 1;
                if (count(desLeft,desRight,desOffset)< count(left,right,offset)) {
                    desLeft = left;
                    desRight = right;
                    desOffset = offset;
                }

                for (int i = 1; i <= left; i++) {
                    if (right + i == s.length()) {
                        break;
                    }

                    if (s.substring(left - i, left - i + 1).equals(s.substring(right + i, right + i + 1))) {
                        offset = i;
                        Log.d(Tag.TAG, "offset:" + offset + ",left:" + left + ",right:" + right);
                        Log.d(Tag.TAG, "1 find Palindrome=" + s.substring(left - offset, right + offset + 1));
                        if (count(desLeft,desRight,desOffset)< count(left,right,offset)) {
                            desLeft = left;
                            desRight = right;
                            desOffset = offset;
                        }
                    }else {
                        break;
                    }
                }
            }

            for (int i = 1; i <= left; i++) {
                if (left + i == s.length()) {
                    break;
                }
                if (s.substring(left - i, left - i + 1).equals(s.substring(left + i, left + i + 1))) {
                    offset = i;
                    Log.d(Tag.TAG, "offset:" + offset + ",left:" + left );
                    Log.d(Tag.TAG, "2 find Palindrome=" + s.substring(left - offset, left + offset + 1));

                    if ( count(desLeft,desRight,desOffset)< count(left,left,offset)) {
                        desLeft = left;
                        desRight = left;
                        desOffset = offset;
                    }

                } else {

                    break;
                }
            }
        }
        String result = s.substring(desLeft - desOffset, desRight + desOffset + 1);

        Log.d(Tag.TAG, "longestPalindrome=" + result);

        return result;
    }

    public static int count(int left,int right,int offset){
        if (left == right){
            return 1+2*offset;
        }

        return 2+2*offset;
    }

}
