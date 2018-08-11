package hmusic.music.hoang.com.thhmusic.screen.offline;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import hmusic.music.hoang.com.thhmusic.MainApplication;
import hmusic.music.hoang.com.thhmusic.R;
import hmusic.music.hoang.com.thhmusic.data.model.Artist;
import hmusic.music.hoang.com.thhmusic.data.model.Track;
import hmusic.music.hoang.com.thhmusic.screen.BaseFragment;
import hmusic.music.hoang.com.thhmusic.screen.OnRecyclerViewClickListener;
import hmusic.music.hoang.com.thhmusic.screen.online.adapter.TrackAdapter;

public class OfflineFragment extends BaseFragment implements OfflineContract.View,
        OnRecyclerViewClickListener {
    @Inject
    OfflineContract.Presenter mPresenter;
    private RecyclerView mRecyclerAllSong;
    private RecyclerView mRecyclerAlbum;
    private RecyclerView mRecyclerArtist;
    private ProgressBar mProgressBar;

    @Override

    protected void addEvent() {

    }

    @Override
    protected void initComps(View rootView, Bundle savedInstanceState) {
        mRecyclerAllSong = rootView.findViewById(R.id.recycler_allsong);
        mRecyclerAlbum = rootView.findViewById(R.id.recycler_album);
        mRecyclerArtist = rootView.findViewById(R.id.recycler_artist);
        mProgressBar = rootView.findViewById(R.id.progressbar);
        DaggerOffliineComponent.builder()
                .appComponent(((MainApplication) getActivity().getApplication()).getAppComponent())
                .offlineModule(new OfflineModule())
                .build().inject(this);
        mPresenter.setView(this);
        mPresenter.getAllSong(getActivity());
        mPresenter.getAllArtist(getActivity());
    }

    @Override
    public int getResource() {
        return R.layout.fragment_music_offline;
    }


    @Override
    public void showError(Throwable throwable) {
        Toast.makeText(getActivity(), throwable.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgressBar() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        mProgressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showAllSong(List<Track> listTrack) {
        TrackAdapter trackAdapter = new TrackAdapter(getActivity(), listTrack, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        mRecyclerAllSong.setLayoutManager(layoutManager);
        mRecyclerAllSong.setAdapter(trackAdapter);
    }

    @Override
    public void showAllArtis(List<Artist> list) {

    }

    @Override
    public void onClick(List list, int pos) {

    }
}
