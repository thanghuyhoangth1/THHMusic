package hmusic.music.hoang.com.thhmusic.screen.online;

import dagger.Module;
import dagger.Provides;
import hmusic.music.hoang.com.thhmusic.data.source.remote.SongRemoteDataSource;
import hmusic.music.hoang.com.thhmusic.data.source.remote.SongRepository;
import hmusic.music.hoang.com.thhmusic.utils.dagger.ActivityScope;
import hmusic.music.hoang.com.thhmusic.utils.dagger.FragmentScope;
import hmusic.music.hoang.com.thhmusic.utils.rx.BaseSchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class OnlineModule {
    @FragmentScope
    @Provides
    public OnlineFragmentContract.Presenter providePresenter(SongRepository songRepository,
                                                             BaseSchedulerProvider baseSchedulerProvider) {
        return new OnlinePresenter(songRepository, baseSchedulerProvider);
    }

    @FragmentScope
    @Provides
    public SongRepository proviSongRepository(SongRemoteDataSource remote) {
        return new SongRepository(remote);
    }
}
