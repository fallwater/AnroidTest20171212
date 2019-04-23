package com.fallwater.applicationtest1710.fragment;

import com.afollestad.materialdialogs.MaterialDialog;
import com.blankj.utilcode.util.ToastUtils;
import com.fallwater.applicationtest1710.R;
import com.fallwater.applicationtest1710.activity.Const;
import com.fallwater.applicationtest1710.test.PhotoSampleDialog;
import com.fallwater.applicationtest1710.utils.AccountUtils;
import com.fallwater.applicationtest1710.utils.CommonUtils;
import com.fallwater.applicationtest1710.utils.ImageUtils;
import com.fallwater.applicationtest1710.utils.StringUtil;

import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * @author Fallwater潘建波 on 2018/1/25
 * @mail 1667376033@qq.com
 * 功能描述:
 */
public class TestFragment03 extends BaseFragment implements TextWatcher {


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
        et.addTextChangedListener(this);

    }

    @Override
    protected int initLayout() {
        return R.layout.fragment_test0341;
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

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if (!et.isFocused()) {
            return;
        }
        tv.setText("et changed:" +s);
    }
}
