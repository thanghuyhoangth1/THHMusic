package hmusic.music.hoang.com.thhmusic.screen.search;

import java.util.List;

import hmusic.music.hoang.com.thhmusic.data.model.Track;
import hmusic.music.hoang.com.thhmusic.screen.BasePresenter;

public interface SearchContract {
    interface View {
        void showProgressBar();

        void hideProgressBar();

        void showResult(List<Track> list);

        void showError(Throwable throwable);
    }

    interface Presenter extends BasePresenter<View> {
        void search(String query);

        void setView(View view);
    }
}
