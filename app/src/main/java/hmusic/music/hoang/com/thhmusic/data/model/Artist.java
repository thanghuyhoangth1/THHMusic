package hmusic.music.hoang.com.thhmusic.data.model;

import java.util.ArrayList;
import java.util.List;

public class Artist {
    private String mName;
    private int mCountTrack;
    private String mArtistKey;

    public String getArtisArt() {
        return ArtisArt;
    }

    public void setArtisArt(String artisArt) {
        ArtisArt = artisArt;
    }

    private String ArtisArt;

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
}
