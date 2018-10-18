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
import android.text.TextUtils;
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

    @BindView(R.id.et2)
    EditText mEditText2;

    Unbinder unbinder;

    @BindView(R.id.imageView)
    ImageView mImageView;

    private String mSampleImageUrl = "https:\\/\\/s3-ap-northeast-1.amazonaws.com\\/com-silvrr-installment\\/config\\/auth_placeholder\\/4015\\/sample.png";

    @Override
    protected void initData() {
//        String numbers
//                = "Ma xac nhan: 19742 Akulaku yeu cau ma xac nhan khong vi cac muc dich khac, vui long khong tiet lo ma xac nhan.";
//        String result = numbers.replaceAll("[^0-9]", "");
//        Log.d("tag", result.substring(0, 5));

//        method1();

        byte[] imageBytes = Base64.decode(Const.data.getBytes(), Base64.DEFAULT);
        ImageUtils.displayImage(getActivity(), mImageView, imageBytes, R.mipmap.ic_launcher);

        mTextView1.setText("mTextView1\n mTextView2");


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
        return R.layout.fragment_test03;
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
                checkPercent();

                PhotoSampleDialog photoSampleDialog = new PhotoSampleDialog(getContext(), mSampleImageUrl);
                photoSampleDialog.show();
//                checkAccount();
                break;
            default:
                break;
        }
    }

    private void checkPercent() {
        String text1 = mEditText.getText().toString().trim();
        String text2 = mEditText2.getText().toString().trim();

        if (CommonUtils.comparePercentString(text1, text2)) {
            ToastUtils.showShort(text1 + " is smaller than " + text2);
        } else {
            ToastUtils.showShort(text1 + " is bigger than " + text2);
        }
    }

    private void checkAccount() {
        if (!StringUtil
                .checkPatternAccountName(mEditText.getText().toString(), StringUtil.BANK_TRANSFER_ACCOUNT)) {
            ToastUtils.showShort("未通过校验");
        } else {
            ToastUtils.showShort("通过校验");
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
