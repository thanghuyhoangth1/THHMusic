package hmusic.music.hoang.com.thhmusic.screen.online;

import hmusic.music.hoang.com.thhmusic.data.source.remote.SongRepository;
import hmusic.music.hoang.com.thhmusic.utils.rx.BaseSchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;

public class OnlinePresenter implements OnlineFragmentContract.Presenter {
    private OnlineFragmentContract.View mView;
    private SongRepository mSongRepository;
    private CompositeDisposable mCompositeDisposable;
    private BaseSchedulerProvider mBaseSchedulerProvider;

    public OnlinePresenter(SongRepository songRepository,
                           CompositeDisposable compositeDisposable,
                           BaseSchedulerProvider baseSchedulerProvider) {
        mSongRepository = songRepository;
        mCompositeDisposable = compositeDisposable;
        mBaseSchedulerProvider = baseSchedulerProvider;
    }


    @Override
    public void getSongs() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {
        mCompositeDisposable.clear();
        ;
    }

    @Override
    public void setView(OnlineFragmentContract.View view) {
        mView = view;
    }
}
