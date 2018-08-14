package hmusic.music.hoang.com.thhmusic.screen.search;

import java.util.List;

import hmusic.music.hoang.com.thhmusic.data.model.Track;
import hmusic.music.hoang.com.thhmusic.data.source.remote.SongRepository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class SearchPresenter implements SearchContract.Presenter {
    private SearchContract.View mView;
    private SongRepository mSongRepository;
    private CompositeDisposable mCompositeDisposable;

    public SearchPresenter(SongRepository songRepository) {
        mCompositeDisposable = new CompositeDisposable();
        mSongRepository = songRepository;
    }

    @Override
    public void search(String query) {
        Disposable disposable = mSongRepository.searchTrack(query)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Track>>() {
                    @Override
                    public void accept(List<Track> tracks) throws Exception {
                        mView.hideProgressBar();
                        mView.showResult(tracks);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.showError(throwable);

                    }
                });
        mCompositeDisposable.add(disposable);
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {
        mCompositeDisposable.clear();
    }

    @Override
    public void setView(SearchContract.View view) {
        mView = view;

    }
}
