package com.fallwater.applicationtest1710.unittest.flowlayout;

import com.fallwater.applicationtest1710.R;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Fallwater潘建波 on 2018/4/19
 * @mail 1667376033@qq.com
 * 功能描述:热搜Adapter
 */
public class SearchHotAdapterTest extends RecyclerView.Adapter<SearchHotAdapterTest.ViewHolder> {

    private List<String> tagsData;

    public SearchHotAdapterTest() {
        realLoadTags();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_detail_search_hot, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return tagsData.size();
    }

    private void realLoadTags() {
        tagsData = new ArrayList<>();
        tagsData.add("RxJava");
        tagsData.add("JavaScript");
        tagsData.add("PHP");
        tagsData.add("惊天魔盗团");
        tagsData.add("希拉里落选");
        tagsData.add("热门标签");
        tagsData.add("ImageView");
        tagsData.add("wheel无限循环");
        tagsData.add("ViewPager");
        tagsData.add("数据存储");
        tagsData.add("上拉加载");
        tagsData.add("dialog");
        tagsData.add("dialog");
        tagsData.add("dialog");
        tagsData.add("dialog");
        tagsData.add("dialog");
        tagsData.add("dialog");
        tagsData.add("dialog");
        tagsData.add("dialog");
        tagsData.add("dialog");
        tagsData.add("dialog");
        tagsData.add("滑动浏览");
        tagsData.add("下载");
        tagsData.add("神奇动物在哪里");
        tagsData.add("video");
        tagsData.add("垂直ViewPager");
        tagsData.add("控件");
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvWord;

        ViewHolder(View itemView) {
            super(itemView);
            this.tvWord = (TextView) itemView;
        }

        TextView getTvWord() {
            return tvWord;
        }
    }
}
