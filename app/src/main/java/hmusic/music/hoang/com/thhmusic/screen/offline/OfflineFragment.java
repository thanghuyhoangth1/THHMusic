package hmusic.music.hoang.com.thhmusic.screen.offline;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import hmusic.music.hoang.com.thhmusic.MainApplication;
import hmusic.music.hoang.com.thhmusic.R;
import hmusic.music.hoang.com.thhmusic.data.model.Album;
import hmusic.music.hoang.com.thhmusic.data.model.Artist;
import hmusic.music.hoang.com.thhmusic.data.model.Track;
import hmusic.music.hoang.com.thhmusic.screen.BaseFragment;
import hmusic.music.hoang.com.thhmusic.screen.OnRecyclerViewClickListener;
import hmusic.music.hoang.com.thhmusic.screen.main.MainActivity;
import hmusic.music.hoang.com.thhmusic.screen.offline.adapter.AlbumAdapter;
import hmusic.music.hoang.com.thhmusic.screen.offline.adapter.ArtistAdapter;
import hmusic.music.hoang.com.thhmusic.screen.online.adapter.TrackAdapter;
import hmusic.music.hoang.com.thhmusic.service.PlayMusicService;

public class OfflineFragment extends BaseFragment implements OfflineContract.View,
        OnRecyclerViewClickListener {
    @Inject
    OfflineContract.Presenter mPresenter;
    private RecyclerView mRecyclerAllSong;
    private RecyclerView mRecyclerAlbum;
    private RecyclerView mRecyclerArtist;
    private ProgressBar mProgressBar;
    private MainActivity mParentActivity;

    @Override

    protected void addEvent() {

    }

    @Override
    protected void initComps(View rootView, Bundle savedInstanceState) {
        mRecyclerAllSong = rootView.findViewById(R.id.recycler_allsong);
        mRecyclerAlbum = rootView.findViewById(R.id.recycler_album);
        mRecyclerArtist = rootView.findViewById(R.id.recycler_artist);
        mProgressBar = rootView.findViewById(R.id.progressbar);
        mParentActivity = (MainActivity) getActivity();
        DaggerOffliineComponent.builder()
                .appComponent(((MainApplication) getActivity().getApplication()).getAppComponent())
                .offlineModule(new OfflineModule())
                .build().inject(this);
        mPresenter.setView(this);
        mPresenter.getAllSong(getActivity());
        mPresenter.getAllArtist(getActivity());
        mPresenter.getAllAlbum(getActivity());
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
        ArtistAdapter artistAdapter = new ArtistAdapter(getActivity(), list, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        mRecyclerArtist.setLayoutManager(layoutManager);
        mRecyclerArtist.setAdapter(artistAdapter);
    }

    @Override
    public void showAllAlbum(List<Album> list) {
        AlbumAdapter albumAdapter = new AlbumAdapter(getActivity(), list, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        mRecyclerAlbum.setAdapter(albumAdapter);
        mRecyclerAlbum.setLayoutManager(layoutManager);
    }

    @Override
    public void onClick(List list, int pos) {

        if (list.get(pos) instanceof Track) {
            Intent intent = new Intent(getActivity(), PlayMusicService.class);
            Bundle bundle = new Bundle();
            Log.d("ahihi", ((Track) list.get(pos)).isOffline() + "");
            bundle.putParcelable(PlayMusicService.INTENT_TRACK, (Track) list.get(pos));
            bundle.putInt(PlayMusicService.INTENT_POSITION_TRACK, pos);
            intent.putExtras(bundle);
            getActivity().startService(intent);
            if (mParentActivity != null) {
                mParentActivity.setMusicPlayList((List<Track>) list);
            }
        }

    }
}
