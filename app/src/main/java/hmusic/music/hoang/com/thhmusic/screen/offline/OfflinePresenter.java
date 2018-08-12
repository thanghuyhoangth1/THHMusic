package hmusic.music.hoang.com.thhmusic.screen.offline;

import android.content.Context;
import android.util.Log;

import java.util.List;

import hmusic.music.hoang.com.thhmusic.data.model.Album;
import hmusic.music.hoang.com.thhmusic.data.model.Artist;
import hmusic.music.hoang.com.thhmusic.data.model.Track;
import hmusic.music.hoang.com.thhmusic.data.source.remote.SongRepository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class OfflinePresenter implements OfflineContract.Presenter {
    private SongRepository mSongRepository;
    private OfflineContract.View mView;
    private CompositeDisposable mCompositeDisposable;

    public OfflinePresenter(SongRepository songRepository) {
        mSongRepository = songRepository;
        mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    public void getAllSong(Context context) {
        Disposable disposable = mSongRepository.getAllMusic(context)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        mView.showProgressBar();
                    }
                })
                .subscribe(new Consumer<List<Track>>() {
                    @Override
                    public void accept(List<Track> tracks) throws Exception {
                        mView.showAllSong(tracks);
                        mView.hideProgressBar();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.showError(throwable);
                        mView.hideProgressBar();
                    }
                });
        mCompositeDisposable.add(disposable);
    }

    @Override
    public void getAllArtist(Context context) {
        Disposable disposable = mSongRepository.getAllArtist(context)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(dispoisable -> mView.showProgressBar())
                .subscribe(new Consumer<List<Artist>>() {
                    @Override
                    public void accept(List<Artist> list) throws Exception {
                        mView.hideProgressBar();
                        mView.showAllArtis(list);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.showError(throwable);
                        mView.hideProgressBar();
                    }
                });
        mCompositeDisposable.add(disposable);
    }

    @Override
    public void getAllAlbum(Context context) {
        Disposable disposable = mSongRepository.getAllAlbum(context)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        mView.showProgressBar();
                    }
                }).subscribe(new Consumer<List<Album>>() {
                    @Override
                    public void accept(List<Album> list) throws Exception {
                        mView.hideProgressBar();
                        mView.showAllAlbum(list);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.showError(throwable);
                    }
                });
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {
        mCompositeDisposable.clear();

    }

    @Override
    public void setView(OfflineContract.View view) {
        mView = view;

    }
}
