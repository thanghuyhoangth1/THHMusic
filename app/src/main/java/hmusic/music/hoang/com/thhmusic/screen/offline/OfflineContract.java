package hmusic.music.hoang.com.thhmusic.screen.offline;

import android.content.Context;

import java.util.List;

import hmusic.music.hoang.com.thhmusic.data.model.Album;
import hmusic.music.hoang.com.thhmusic.data.model.Artist;
import hmusic.music.hoang.com.thhmusic.data.model.Track;
import hmusic.music.hoang.com.thhmusic.screen.BasePresenter;

public interface OfflineContract {
    interface View {
        void showError(Throwable throwable);

        void showProgressBar();

        void hideProgressBar();

        void showAllSong(List<Track> listTrack);

        void showAllArtis(List<Artist> list);

        void showAllAlbum(List<Album> list);
    }

    interface Presenter extends BasePresenter<View> {
        void getAllSong(Context context);

        void getAllArtist(Context context);

        void getAllAlbum(Context context);
    }
}
