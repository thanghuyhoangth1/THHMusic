package hmusic.music.hoang.com.thhmusic.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class MusicType implements Parcelable {
    private String mTitle;
    private List<Music> mData;

    public MusicType() {
    }

    public MusicType(String title, List<Music> data) {

        mTitle = title;
        mData = data;
    }

    protected MusicType(Parcel in) {
        mTitle = in.readString();
        mData = in.createTypedArrayList(Music.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mTitle);
        dest.writeTypedList(mData);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<MusicType> CREATOR = new Creator<MusicType>() {
        @Override
        public MusicType createFromParcel(Parcel in) {
            return new MusicType(in);
        }

        @Override
        public MusicType[] newArray(int size) {
            return new MusicType[size];
        }
    };

    public String getTitle() {

        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public List<Music> getData() {
        return mData;
    }

    public void setData(List<Music> data) {
        mData = data;
    }
}
