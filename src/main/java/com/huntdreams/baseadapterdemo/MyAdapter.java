package com.huntdreams.baseadapterdemo;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by noprom on 2015/4/22.
 */
public class MyAdapter extends BaseAdapter {

    private List<ItemBean> mItemBeans;
    private LayoutInflater mInflater;
    private long mSumTime;

    public MyAdapter(Context context,List<ItemBean> list){
        this.mItemBeans = list;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mItemBeans.size();
    }

    @Override
    public Object getItem(int i) {
        return mItemBeans.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
//        // 逗比式
//        View view = mInflater.inflate(R.layout.list_item,null);
//        ImageView imageView = (ImageView) view.findViewById(R.id.iv_image);
//        TextView title = (TextView) view.findViewById(R.id.tv_title);
//        TextView content = (TextView) view.findViewById(R.id.tv_content);
//
//        ItemBean itemBean = mItemBeans.get(position);
//        imageView.setImageResource(itemBean.itemImageResId);
//        title.setText(itemBean.itemTitle);
//        content.setText(itemBean.itemContent);
//        return view;

//        // 普通式
//        if(convertView == null){
//            convertView = mInflater.inflate(R.layout.list_item,null);
//        }
//        ImageView imageView = (ImageView) convertView.findViewById(R.id.iv_image);
//        TextView title = (TextView) convertView.findViewById(R.id.tv_title);
//        TextView content = (TextView) convertView.findViewById(R.id.tv_content);
//
//        ItemBean itemBean = mItemBeans.get(position);
//        imageView.setImageResource(itemBean.itemImageResId);
//        title.setText(itemBean.itemTitle);
//        content.setText(itemBean.itemContent);
//        return convertView;

        // 文艺式
        long startTime = System.nanoTime();
        ViewHolder viewHolder;
        if(convertView == null){
            convertView = mInflater.inflate(R.layout.list_item,null);
            viewHolder = new ViewHolder();
            viewHolder.image = (ImageView) convertView.findViewById(R.id.iv_image);
            viewHolder.title = (TextView) convertView.findViewById(R.id.tv_title);
            viewHolder.content = (TextView) convertView.findViewById(R.id.tv_content);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        ItemBean itemBean = mItemBeans.get(position);
        viewHolder.image.setImageResource(itemBean.itemImageResId);
        viewHolder.title.setText(itemBean.itemTitle);
        viewHolder.content.setText(itemBean.itemContent);

        long endTime = System.nanoTime();
        mSumTime += endTime-startTime;
        Log.d("TAG","BaseAdapterDemo Time = "+String.valueOf(mSumTime));
        return convertView;
    }

    class ViewHolder{
        public ImageView image;
        public TextView title;
        public TextView content;
    }
}
