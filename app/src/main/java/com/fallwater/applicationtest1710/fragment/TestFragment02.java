package com.fallwater.applicationtest1710.fragment;

import com.fallwater.applicationtest1710.R;
import com.fallwater.applicationtest1710.view.View01;
import com.fallwater.applicationtest1710.view.ViewGroup01;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author Fallwater潘建波 on 2018/1/25
 * @mail 1667376033@qq.com
 * 功能描述:
 */
public class TestFragment02 extends BaseFragment {

//    @BindView(R.id.view)
//    View01 mView;
//
//    @BindView(R.id.viewGroup)
//    ViewGroup01 mViewGroup;

    Unbinder unbinder;

    @Override
    protected void initData() {

        String numbers
                = "Ma xac nhan: 19742 Akulaku yeu cau ma xac nhan khong vi cac muc dich khac, vui long khong tiet lo ma xac nhan.";
        String result = numbers.replaceAll("[^0-9]", "");
        Log.d("tag", result.substring(0, 5));

    }

    @Override
    protected void initView(View rootView, Bundle savedInstanceState) {

    }


    @Override
    protected int initLayout() {
        return R.layout.fragment_test02;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
