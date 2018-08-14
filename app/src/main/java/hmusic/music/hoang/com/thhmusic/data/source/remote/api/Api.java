package hmusic.music.hoang.com.thhmusic.data.source.remote.api;


import java.util.List;

import hmusic.music.hoang.com.thhmusic.data.model.Track;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    @GET("/charts")
    Observable<BaseResponse> getTracks(@Query("kind") String kind,
                                       @Query("genre") String genre,
                                       @Query("client_id") String clienID,
                                       @Query("limit") int limit,
                                       @Query("offset") int offset);

    @GET("/tracks?filter=public&limit=100&client_id=a7Ucuq0KY8Ksn8WzBG6wj4x6pcId6BpU&")
    Observable<List<Track>> searchTracks(@Query("q") String query);
}
