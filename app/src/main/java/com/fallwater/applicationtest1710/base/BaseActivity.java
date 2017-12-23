package com.fallwater.applicationtest1710.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author Fallwater潘建波 on 2017/12/15
 * @mail 1667376033@qq.com
 * 功能描述:
 */
public abstract class BaseActivity extends AppCompatActivity {

    Unbinder mUnBinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        mUnBinder = ButterKnife.bind(this);
    }

    protected abstract int initLayout();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnBinder.unbind();
    }
}
