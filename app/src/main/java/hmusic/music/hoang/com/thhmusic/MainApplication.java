package hmusic.music.hoang.com.thhmusic;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;

import hmusic.music.hoang.com.thhmusic.data.source.repository.RepositoryModule;

public class MainApplication extends Application {

    private AppComponent mAppComponent;

    public AppComponent getAppComponent() {
        if (mAppComponent == null) {
            mAppComponent = DaggerAppComponent.builder()
                    .applicationModule(new ApplicationModule(getApplicationContext()))
                    .repositoryModule(new RepositoryModule())
                    .build();
        }
        return mAppComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

    }
}
