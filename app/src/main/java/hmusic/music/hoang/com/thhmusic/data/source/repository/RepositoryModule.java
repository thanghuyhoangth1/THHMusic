package hmusic.music.hoang.com.thhmusic.data.source.repository;

import dagger.Module;
import dagger.Provides;
import hmusic.music.hoang.com.thhmusic.utils.dagger.AppScope;
import hmusic.music.hoang.com.thhmusic.utils.rx.BaseSchedulerProvider;
import hmusic.music.hoang.com.thhmusic.utils.rx.SchedulerProvider;

@Module
public class RepositoryModule {
    @Provides
    @AppScope
    public BaseSchedulerProvider provideBaseSchedulerProvider() {
        return SchedulerProvider.getInstance();
    }
}
