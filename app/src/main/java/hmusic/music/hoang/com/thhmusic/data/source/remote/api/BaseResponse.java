package hmusic.music.hoang.com.thhmusic.data.source.remote.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BaseResponse {
    public List<WrapTrack> getTrackList() {
        return mTrackList;
    }

    public void setTrackList(List<WrapTrack> trackList) {
        mTrackList = trackList;
    }

    @Expose
    @SerializedName("collection")
    private List<WrapTrack> mTrackList;
}
