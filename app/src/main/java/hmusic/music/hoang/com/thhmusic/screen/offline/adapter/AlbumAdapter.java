package hmusic.music.hoang.com.thhmusic.screen.offline.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import hmusic.music.hoang.com.thhmusic.R;
import hmusic.music.hoang.com.thhmusic.data.model.Artist;
import hmusic.music.hoang.com.thhmusic.screen.BaseRecyclerViewAdapter;

public class AlbumAdapter extends BaseRecyclerViewAdapter<Artist, AlbumAdapter.ViewHolder> {
    public AlbumAdapter(Context context, List<Artist> data) {
        super(context, data);
    }

    @Override
    public void addData() {

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mLayoutInflater.inflate(R.layout.item_music, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        super.onBindViewHolder(viewHolder, i);
        viewHolder.bindData(mData,i);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void bindData(List<Artist> data, int i) {
            ImageView imageAvatar;
            TextView tetTitle;
            TextView textDescription;
        }
    }
}
