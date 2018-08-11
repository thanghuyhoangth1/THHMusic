package hmusic.music.hoang.com.thhmusic.screen.offline;

import dagger.Component;
import hmusic.music.hoang.com.thhmusic.AppComponent;
import hmusic.music.hoang.com.thhmusic.utils.dagger.FragmentScope;

@FragmentScope
@Component(dependencies = AppComponent.class, modules = OfflineModule.class)
public interface OffliineComponent {
    void inject(OfflineFragment offlineFragment);
}
