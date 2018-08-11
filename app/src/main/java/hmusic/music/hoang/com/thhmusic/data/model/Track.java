package hmusic.music.hoang.com.thhmusic.data.model;

import android.os.Parcel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Track {
    @Expose
    @SerializedName("uri")
    private String mURI;
    @Expose
    @SerializedName("artwork_url")
    private String mImage;
    @Expose
    @SerializedName("downloadable")
    private boolean mIsDownloadable;
    @Expose
    @SerializedName("download_url")
    private String mDownloadUrl;
    @Expose
    @SerializedName("duration")
    private long mDuration;
    @SerializedName("full_duration")
    private long mFullDuration;
    @Expose
    @SerializedName("title")
    private String mTitle;
    @Expose
    @SerializedName("user")
    private User mUser;

    public String getURI() {
        return mURI;
    }

    public void setURI(String URI) {
        mURI = URI;
    }

    public String getImage() {
        return mImage;
    }

    public void setImage(String image) {
        mImage = image;
    }

    public boolean isDownloadable() {
        return mIsDownloadable;
    }

    public void setDownloadable(boolean downloadable) {
        mIsDownloadable = downloadable;
    }

    public String getDownloadUrl() {
        return mDownloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        mDownloadUrl = downloadUrl;
    }

    public long getDuration() {
        return mDuration;
    }

    public void setDuration(long duration) {
        mDuration = duration;
    }

    public long getFullDuration() {
        return mFullDuration;
    }

    public void setFullDuration(long fullDuration) {
        mFullDuration = fullDuration;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public User getUser() {
        return mUser;
    }

    public void setUser(User user) {
        mUser = user;
    }

    public Track() {

    }
}
