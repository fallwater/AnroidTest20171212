package com.fallwater.applicationtest1710.fragment;

import com.fallwater.applicationtest1710.R;
import com.fallwater.applicationtest1710.define.CenteredImageSpan;

import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;

/**
 * @author Fallwater潘建波 on 2018/1/25
 * @mail 1667376033@qq.com
 * 功能描述:
 */
public class TestFragment01 extends BaseFragment {

    @BindView(R.id.tv_1)
    TextView mTextView;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View rootView, Bundle savedInstanceState) {

//        initTextView();

        test01();


    }

    private void test01() {
        if (checkSms(content, regex)) {
            Log.d("log", "pass");
            String smsRegex = regex;
            Log.d("log", "匹配正则表达式:" + smsRegex);
            Log.d("log", "正则表达式匹配成功");
            //得到短信模板中冒号的位置
            Toast.makeText(getActivity(), "匹配成功", Toast.LENGTH_SHORT).show();
            int start = content.indexOf(":");
            String captch = content.length() >= start + 6 ? content.substring(start + 1, start + 6) : null;
            Log.d("log", "提取的验证码为:" + captch);
        } else {
            Log.d("log", "正则表达式匹配失败");
            Toast.makeText(getActivity(), "匹配失败", Toast.LENGTH_SHORT).show();
        }
    }


    private static final String content
            = "OTP Ubah Kata Sandi:76254. HATI-HATI PENIPUAN, Pihak Akulaku TIDAK AKAN meminta kode verifikasi milik Anda. JANGAN BERIKAN kode verifikasi PADA SIAPAPUN.";

    private static final String regex = "OTPUbahKataSandi";

    private static boolean checkSms(String smsContent, String regex) {
        if (TextUtils.isEmpty(smsContent) || TextUtils.isEmpty(regex)) {
            return false;
        }

        String result = content.replaceAll("[^a-z^A-Z^0-9]", "");
        Log.d("log", result);
        return result
//                .replace(":","")
                .startsWith(regex);

    }


    private void initTextView() {
//        Drawable drawable = getResources().getDrawable(R.drawable.ic_agree);
//        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(),
//                drawable.getIntrinsicHeight());
        SpannableString spannable = new SpannableString(mTextView.getText()
                .toString() + "[smile]");
        ImageSpan span = new CenteredImageSpan(getContext(), R.drawable.ic_agree);
        spannable.setSpan(span, 0,
                1,
                Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        mTextView.setText(spannable);
    }

    @Override
    protected int initLayout() {
        return R.layout.fragment_test01;
    }
}
