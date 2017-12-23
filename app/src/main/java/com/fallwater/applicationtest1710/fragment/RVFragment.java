package com.fallwater.applicationtest1710.fragment;

import com.fallwater.applicationtest1710.R;
import com.fallwater.applicationtest1710.adapter.RecyclerViewAdapter2;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @author Fallwater潘建波 on 2017/12/21
 * @mail 1667376033@qq.com
 * 功能描述:
 */
public class RVFragment extends BaseFragment {

    List<Integer> data = new ArrayList<>();

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerView;

    RecyclerViewAdapter2 mAdapter;

    @Override
    protected void initData() {
        data.add(1);
        data.add(2);

        mAdapter = new RecyclerViewAdapter2(data);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(
                new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false));
        mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
                super.onDraw(c, parent, state);
            }

            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                    RecyclerView.State state) {
                RecyclerViewAdapter2 adapter = (RecyclerViewAdapter2) parent.getAdapter();
                int pos = parent.getChildAdapterPosition(view);
                int itemType = adapter.getItemViewType(pos);
                if (itemType == 1) {
                    /**
                     * top设置为负数，item位置上移，
                     */
                    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                        outRect.top = dp2px(-30);
                    } else {
                        outRect.top = dp2px(-30);
                    }
                    outRect.bottom = 0;
                    outRect.left = dp2px(12);
                    outRect.right = dp2px(12);

                }
            }
        });


    }

    @Override
    protected void initView(View rootView, Bundle savedInstanceState) {

    }

    @Override
    protected int initLayout() {
        return R.layout.fragment_recycleview;
    }

    public int dp2px(float dpValue) {
        final float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
