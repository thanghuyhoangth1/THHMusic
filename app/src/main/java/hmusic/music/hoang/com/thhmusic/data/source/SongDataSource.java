package hmusic.music.hoang.com.thhmusic.data.source;

import android.content.Context;

import java.util.List;

import hmusic.music.hoang.com.thhmusic.data.model.Artist;
import hmusic.music.hoang.com.thhmusic.data.model.Track;
import hmusic.music.hoang.com.thhmusic.data.source.remote.api.BaseResponse;
import io.reactivex.Observable;

public interface SongDataSource {
    interface Local {
        Observable<List<Track>> getAllMusic(Context context);

        void getAllAlbum();

        Observable<List<Artist>> getAllArtist(Context context);
    }

    interface Remote {
        Observable<BaseResponse> getTracks(String kind, String genre, String clienID, int limit, int offset);
    }
}
