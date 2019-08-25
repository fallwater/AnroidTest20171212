package com.fallwater.applicationtest1710.test;

import com.fallwater.applicationtest1710.activity.Const;

import android.util.Log;

/**
 * @author Fallwater潘建波
 * 版权 akulaku
 * 时间 2019-08-19
 * 描述
 */
public class ClassChild {

    static {
        Log.d(Const.TAG,"ClassChild static 代码块");
    }

    {
        Log.d(Const.TAG,"ClassChild 代码块");

    }

    public ClassChild(){
        Log.d(Const.TAG,"ClassChild 构造方法");

    }

}
