package hmusic.music.hoang.com.thhmusic.data.source.local;

import android.content.Context;

import java.util.List;

import javax.inject.Inject;

import hmusic.music.hoang.com.thhmusic.data.model.Artist;
import hmusic.music.hoang.com.thhmusic.data.model.Track;
import hmusic.music.hoang.com.thhmusic.data.source.SongDataSource;
import hmusic.music.hoang.com.thhmusic.utils.constants.MusicUtils;
import io.reactivex.Observable;

public class SongLocalDataSource implements SongDataSource.Local {
    @Inject
    public SongLocalDataSource() {
    }

    @Override
    public Observable<List<Track>> getAllMusic(Context context) {
        return Observable.just(MusicUtils.getLocalMusic(context));
    }

    @Override
    public void getAllAlbum() {

    }

    @Override
    public Observable<List<Artist>> getAllArtist(Context context) {
        return Observable.just(MusicUtils.getAllArtis(context));
    }
}
