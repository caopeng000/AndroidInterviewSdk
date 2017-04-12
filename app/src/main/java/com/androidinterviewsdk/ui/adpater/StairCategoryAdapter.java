package com.androidinterviewsdk.ui.adpater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.androidinterviewsdk.R;
import com.androidinterviewsdk.model.bean.StairCategory;


import java.util.List;


/**
 * 排行榜的adpater
 *
 * @author
 */
public class StairCategoryAdapter extends BaseAdapter {

    private LayoutInflater listContainer;
    private List<StairCategory> mDateList;
    private Context mContext;

    public StairCategoryAdapter(Context context) {
        this.mContext = context;
        listContainer = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setData(List<StairCategory> mDateList) {
        this.mDateList = mDateList;
        notifyDataSetChanged();
    }


    int count = 0;

    @Override
    public int getCount() {
        int count = 0;
        if (mDateList == null) {
            count = 0;
        } else {
            count = mDateList.size();
        }
        return count;
    }


    @Override
    public Object getItem(int position) {
        return mDateList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressWarnings("unused")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        RankViewHolder viewHolder = null;
        if (null == convertView) {
            viewHolder = new RankViewHolder();
            convertView = listContainer.inflate(R.layout.item_stair_category, parent, false);
            viewHolder.tvId = (TextView) convertView.findViewById(R.id.et_Stair_Id);
            viewHolder.tvName = (TextView) convertView.findViewById(R.id.et_Stair_Name);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (RankViewHolder) convertView.getTag();
        }
        StairCategory dataListItem = mDateList.get(position);
        if (dataListItem != null) {
            viewHolder.tvId.setText("大分类ID:" + dataListItem.getId());
            viewHolder.tvName.setText("大分类内容:" + dataListItem.getName());

        }
        return convertView;
    }

    private static class RankViewHolder {
        private TextView tvId;
        private TextView tvName;

    }


}
