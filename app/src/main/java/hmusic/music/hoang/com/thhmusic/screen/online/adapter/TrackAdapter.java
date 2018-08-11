package hmusic.music.hoang.com.thhmusic.screen.online.adapter;

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

public class TrackAdapter extends BaseRecyclerViewAdapter<Track, TrackAdapter.ViewHolder> {
    public TrackAdapter(Context context, List<Track> data, OnRecyclerViewClickListener<Track> listener) {
        super(context, data, listener);
    }

    @Override
    public void addData() {

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mLayoutInflater.inflate(R.layout.item_music, viewGroup, false);
        return new ViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        super.onBindViewHolder(viewHolder, i);
        viewHolder.bindData(mData.get(i));
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageAvatar;
        TextView tetTitle;
        TextView textDescription;

        public ViewHolder(@NonNull View itemView, OnRecyclerViewClickListener<Track> listener) {
            super(itemView);
            imageAvatar = itemView.findViewById(R.id.image_avatar);
            tetTitle = itemView.findViewById(R.id.text_title);
            textDescription = itemView.findViewById(R.id.text_description);
        }

        public void bindData(Track track) {
            tetTitle.setText(track.getTitle());
            textDescription.setText(track.getUser().getArtist());
            if (track.getImage() == null) {
                imageAvatar.setImageResource(R.drawable.ic_launcher);
                return;
            }
            if (track.getImage().equals("null") | track.getImage().equals("")) {
                imageAvatar.setImageResource(R.drawable.ic_launcher);
                return;
            }
            Glide.with(mContext).load(track.getImage()).into(imageAvatar);
        }

    }
}
