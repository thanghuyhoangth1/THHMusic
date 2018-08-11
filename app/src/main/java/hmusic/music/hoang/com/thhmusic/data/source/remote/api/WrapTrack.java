package hmusic.music.hoang.com.thhmusic.data.source.remote.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import hmusic.music.hoang.com.thhmusic.data.model.Track;

public class WrapTrack {
    public Track getTrack() {
        return mTrack;
    }

    public void setTrack(Track track) {
        mTrack = track;
    }
    @Expose
    @SerializedName("track")
    private Track mTrack;
}
