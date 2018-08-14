package hmusic.music.hoang.com.thhmusic.screen.search.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import hmusic.music.hoang.com.thhmusic.R;
import hmusic.music.hoang.com.thhmusic.data.model.Track;
import hmusic.music.hoang.com.thhmusic.screen.BaseRecyclerViewAdapter;
import hmusic.music.hoang.com.thhmusic.screen.OnRecyclerViewClickListener;


public class SearchResultAdapter extends BaseRecyclerViewAdapter<Track, SearchResultAdapter.ViewHolder> {


    public SearchResultAdapter(Context context, List<Track> data, OnRecyclerViewClickListener<Track> listener) {
        super(context, data, listener);
    }

    @Override
    public void addData() {

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mLayoutInflater.inflate(R.layout.item_search_result, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        super.onBindViewHolder(viewHolder, i);
        viewHolder.bindData(mData, i);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mImageAvatar;
        TextView mTextTitle;
        TextView mTextArtist;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageAvatar = itemView.findViewById(R.id.image_avatar);
            mTextTitle = itemView.findViewById(R.id.text_title);
            mTextArtist = itemView.findViewById(R.id.text_artist);
        }

        public void bindData(List<Track> data, int i) {
            Track track = data.get(i);
            if (track.getImage() == null) {
                mImageAvatar.setImageResource(R.drawable.ic_launcher);
            } else {
                if (track.getImage().equals("") | track.getImage().equals("null")) {
                    mImageAvatar.setImageResource(R.drawable.ic_launcher);
                }

                Glide.with(mContext).load(track.getImage()).into(mImageAvatar);
            }
            mTextArtist.setText(track.getUser().getArtist());
            mTextTitle.setText(track.getTitle());
        }
    }
}
