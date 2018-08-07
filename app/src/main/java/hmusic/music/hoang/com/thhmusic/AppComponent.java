package hmusic.music.hoang.com.thhmusic;

import android.content.Context;

import dagger.Component;
import hmusic.music.hoang.com.thhmusic.data.source.repository.RepositoryModule;
import hmusic.music.hoang.com.thhmusic.utils.dagger.AppScope;
import hmusic.music.hoang.com.thhmusic.utils.dagger.ApplicationContext;
import hmusic.music.hoang.com.thhmusic.utils.rx.BaseSchedulerProvider;
@AppScope
@Component(modules = { ApplicationModule.class, RepositoryModule.class })
public interface AppComponent {
    @ApplicationContext
    Context applicationContext();

    BaseSchedulerProvider baseSchedulerProvider();
}
