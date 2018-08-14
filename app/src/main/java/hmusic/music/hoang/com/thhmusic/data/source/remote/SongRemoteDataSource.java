package hmusic.music.hoang.com.thhmusic.data.source.remote;

import java.util.List;

import javax.inject.Inject;

import hmusic.music.hoang.com.thhmusic.data.model.Track;
import hmusic.music.hoang.com.thhmusic.data.source.SongDataSource;
import hmusic.music.hoang.com.thhmusic.data.source.remote.api.BaseResponse;
import hmusic.music.hoang.com.thhmusic.utils.retrofit.RetrofitUtils;
import io.reactivex.Observable;

public class SongRemoteDataSource implements SongDataSource.Remote {
    @Inject
    public SongRemoteDataSource() {
    }

    @Override
    public Observable<BaseResponse> getTracks(String kind, String genre, String clienID, int limit, int offset) {
        return RetrofitUtils.getRetrofit().getTracks(kind, genre, clienID, limit, offset);
    }

    @Override
    public Observable<List<Track>> searchTrack(String query) {
        return RetrofitUtils.getRetrofitSearch().searchTracks(query);
    }


}
