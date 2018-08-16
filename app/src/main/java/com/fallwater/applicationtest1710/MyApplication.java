package com.fallwater.applicationtest1710;

import com.blankj.utilcode.util.Utils;

import android.app.Application;

/**
 * @author Fallwater潘建波 on 2018/8/16
 * @mail 1667376033@qq.com
 * 功能描述:
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Utils.init(this);
    }
}
