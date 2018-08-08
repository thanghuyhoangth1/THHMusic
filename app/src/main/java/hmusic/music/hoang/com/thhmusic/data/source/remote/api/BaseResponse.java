package hmusic.music.hoang.com.thhmusic.data.source.remote.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BaseResponse {
    @Expose
    @SerializedName("collection")
    public List<WrapTrack> mTrackList;
}
