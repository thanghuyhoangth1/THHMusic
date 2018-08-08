package hmusic.music.hoang.com.thhmusic.screen.online;

import android.util.Log;

import hmusic.music.hoang.com.thhmusic.data.source.remote.SongRepository;

public class OnlinePresenter implements OnlineFragmentContract.Presenter {
    private OnlineFragmentContract.View mView;
    private SongRepository mSongRepository;

    public OnlinePresenter(SongRepository songRepository) {
        mSongRepository = songRepository;
    }


    @Override
    public void getSongs() {
        Log.d("kiemtra", "runned");

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void setView(OnlineFragmentContract.View view) {
        mView = view;
    }
}
