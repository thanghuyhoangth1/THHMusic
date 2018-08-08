package hmusic.music.hoang.com.thhmusic.screen.online;

import dagger.Module;
import dagger.Provides;
import hmusic.music.hoang.com.thhmusic.data.source.remote.SongRemoteDataSource;
import hmusic.music.hoang.com.thhmusic.data.source.remote.SongRepository;
import hmusic.music.hoang.com.thhmusic.utils.dagger.FragmentScope;
@Module
public class OnlineModule {
    @FragmentScope
    @Provides
    public OnlineFragmentContract.Presenter providePresenter(SongRepository songRepository) {
        return new OnlinePresenter(songRepository);
    }

    @FragmentScope
    @Provides
    public SongRepository proviSongRepository(SongRemoteDataSource remote) {
        return new SongRepository(remote);
    }
}
