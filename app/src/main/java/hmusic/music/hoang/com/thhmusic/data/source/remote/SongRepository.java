package hmusic.music.hoang.com.thhmusic.data.source.remote;

import android.content.Context;

import java.util.List;

import hmusic.music.hoang.com.thhmusic.data.model.Album;
import hmusic.music.hoang.com.thhmusic.data.model.Artist;
import hmusic.music.hoang.com.thhmusic.data.model.Track;
import hmusic.music.hoang.com.thhmusic.data.source.SongDataSource;
import hmusic.music.hoang.com.thhmusic.data.source.local.SongLocalDataSource;
import hmusic.music.hoang.com.thhmusic.data.source.remote.api.BaseResponse;
import io.reactivex.Observable;

public class SongRepository implements SongDataSource.Remote, SongDataSource.Local {
    private SongRemoteDataSource mSongRemoteDataSource;
    private SongLocalDataSource mSongLocalDataSource;

    public SongRepository(SongRemoteDataSource songRemoteDataSource, SongLocalDataSource songLocalDataSource) {
        mSongRemoteDataSource = songRemoteDataSource;
        mSongLocalDataSource = songLocalDataSource;
    }

    @Override
    public Observable<BaseResponse> getTracks(String kind, String genre, String clienID, int limit, int offset) {
        return mSongRemoteDataSource.getTracks(kind, genre, clienID, limit, offset);
    }

    @Override
    public Observable<List<Track>> getAllMusic(Context context) {
        return mSongLocalDataSource.getAllMusic(context);
    }

    @Override
    public Observable<List<Album>> getAllAlbum(Context context) {
        return mSongLocalDataSource.getAllAlbum(context);
    }

    @Override
    public Observable<List<Artist>> getAllArtist(Context context) {
        return mSongLocalDataSource.getAllArtist(context);
    }
}
