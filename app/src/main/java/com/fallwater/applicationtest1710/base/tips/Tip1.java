package com.fallwater.applicationtest1710.base.tips;

import android.util.Log;

import java.util.Map;
import java.util.Random;

/**
 * @author Fallwater潘建波 on 2017/12/16
 * @mail 1667376033@qq.com
 * 功能描述:
 */
public class Tip1 {

    public static <K, V> void printMap(Map<K, V> map) {
        for (Map.Entry m : map.entrySet()) {
            Log.d("tag", m.getKey().toString() + m.getValue() + "");

        }

    }

    public static int random(int min, int max) {
        Random random = new Random();
        int randomNum = random.nextInt((max - min) + 1) + min;
        return randomNum;
    }

//    public static void printMap2(Map mp) {
//        for (Map.Entry m : mp.entrySet()) {
//            System.out.println(m.getKey() + ":" + m.getValue());
//        }
//    }



}
