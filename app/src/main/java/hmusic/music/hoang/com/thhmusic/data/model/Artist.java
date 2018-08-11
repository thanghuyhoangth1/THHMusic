package hmusic.music.hoang.com.thhmusic.data.model;

import java.util.ArrayList;
import java.util.List;

public class Artist {
    private String mName;
    private int mCountTrack;
    private List<Track> mListTrack = new ArrayList<>();
    private String mArtistKey;

    public String getArtistKey() {
        return mArtistKey;
    }

    public void setArtistKey(String artistKey) {
        mArtistKey = artistKey;
    }

    public Artist() {
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getCountTrack() {
        return mCountTrack;
    }

    public void setCountTrack(int countTrack) {
        mCountTrack = countTrack;
    }

    public List<Track> getListTrack() {
        return mListTrack;
    }

    public void setListTrack(List<Track> listTrack) {
        mListTrack = listTrack;
    }

    public Artist(String name, int countTrack, List<Track> listTrack) {

        mName = name;
        mCountTrack = countTrack;
        mListTrack = listTrack;
    }
}
