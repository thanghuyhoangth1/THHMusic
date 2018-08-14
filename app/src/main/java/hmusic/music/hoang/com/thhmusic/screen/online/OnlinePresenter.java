package hmusic.music.hoang.com.thhmusic.screen.online;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import hmusic.music.hoang.com.thhmusic.data.model.Track;
import hmusic.music.hoang.com.thhmusic.data.source.remote.SongRepository;
import hmusic.music.hoang.com.thhmusic.data.source.remote.api.BaseResponse;
import hmusic.music.hoang.com.thhmusic.utils.constants.MusicConstants;
import hmusic.music.hoang.com.thhmusic.utils.constants.MusicUtils;
import hmusic.music.hoang.com.thhmusic.utils.rx.BaseSchedulerProvider;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class OnlinePresenter implements OnlineFragmentContract.Presenter {
    private OnlineFragmentContract.View mView;
    private SongRepository mSongRepository;
    private CompositeDisposable mCompositeDisposable;
    private BaseSchedulerProvider mBaseSchedulerProvider;

    public OnlinePresenter(SongRepository songRepository,
                           BaseSchedulerProvider baseSchedulerProvider) {
        mSongRepository = songRepository;
        mCompositeDisposable = new CompositeDisposable();
        mBaseSchedulerProvider = baseSchedulerProvider;
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

    @Override
    public void getAllMusic() {
        Disposable disposable = mSongRepository.getTracks(MusicConstants.KIND,
                MusicUtils.createQueryGenre(MusicConstants.GENRE_ALLMUSIC),
                MusicConstants.CLIENT_ID, MusicConstants.LIMIT, MusicConstants.OFFSET).
                subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        mView.showProgressbar();
                    }
                }).map(new Function<BaseResponse, List<Track>>() {
                    @Override
                    public List<Track> apply(BaseResponse baseResponse) throws Exception {
                        List<Track> tracks = new ArrayList<>();
                        for (int i = 0; i < baseResponse.getTrackList().size(); i++) {
                            tracks.add(baseResponse.getTrackList().get(i).getTrack());
                        }
                        return tracks;
                    }
                }).subscribe(new Consumer<List<Track>>() {
                    @Override
                    public void accept(List<Track> tracks) throws Exception {
                        mView.hideProgressbar();
                        mView.showAllMusic(tracks);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                        mView.showError(throwable);
                        mView.hideProgressbar();
                    }
                });
        mCompositeDisposable.add(disposable);
    }

    @Override
    public void getAllAudio() {
        Disposable disposable = mSongRepository.getTracks(MusicConstants.KIND,
                MusicUtils.createQueryGenre(MusicConstants.GENRE_ALLAUDIO),
                MusicConstants.CLIENT_ID, MusicConstants.LIMIT, MusicConstants.OFFSET).
                subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        mView.showProgressbar();
                    }
                }).map(new Function<BaseResponse, List<Track>>() {
                    @Override
                    public List<Track> apply(BaseResponse baseResponse) throws Exception {
                        List<Track> tracks = new ArrayList<>();
                        for (int i = 0; i < baseResponse.getTrackList().size(); i++) {
                            tracks.add(baseResponse.getTrackList().get(i).getTrack());
                        }
                        return tracks;
                    }
                }).subscribe(new Consumer<List<Track>>() {
                    @Override
                    public void accept(List<Track> tracks) throws Exception {
                        mView.hideProgressbar();
                        mView.showAllAudio(tracks);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.showError(throwable);
                        mView.hideProgressbar();
                    }
                });
        mCompositeDisposable.add(disposable);
    }

    @Override
    public void getAlternativerock() {
        Disposable disposable = mSongRepository.getTracks(MusicConstants.KIND,
                MusicUtils.createQueryGenre(MusicConstants.GENRE_ALTERNATIVEROC),
                MusicConstants.CLIENT_ID, MusicConstants.LIMIT, MusicConstants.OFFSET).
                subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        mView.showProgressbar();
                    }
                }).map(new Function<BaseResponse, List<Track>>() {
                    @Override
                    public List<Track> apply(BaseResponse baseResponse) throws Exception {
                        List<Track> tracks = new ArrayList<>();
                        for (int i = 0; i < baseResponse.getTrackList().size(); i++) {
                            tracks.add(baseResponse.getTrackList().get(i).getTrack());
                        }
                        return tracks;
                    }
                }).subscribe(new Consumer<List<Track>>() {
                    @Override
                    public void accept(List<Track> tracks) throws Exception {
                        mView.hideProgressbar();
                        mView.showAlternativerock(tracks);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.showError(throwable);
                        mView.hideProgressbar();
                    }
                });
        mCompositeDisposable.add(disposable);
    }

    @Override
    public void getAmbient() {
        Disposable disposable = mSongRepository.getTracks(MusicConstants.KIND,
                MusicUtils.createQueryGenre(MusicConstants.GENRE_AMBIENT),
                MusicConstants.CLIENT_ID, MusicConstants.LIMIT, MusicConstants.OFFSET).
                subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        mView.showProgressbar();
                    }
                }).map(new Function<BaseResponse, List<Track>>() {
                    @Override
                    public List<Track> apply(BaseResponse baseResponse) throws Exception {
                        List<Track> tracks = new ArrayList<>();
                        for (int i = 0; i < baseResponse.getTrackList().size(); i++) {
                            tracks.add(baseResponse.getTrackList().get(i).getTrack());
                        }
                        return tracks;
                    }
                }).subscribe(new Consumer<List<Track>>() {
                    @Override
                    public void accept(List<Track> tracks) throws Exception {
                        mView.hideProgressbar();
                        mView.showAmbient(tracks);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.showError(throwable);
                        mView.hideProgressbar();
                    }
                });
        mCompositeDisposable.add(disposable);
    }

    @Override
    public void getClassical() {
        Disposable disposable = mSongRepository.getTracks(MusicConstants.KIND,
                MusicUtils.createQueryGenre(MusicConstants.GENRE_CLASSICAL),
                MusicConstants.CLIENT_ID, MusicConstants.LIMIT, MusicConstants.OFFSET).
                subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        mView.showProgressbar();
                    }
                }).map(new Function<BaseResponse, List<Track>>() {
                    @Override
                    public List<Track> apply(BaseResponse baseResponse) throws Exception {
                        List<Track> tracks = new ArrayList<>();
                        for (int i = 0; i < baseResponse.getTrackList().size(); i++) {
                            tracks.add(baseResponse.getTrackList().get(i).getTrack());
                        }
                        return tracks;
                    }
                }).subscribe(new Consumer<List<Track>>() {
                    @Override
                    public void accept(List<Track> tracks) throws Exception {
                        mView.hideProgressbar();
                        mView.showClassical(tracks);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.showError(throwable);
                        mView.hideProgressbar();
                    }
                });
        mCompositeDisposable.add(disposable);
    }

    @Override
    public void getCountry() {
        Disposable disposable = mSongRepository.getTracks(MusicConstants.KIND,
                MusicUtils.createQueryGenre(MusicConstants.GENRE_COUNTRY),
                MusicConstants.CLIENT_ID, MusicConstants.LIMIT, MusicConstants.OFFSET).
                subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        mView.showProgressbar();
                    }
                }).map(new Function<BaseResponse, List<Track>>() {
                    @Override
                    public List<Track> apply(BaseResponse baseResponse) throws Exception {
                        List<Track> tracks = new ArrayList<>();
                        for (int i = 0; i < baseResponse.getTrackList().size(); i++) {
                            tracks.add(baseResponse.getTrackList().get(i).getTrack());
                        }
                        return tracks;
                    }
                }).subscribe(new Consumer<List<Track>>() {
                    @Override
                    public void accept(List<Track> tracks) throws Exception {
                        mView.hideProgressbar();
                        mView.showCountry(tracks);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.d("kiemtraerro", mView + "");
                        mView.showError(throwable);
                        mView.hideProgressbar();
                    }
                });
        mCompositeDisposable.add(disposable);
    }
}
