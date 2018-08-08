package hmusic.music.hoang.com.thhmusic.screen.online;

import dagger.Component;
import hmusic.music.hoang.com.thhmusic.AppComponent;
import hmusic.music.hoang.com.thhmusic.utils.dagger.FragmentScope;

@FragmentScope
@Component(dependencies = AppComponent.class, modules = OnlineModule.class)
public interface OnlineComponent {
    void inject(OnlineFragment onlineComponent);
}
