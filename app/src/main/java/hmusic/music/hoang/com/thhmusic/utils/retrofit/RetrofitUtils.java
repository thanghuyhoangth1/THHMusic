package hmusic.music.hoang.com.thhmusic.utils.retrofit;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import hmusic.music.hoang.com.thhmusic.data.source.remote.api.Api;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtils {
    public static final String BASE_URL = "https://api-v2.soundcloud.com";

    public static Api getRetrofit() {
        Retrofit retrofi = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofi.create(Api.class);
    }
}
