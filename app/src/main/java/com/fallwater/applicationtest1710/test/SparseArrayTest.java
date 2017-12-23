package com.fallwater.applicationtest1710.test;

import android.util.ArrayMap;
import android.util.Log;
import android.util.SparseArray;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Fallwater潘建波 on 2017/12/23
 * @mail 1667376033@qq.com
 * 功能描述:
 */
public class SparseArrayTest {

    public void test(){
        SparseArray<String> sparseArray = new SparseArray<>();
        sparseArray.append(1,"1");
        sparseArray.append(2,"2");

        Log.d("tag",sparseArray.get(1));
        Log.d("tag",sparseArray.keyAt(0)+"");
        Log.d("tag",sparseArray.valueAt(0));
    }

    public void arrayMap(){
        ArrayMap<String,String> arrayMap = new ArrayMap<>(10);
//        HashMap<String,String> hashMap = new HashMap<>(10);
        arrayMap.put("key1","value1");
        arrayMap.put("key2","value2");
        for (Map.Entry entry:arrayMap.entrySet()){
            Log.d("tag",entry.getKey().toString());
            Log.d("tag",entry.getValue().toString());
        }
    }

}
