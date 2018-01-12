package com.fallwater.applicationtest1710.fragment;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fallwater.applicationtest1710.R;
import com.fallwater.applicationtest1710.adapter.BRVAHAdapter;
import com.fallwater.applicationtest1710.bean.Bean1;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @author Fallwater潘建波 on 2017/12/23
 * @mail 1667376033@qq.com
 * 功能描述:
 */
public class BRVAHFragment extends BaseFragment {

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerView;

    BRVAHAdapter mAdapter;

    List<Bean1> mList;

    @Override
    protected void initData() {
        if (mList == null) {
            mList = new ArrayList<>();
        }
        for (int i = 0; i < 10; i++) {
            mList.add(new Bean1(i));
        }

    }

    @Override
    protected void initView(View rootView, Bundle savedInstanceState) {
        if (mAdapter == null && mList != null) {
            mAdapter = new BRVAHAdapter(R.layout.item_recyclerview01, mList);
        }
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(
                new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        mRecyclerView.addItemDecoration(
                new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));

        mAdapter.setOnItemClickListener((adapter, view, position) -> toast("item click"));
        mAdapter.setOnItemChildClickListener(
                ((adapter, view, position) -> toast("child item click")));
        TextView headView = new TextView(getContext());
        headView.setText("headview");
        mAdapter.addHeaderView(headView);

        TextView footView = new TextView(getContext());
        footView.setText("footView");
        mAdapter.addFooterView(footView);

    }

    private void toast(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "toast";
        }
        Toast.makeText(getContext(), str, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected int initLayout() {
        return R.layout.fragment_recycleview;
    }


}
