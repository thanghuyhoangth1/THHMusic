package hmusic.music.hoang.com.thhmusic.data.source;

import hmusic.music.hoang.com.thhmusic.data.source.remote.api.BaseResponse;
import io.reactivex.Observable;

public interface SongDataSource {
    interface Local {
    }

    interface Remote {
        Observable<BaseResponse> getTracks(String kind, String genre,String clienID,int limit, int offset);
    }
}
