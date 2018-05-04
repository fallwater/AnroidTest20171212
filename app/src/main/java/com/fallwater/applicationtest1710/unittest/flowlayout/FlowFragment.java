package com.fallwater.applicationtest1710.unittest.flowlayout;

import com.develop.rth.gragwithflowlayout.FlowDragLayoutConstant;
import com.develop.rth.gragwithflowlayout.FlowDragLayoutManager;
import com.fallwater.applicationtest1710.R;
import com.fallwater.applicationtest1710.fragment.BaseFragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.BindView;

/**
 * @author Fallwater潘建波 on 2018/4/19
 * @mail 1667376033@qq.com
 * 功能描述:
 */
public class FlowFragment extends BaseFragment {

    @BindView(R.id.body)
    RecyclerView recyclerView;

    SearchHotAdapterTest mAdapter;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View rootView, Bundle savedInstanceState) {

        FlowDragLayoutManager manager = new FlowDragLayoutManager(FlowDragLayoutConstant.LEFT);

//        final LinearLayoutManager manager = new LinearLayoutManager(recyclerView.getContext(),
//                LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(manager);
        mAdapter = new SearchHotAdapterTest();
        recyclerView.setAdapter(mAdapter);

    }

    @Override
    protected int initLayout() {
        return R.layout.fragment_flow;
    }
}
