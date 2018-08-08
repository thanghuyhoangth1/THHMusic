package hmusic.music.hoang.com.thhmusic.data.source.remote;

import hmusic.music.hoang.com.thhmusic.data.source.SongDataSource;
import hmusic.music.hoang.com.thhmusic.data.source.remote.api.BaseResponse;
import io.reactivex.Observable;
import io.reactivex.Observer;

public class SongRepository implements SongDataSource.Remote {
    private SongRemoteDataSource mSongRemoteDataSource;

    public SongRepository(SongRemoteDataSource songRemoteDataSource) {
        mSongRemoteDataSource = songRemoteDataSource;
    }

    @Override
    public Observable<BaseResponse> getTracks(String kind, String genre, String clienID, int limit, int offset) {
        return mSongRemoteDataSource.getTracks(kind, genre, clienID, limit, offset);
    }
}
