package com.fallwater.applicationtest1710.fragment;

import com.fallwater.applicationtest1710.R;
import com.fallwater.applicationtest1710.define.CenteredImageSpan;

import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.TextView;

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
