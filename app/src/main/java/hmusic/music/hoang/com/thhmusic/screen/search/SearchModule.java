package hmusic.music.hoang.com.thhmusic.screen.search;

import dagger.Module;
import dagger.Provides;
import hmusic.music.hoang.com.thhmusic.data.source.local.SongLocalDataSource;
import hmusic.music.hoang.com.thhmusic.data.source.remote.SongRemoteDataSource;
import hmusic.music.hoang.com.thhmusic.data.source.remote.SongRepository;
import hmusic.music.hoang.com.thhmusic.utils.dagger.FragmentScope;

@Module
public class SearchModule {
    @FragmentScope
    @Provides
    public SearchContract.Presenter providerSearchPresenter(SongRepository songRepository) {
        return new SearchPresenter(songRepository);
    }

    @FragmentScope
    @Provides
    public SongRepository providerSongRepository(SongLocalDataSource localDataSource,
                                                 SongRemoteDataSource songRemoteDataSource) {
        return new SongRepository(songRemoteDataSource, localDataSource);
    }
}
