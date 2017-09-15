package com.example.administrator.popupwindowdemo.adapter;

import java.util.List;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.popupwindowdemo.R;

public class TypeShowDislogAdapter extends BaseAdapter {
    private Context mContext;
    private List<String> mDatas;

    public TypeShowDislogAdapter(Context mContext, List<String> mxList) {
        super();
        this.mDatas = mxList;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        if (mDatas == null) {
            return 0;
        } else {
            return this.mDatas.size();
        }
    }

    @Override
    public Object getItem(int position) {
        if (mDatas == null) {
            return null;
        } else {
            return this.mDatas.get(position);
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressWarnings("deprecation")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;

        if (convertView == null) {
            holder = new ViewHolder();

            convertView = LayoutInflater.from(this.mContext).inflate(R.layout.type_showdislog_listview_item, parent,
                    false);

            holder.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        if (this.mDatas != null && !this.mDatas.isEmpty()) {
             holder.tv_name.setText(mDatas.get(position));
        }

        return convertView;
    }

    private class ViewHolder {
        TextView tv_name;
    }
}
