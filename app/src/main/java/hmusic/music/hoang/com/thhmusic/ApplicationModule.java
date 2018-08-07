package hmusic.music.hoang.com.thhmusic;

import android.content.Context;

import javax.inject.Scope;

import dagger.Module;
import dagger.Provides;
import hmusic.music.hoang.com.thhmusic.utils.dagger.AppScope;
import hmusic.music.hoang.com.thhmusic.utils.dagger.ApplicationContext;

@Module
public class ApplicationModule {

    private Context mContext;

    public ApplicationModule(Context mContext) {
        this.mContext = mContext;
    }

    @ApplicationContext
    @Provides
    @AppScope
    public Context provideApplicationContext() {
        return mContext;
    }

}
