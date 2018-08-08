package hmusic.music.hoang.com.thhmusic.data.source.remote.api;


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

}
