package com.fallwater.applicationtest1710.fragment;

import com.fallwater.applicationtest1710.R;

import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author Fallwater潘建波 on 2018/1/25
 * @mail 1667376033@qq.com
 * 功能描述:
 */
public class FragmentaAgorithm extends BaseFragment {


    @BindView(R.id.tv)
    TextView tv;

    @BindView(R.id.et)
    EditText et;

    @BindView(R.id.bt)
    AppCompatButton bt;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View rootView, Bundle savedInstanceState) {
    }

    @Override
    protected int initLayout() {
        return R.layout.fragment_algorithm;
    }

    @OnClick({R.id.bt})
    public void onClickView(View view) {
        switch (view.getId()) {
            case R.id.bt:
                et.setText("这是自动输入的内容");
                break;
            default:
                break;
        }
    }
}
