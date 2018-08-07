package hmusic.music.hoang.com.thhmusic.screen.main.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import hmusic.music.hoang.com.thhmusic.R;
import hmusic.music.hoang.com.thhmusic.data.model.MusicType;
import hmusic.music.hoang.com.thhmusic.screen.BaseRecyclerViewAdapter;
import hmusic.music.hoang.com.thhmusic.screen.OnBindDataChildRecycler;

public class MusicTypeAdapter extends BaseRecyclerViewAdapter<MusicType, MusicTypeAdapter.ViewHolder> {
    private OnBindDataChildRecycler<MusicType> mListener;


    public MusicTypeAdapter(Context context, List<MusicType> data, OnBindDataChildRecycler<MusicType> listener) {
        super(context, data);
        mListener = listener;
    }

    @Override
    public void addData() {
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        super.onBindViewHolder(viewHolder, i);
        viewHolder.bindData(mData.get(i), mListener);

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View rootView = mLayoutInflater.inflate(R.layout.item_music_type, viewGroup, false);
        return new ViewHolder(rootView);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTitle;
        private RecyclerView mRecyclerSong;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.text_title);
            mRecyclerSong = itemView.findViewById(R.id.recycler_song);
        }

        public void bindData(MusicType musicType, OnBindDataChildRecycler<MusicType> mListener) {
            mTitle.setText(musicType.getTitle());
            mListener.onBindData(mRecyclerSong, musicType);
        }
    }
}
