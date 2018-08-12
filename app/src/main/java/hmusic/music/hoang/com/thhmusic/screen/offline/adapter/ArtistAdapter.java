package hmusic.music.hoang.com.thhmusic.screen.offline.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import hmusic.music.hoang.com.thhmusic.R;
import hmusic.music.hoang.com.thhmusic.data.model.Artist;
import hmusic.music.hoang.com.thhmusic.screen.BaseRecyclerViewAdapter;
import hmusic.music.hoang.com.thhmusic.screen.OnRecyclerViewClickListener;

public class ArtistAdapter extends BaseRecyclerViewAdapter<Artist, ArtistAdapter.ViewHolder> {
    public ArtistAdapter(Context context, List<Artist> data, OnRecyclerViewClickListener<Artist> listener) {
        super(context, data, listener);
    }

    @Override
    public void addData() {

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = mLayoutInflater.inflate(R.layout.item_music, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        super.onBindViewHolder(viewHolder, i);
        viewHolder.bindData(mData, i);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageAvatar;
        TextView tetTitle;
        TextView textDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageAvatar = itemView.findViewById(R.id.image_avatar);
            tetTitle = itemView.findViewById(R.id.text_title);
            textDescription = itemView.findViewById(R.id.text_description);
        }

        public void bindData(List<Artist> data, int i) {
            Artist value = data.get(i);
            tetTitle.setText(value.getName());
            textDescription.setText(value.getCountTrack() + "");
            if (value.getArtisArt() != null) {
                imageAvatar.setImageURI(Uri.parse(value.getArtisArt()));
            } else {
                imageAvatar.setImageResource(R.drawable.ic_launcher);
            }
        }
    }
}
