package com.fallwater.applicationtest1710.fragment;

import com.fallwater.applicationtest1710.R;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author Fallwater潘建波 on 2017/12/21
 * @mail 1667376033@qq.com
 * 功能描述:
 */
public class RVFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_recycleview, container, false);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
