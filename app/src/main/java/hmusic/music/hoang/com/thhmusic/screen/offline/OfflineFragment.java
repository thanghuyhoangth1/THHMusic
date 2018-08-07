package hmusic.music.hoang.com.thhmusic.screen.offline;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import java.util.List;

import hmusic.music.hoang.com.thhmusic.R;
import hmusic.music.hoang.com.thhmusic.data.model.Music;
import hmusic.music.hoang.com.thhmusic.data.model.MusicType;
import hmusic.music.hoang.com.thhmusic.screen.BaseFragment;
import hmusic.music.hoang.com.thhmusic.screen.OnRecyclerViewClickListener;

public class OfflineFragment extends BaseFragment implements OnRecyclerViewClickListener<MusicType> {
    @Override
    protected void addEvent() {

    }

    @Override
    protected void initComps(View rootView, Bundle savedInstanceState) {

    }

    @Override
    public int getResource() {
        return R.layout.fragment_music;
    }

    @Override
    public void onClick(List<MusicType> list, int pos) {

    }
}
