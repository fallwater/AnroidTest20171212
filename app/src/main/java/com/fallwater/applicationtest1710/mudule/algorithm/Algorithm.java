package com.fallwater.applicationtest1710.mudule.algorithm;

import com.fallwater.applicationtest1710.define.Tag;

import android.util.Log;

import java.util.HashMap;

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

    /**
     *
     * @param nums
     * @param target
     * @return 和等于指定数的数组下标
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])){
                return new int[]{map.get(nums),i};

            }
            map.put(nums[i],i);
        }

        return null;
    }

    /**
     *
     * @param l1
     * @param l2
     * @return 两数相加
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode current = head;
        ListNode m = l1;
        ListNode n = l2;
        int carry = 0;
        while (m !=null || n!=null){
            int x = (m!=null)?m.val:0;
            int y = n!=null?n.val:0;
            int sum = carry+x+y;
            carry = sum /10;
            current.next = new ListNode(sum%10);

            m = m!=null?m.next:null;
            n = n!=null?n.next:null;
            current = current.next;
        }

        if (carry>0){
            current.next = new ListNode(carry);
        }

        return head.next;

    }

    /**
     *
     * @param s
     * @return 无重复字符的最长字串长度
     */
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>(s.length());
        int maxRepeat = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))){
                maxRepeat = maxRepeat <(i-map.get(s.charAt(i)))?(i-map.get(s.charAt(i)))
                :maxRepeat;

            }
            map.put(s.charAt(i),i);
        }

        return map.size() == s.length()?s.length():maxRepeat;

    }

}
