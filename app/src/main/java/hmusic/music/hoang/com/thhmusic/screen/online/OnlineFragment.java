package hmusic.music.hoang.com.thhmusic.screen.online;

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
import hmusic.music.hoang.com.thhmusic.data.model.Track;
import hmusic.music.hoang.com.thhmusic.screen.BaseFragment;
import hmusic.music.hoang.com.thhmusic.screen.OnRecyclerViewClickListener;
import hmusic.music.hoang.com.thhmusic.screen.online.adapter.TrackAdapter;

public class OnlineFragment extends BaseFragment implements OnlineFragmentContract.View,
        OnRecyclerViewClickListener<Track> {
    private RecyclerView mRecyclerAllMusic;
    private RecyclerView mRecyclerAllAudio;
    private RecyclerView mRecyclerAlternativerock;
    private RecyclerView mRecyclerAmbient;
    private RecyclerView mRecyclerClassical;
    private RecyclerView mRecyclerCountry;
    private ProgressBar mProgressBar;

    @Inject
    OnlineFragmentContract.Presenter mPresenter;

    @Override
    protected void addEvent() {

    }

    @Override
    protected void initComps(View rootView, Bundle savedInstanceState) {
        mRecyclerAllMusic = rootView.findViewById(R.id.recycler_allmusic);
        mRecyclerAllAudio = rootView.findViewById(R.id.recycler_allaudio);
        mRecyclerAlternativerock = rootView.findViewById(R.id.recycler_alternativerock);
        mRecyclerAmbient = rootView.findViewById(R.id.recycler_ambient);
        mRecyclerClassical = rootView.findViewById(R.id.recycler_clasical);
        mRecyclerCountry = rootView.findViewById(R.id.recycler_country);
        mProgressBar = rootView.findViewById(R.id.progressbar);

        DaggerOnlineComponent.builder()
                .appComponent(((MainApplication) getActivity().getApplication()).getAppComponent())
                .onlineModule(new OnlineModule())
                .build().inject(this);
        mPresenter.setView(this);
        mPresenter.getAllMusic();
        mPresenter.getAllAudio();
        mPresenter.getAlternativerock();
        mPresenter.getAmbient();
        mPresenter.getClassical();
        mPresenter.getCountry();
    }

    @Override
    public int getResource() {
        return R.layout.fragment_music_online;
    }


    private void setupRecyclerView(RecyclerView recyclerView, List<Track> tracks) {
        TrackAdapter trackAdapter = new TrackAdapter(getActivity(), tracks, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setAdapter(trackAdapter);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void onClick(List<Track> list, int pos) {
        Log.d("kiemtra", list.get(pos).getTitle());
    }

    @Override
    public void showProgressbar() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressbar() {
        mProgressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showError(Throwable e) {
        Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showAllMusic(List<Track> tracks) {
        setupRecyclerView(mRecyclerAllMusic, tracks);
    }

    @Override
    public void showAllAudio(List<Track> tracks) {
        setupRecyclerView(mRecyclerAllAudio, tracks);
    }

    @Override
    public void showAmbient(List<Track> tracks) {
        setupRecyclerView(mRecyclerAmbient, tracks);
    }

    @Override
    public void showAlternativerock(List<Track> tracks) {
        setupRecyclerView(mRecyclerAlternativerock, tracks);
    }

    @Override
    public void showClassical(List<Track> tracks) {
        setupRecyclerView(mRecyclerClassical, tracks);
    }

    @Override
    public void showCountry(List<Track> tracks) {
        setupRecyclerView(mRecyclerCountry, tracks);
    }
}
