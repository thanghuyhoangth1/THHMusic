package hmusic.music.hoang.com.thhmusic.screen.offline;

import dagger.Module;
import dagger.Provides;
import hmusic.music.hoang.com.thhmusic.data.source.local.SongLocalDataSource;
import hmusic.music.hoang.com.thhmusic.data.source.remote.SongRemoteDataSource;
import hmusic.music.hoang.com.thhmusic.data.source.remote.SongRepository;
import hmusic.music.hoang.com.thhmusic.utils.dagger.FragmentScope;

@Module
public class OfflineModule {
    @FragmentScope
    @Provides
    public OfflineContract.Presenter providerPresenter(SongRepository songRepository) {
        return new OfflinePresenter(songRepository);
    }

    @FragmentScope
    @Provides
    public SongRepository prpviderSongRepository(SongLocalDataSource songLocalDataSource,
                                                 SongRemoteDataSource remoteDataSource) {
        return new SongRepository(remoteDataSource, songLocalDataSource);
    }
}
