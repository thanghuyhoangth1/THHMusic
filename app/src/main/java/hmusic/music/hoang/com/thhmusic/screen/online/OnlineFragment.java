package hmusic.music.hoang.com.thhmusic.screen.online;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import hmusic.music.hoang.com.thhmusic.R;
import hmusic.music.hoang.com.thhmusic.data.model.MusicType;
import hmusic.music.hoang.com.thhmusic.screen.BaseFragment;
import hmusic.music.hoang.com.thhmusic.screen.OnBindDataChildRecycler;
import hmusic.music.hoang.com.thhmusic.screen.OnRecyclerViewClickListener;
import hmusic.music.hoang.com.thhmusic.screen.main.adapter.MusicTypeAdapter;

public class OnlineFragment extends BaseFragment implements OnBindDataChildRecycler<MusicType> {
    private RecyclerView mRecyclerView;

    @Override
    protected void addEvent() {

    }

    @Override
    protected void initComps(View rootView, Bundle savedInstanceState) {
        mRecyclerView = rootView.findViewById(R.id.recycler_musictype);
    }

    @Override
    public int getResource() {
        return R.layout.fragment_music;
    }

    @Override
    public void onBindData(RecyclerView recyclerView, MusicType data) {

    }
}
