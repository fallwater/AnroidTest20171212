package com.fallwater.applicationtest1710.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fallwater.applicationtest1710.R;
import com.fallwater.applicationtest1710.bean.Bean1;

import android.support.annotation.Nullable;

import java.util.List;

/**
 * @author Fallwater潘建波 on 2017/12/23
 * @mail 1667376033@qq.com
 * 功能描述:
 */
public class BRVAHAdapter extends BaseQuickAdapter<Bean1,BaseViewHolder> {

    public BRVAHAdapter(int layoutResId,
            @Nullable List<Bean1> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Bean1 item) {
        helper.setText(R.id.tv01,item.value+"")
        .addOnClickListener(R.id.tv01);
    }
}
