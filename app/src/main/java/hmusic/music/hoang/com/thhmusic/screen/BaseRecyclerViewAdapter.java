package hmusic.music.hoang.com.thhmusic.screen;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseRecyclerViewAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    protected List<T> mData;
    protected Context mContext;
    protected OnRecyclerViewClickListener<T> mListener;
    protected LayoutInflater mLayoutInflater;

    public BaseRecyclerViewAdapter(Context context, List<T> data) {
        mContext = context;
        mData = data;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public BaseRecyclerViewAdapter(Context context, List<T> data, OnRecyclerViewClickListener<T> listener) {
        mContext = context;
        mData = data;
        mListener = listener;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public abstract void addData();

    @Override
    public void onBindViewHolder(@NonNull VH vh, final int i) {
        vh.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListener != null) {
                    mListener.onClick(mData, i);
                }
            }
        });
    }

    public void setData(List<T> data) {
        mData.clear();
        if (data != null) {
            mData.addAll(data);
        }
    }

    public List<T> getData() {
        return mData;
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }
}
