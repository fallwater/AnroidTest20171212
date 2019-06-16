package com.fallwater.applicationtest1710.fragment;

import com.blankj.utilcode.util.LogUtils;
import com.fallwater.applicationtest1710.R;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author Fallwater潘建波 on 2018/1/25
 * @mail 1667376033@qq.com
 * 功能描述:
 */
public class FragmentaAgorithm extends BaseFragment {

    public static final String TAG = "FragmentaAgorithm";

    @BindView(R.id.tv_input)
    TextView mInputTV;

    @BindView(R.id.tv_sort)
    TextView mSortTV;

    private List<Integer> mList;

    private String pre = "排序前：\n";

    private String after = "排序后：\n";

    @Override
    protected void initData() {
        mList = new ArrayList<>();
        mList.add(1);
        mList.add(12);
        mList.add(13);
        mList.add(1);
        mList.add(101);
        mList.add(189);
        mList.add(156);
        mList.add(9);
        mList.add(10);
        mList.add(21);
        mList.add(41);
        mList.add(11);
        mList.add(111);
        mList.add(1000);
        mList.add(199);

        printBefore();
    }

    @Override
    protected void initView(View rootView, Bundle savedInstanceState) {
    }

    @Override
    protected int initLayout() {
        return R.layout.fragment_algorithm;
    }

    @OnClick({R.id.bt_maopao, R.id.bt_kuaisu, R.id.bt_xuanze, R.id.bt_guibing,
            R.id.bt_xier, R.id.bt_dui, R.id.bt_charu, R.id.bt_jishu,
            R.id.bt_tong, R.id.bt_jishu2})
    public void onClickView(View view) {
        String append = "";
        switch (view.getId()) {
            case R.id.bt_maopao:
                append = "冒泡";
                maopao();
                break;
            case R.id.bt_kuaisu:
                append = "快排";
                kuaiPai(mList,0,mList.size()-1);
                break;
            case R.id.bt_xuanze:
                append = "冒泡";
                break;
            case R.id.bt_guibing:
                append = "冒泡";
                break;
            case R.id.bt_xier:
                append = "冒泡";
                break;
            case R.id.bt_dui:
                append = "冒泡";
                break;
            case R.id.bt_charu:
                append = "冒泡";
                break;
            case R.id.bt_jishu:
                append = "冒泡";
                break;
            case R.id.bt_tong:
                append = "冒泡";
                break;
            case R.id.bt_jishu2:
                append = "冒泡";
                break;
            default:
                break;
        }
        printAfter(append);
    }

    /**
     * 快排
     */
    private void kuaiPai(List<Integer> list, int start, int end) {
        LogUtils.dTag(TAG, "kuaiPai:list=" + list + "start=" + start + ",end=" + end);
        if (list.size() == 1 || start >= end || end - start <= 1) {
            return;
        }
        int benchmark = list.get(start);
        int left = start;
        int right = end;
        while (left < right) {
            LogUtils.dTag(TAG, "while before:left=" + left + ",right=" + right);
            if (list.get(left) <= benchmark) {
                left++;
            }

            if (list.get(right) >= benchmark) {
                right--;
            }

            if (list.get(left) > benchmark && list.get(right) < benchmark) {
                swap(left, right);
                left++;
                right--;
            }

            LogUtils.dTag(TAG, "while after:left=" + left + ",right=" + right);
        }

        kuaiPai(list, start, left);
        kuaiPai(list, left, end);
    }
//    /**
//     * 快排
//     */
//    private void kuaiPai(List<Integer> list) {
//        int benchmark = 0;
//        for (int i = 0; i < mList.size(); i++) {
//
//
//
//        }
//    }

    private void printAfter(String append) {
        String sort = append + after + mList;
        mSortTV.setText(sort);
    }

    private void printBefore() {
        String original = pre + mList;
        mInputTV.setText(original);
    }

    /**
     * 冒泡排序
     */
    private void maopao() {
        for (int j = 0; j < mList.size(); j++) {
            for (int i = 0; i < mList.size() - j; i++) {
                if (i + 1 >= mList.size() - j) {
                    break;
                }
                if (mList.get(i) > mList.get(i + 1)) {
                    swap(i, i + 1);
                }
            }
        }
    }

    private void swap(int i, int j) {
        LogUtils.dTag(TAG,"swap:i="+i+",j="+j);
        int temp = mList.get(i);
        mList.set(i, mList.get(j));
        mList.set(j, temp);
    }
}
