package hmusic.music.hoang.com.thhmusic.screen.search;

import dagger.Component;
import hmusic.music.hoang.com.thhmusic.AppComponent;
import hmusic.music.hoang.com.thhmusic.utils.dagger.FragmentScope;

@FragmentScope
@Component(dependencies = AppComponent.class, modules = SearchModule.class)
public interface SearchComponent {
    void inject(SearchFragment searchFragment);
}
