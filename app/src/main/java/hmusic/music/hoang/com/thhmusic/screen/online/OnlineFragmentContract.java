package hmusic.music.hoang.com.thhmusic.screen.online;

import java.util.List;

import hmusic.music.hoang.com.thhmusic.data.model.Track;
import hmusic.music.hoang.com.thhmusic.screen.BasePresenter;

public interface OnlineFragmentContract {
    interface View {
        void showProgressbar();

        void hideProgressbar();

        void showError(Throwable e);

        void showAllMusic(List<Track> tracks);

        void showAllAudio(List<Track> tracks);

        void showAmbient(List<Track> tracks);

        void showAlternativerock(List<Track> tracks);

        void showClassical(List<Track> tracks);

        void showCountry(List<Track> tracks);
    }

    interface Presenter extends BasePresenter<View> {
        void getAllMusic();

        void getAllAudio();

        void getAlternativerock();

        void getAmbient();

        void getClassical();

        void getCountry();
    }
}
