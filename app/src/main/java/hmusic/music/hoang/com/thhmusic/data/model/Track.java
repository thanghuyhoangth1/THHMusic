package hmusic.music.hoang.com.thhmusic.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import hmusic.music.hoang.com.thhmusic.utils.constants.MusicUtils;

public class Track implements Parcelable {
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

    protected Track(Parcel in) {
        mURI = in.readString();
        mImage = in.readString();
        mIsDownloadable = in.readByte() != 0;
        mDownloadUrl = in.readString();
        mDuration = in.readLong();
        mFullDuration = in.readLong();
        mTitle = in.readString();
        isOffline = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mURI);
        dest.writeString(mImage);
        dest.writeByte((byte) (mIsDownloadable ? 1 : 0));
        dest.writeString(mDownloadUrl);
        dest.writeLong(mDuration);
        dest.writeLong(mFullDuration);
        dest.writeString(mTitle);
        dest.writeByte((byte) (isOffline ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Track> CREATOR = new Creator<Track>() {
        @Override
        public Track createFromParcel(Parcel in) {
            return new Track(in);
        }

        @Override
        public Track[] newArray(int size) {
            return new Track[size];
        }
    };

    public boolean isOffline() {
        return isOffline;
    }

    public void setOffline(boolean offline) {
        isOffline = offline;
    }

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
    private boolean isOffline;

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
