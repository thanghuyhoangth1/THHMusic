package hmusic.music.hoang.com.thhmusic.screen.online;

import hmusic.music.hoang.com.thhmusic.screen.BasePresenter;

public interface OnlineFragmentContract {
    interface View {

    }

    interface Presenter extends BasePresenter<View> {
        void getSongs();
    }
}
