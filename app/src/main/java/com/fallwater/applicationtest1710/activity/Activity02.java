package com.fallwater.applicationtest1710.activity;

import com.fallwater.applicationtest1710.R;
import com.fallwater.applicationtest1710.base.BaseActivity;
import com.fallwater.applicationtest1710.fragment.BRVAHFragment;
import com.fallwater.applicationtest1710.fragment.RVFragment;
import com.fallwater.applicationtest1710.test.SparseArrayTest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

/**
 * @author Fallwater潘建波 on 2017/12/22
 * @mail 1667376033@qq.com
 * 功能描述:
 */
public class Activity02 extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        addFragment();
//        testArray();
        addBRVAHFragment();


    }

    /**
     * 测试BRVAH框架
     */
    private void addBRVAHFragment() {
        Fragment fragment = new BRVAHFragment();
        addFragment(fragment);
    }

    /**
     * 测试sparseArray
     */
    private void testArray() {
//        new SparseArrayTest().test();
        new SparseArrayTest().arrayMap();
    }

    /**
     * 测试addItemDecoration
     */
    private void addFragment() {
        Fragment fragment = new RVFragment();
        addFragment(fragment);

    }

    private void addFragment(Fragment fragment) {
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_02;
    }
}
