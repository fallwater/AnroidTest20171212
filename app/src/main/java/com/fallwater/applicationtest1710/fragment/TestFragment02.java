package com.fallwater.applicationtest1710.fragment;

import com.afollestad.materialdialogs.MaterialDialog;
import com.blankj.utilcode.util.ToastUtils;
import com.fallwater.applicationtest1710.R;
import com.fallwater.applicationtest1710.utils.AccountUtils;
import com.fallwater.applicationtest1710.utils.StringUtil;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
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
public class TestFragment02 extends BaseFragment {

//    @BindView(R.id.view)
//    View01 mView;
//
//    @BindView(R.id.viewGroup)
//    ViewGroup01 mViewGroup;

    @BindView(R.id.tv1)
    TextView mTextView1;

    @BindView(R.id.tv2)
    TextView mTextView2;

    @BindView(R.id.et)
    EditText mEditText;

    Unbinder unbinder;

    @Override
    protected void initData() {
//        String numbers
//                = "Ma xac nhan: 19742 Akulaku yeu cau ma xac nhan khong vi cac muc dich khac, vui long khong tiet lo ma xac nhan.";
//        String result = numbers.replaceAll("[^0-9]", "");
//        Log.d("tag", result.substring(0, 5));

//        method1();

    }

    private void method1() {
        String originalAccount = "pansdjf";
        String originalAccount1 = "pan jianbo bo ksdfjklksdjflksjdfksjdflkjsdkljf";
        String originalAccount2 = "ksdfjklksdjflksjdfksjdflkjsdkljf";
        String originalAccount3 = "ksdfjklksdjflksjdfksjdflkjsdkljf pan jianbo bo ksdfjklksdjflksjdfksjdflkjsdkljf";

        Log.i("tag", AccountUtils.maskAccountName(originalAccount));
        Log.i("tag", AccountUtils.maskAccountName(originalAccount1));
        Log.i("tag", AccountUtils.maskAccountName(originalAccount2));
        Log.i("tag", AccountUtils.maskAccountName(originalAccount3));

        String number0 = "123";
        String number = "1233";
        String number1 = "1233152254";
        String number2 = "12316555555512222222222223";
        Log.i("tag", AccountUtils.maskAccountNumber(number0));
        Log.i("tag", AccountUtils.maskAccountNumber(number));
        Log.i("tag", AccountUtils.maskAccountNumber(number1));
        Log.i("tag", AccountUtils.maskAccountNumber(number2));

        new MaterialDialog.Builder(getActivity())
                .content(
                        "coent skdjfsflksjflksdjf  lskjdflksjfk l;aksdjf lksjdf sal laskjdflksajf;laksj dflsakjdf sakfjlskdjf lksjdf ")
                .positiveText("ok")
                .onPositive((dialog, which) -> dialog.dismiss())
                .show();
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

    @OnClick({R.id.tv1})
    public void onClickView(View view) {
        switch (view.getId()) {
            case R.id.tv1:
                if (!StringUtil
                        .checkPatternAccountName(mEditText.getText().toString(), StringUtil.BANK_TRANSFER_ACCOUNT)) {
                    ToastUtils.showShort("未通过校验");
                }else {
                    ToastUtils.showShort("通过校验");
                }
                    break;
            default:
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
