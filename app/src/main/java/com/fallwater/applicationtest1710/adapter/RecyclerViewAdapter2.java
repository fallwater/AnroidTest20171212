package com.fallwater.applicationtest1710.adapter;

import com.fallwater.applicationtest1710.R;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * @author Fallwater潘建波 on 2017/12/22
 * @mail 1667376033@qq.com
 * 功能描述:
 */
public class RecyclerViewAdapter2 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Integer> data;

    public RecyclerViewAdapter2(List<Integer> data) {
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView;
        if (viewType == 1) {
            itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_recyclerview01, parent, false);
        } else if (viewType == 2) {
            itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_recyclerview02, parent, false);
        }else {
            itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_recyclerview02, parent, false);
        }
        return new RecyclerView.ViewHolder(itemView) {
            @Override
            public String toString() {
                return super.toString();
            }
        };
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemViewType(int position) {
        if (position == 1) {
            return 1;
        } else {
            return 2;
        }
    }

    @Override
    public int getItemCount() {
        if (data != null) {
            return data.size();
        }
        return 0;
    }
}
