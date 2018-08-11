package hmusic.music.hoang.com.thhmusic.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {
    @Expose
    @SerializedName("avatar_url")
    private String mAvatarUrl;

    private String mArtistKey;

    public String getArtistKey() {
        return mArtistKey;
    }

    public void setArtistKey(String artistKey) {
        mArtistKey = artistKey;
    }

    @Expose
    @SerializedName("username")
    private String mArtist;

    public User() {
    }

    public String getAvatarUrl() {
        return mAvatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        mAvatarUrl = avatarUrl;
    }

    public String getArtist() {
        return mArtist;
    }

    public void setArtist(String artist) {
        mArtist = artist;
    }

    public User(String avatarUrl, String artist) {

        mAvatarUrl = avatarUrl;
        mArtist = artist;
    }
}
