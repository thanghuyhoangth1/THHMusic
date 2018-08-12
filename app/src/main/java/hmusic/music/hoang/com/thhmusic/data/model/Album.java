package hmusic.music.hoang.com.thhmusic.data.model;

public class Album {
    private String mName;
    private String mAlbumArt;

    public int getNumberOfTrack() {
        return mNumberOfTrack;
    }

    public void setNumberOfTrack(int numberOfTrack) {
        mNumberOfTrack = numberOfTrack;
    }

    public Album(String name, String albumArt, int numberOfTrack) {

        mName = name;
        mAlbumArt = albumArt;
        mNumberOfTrack = numberOfTrack;
    }

    private int mNumberOfTrack;

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getAlbumArt() {
        return mAlbumArt;
    }

    public void setAlbumArt(String albumArt) {
        mAlbumArt = albumArt;
    }

    public Album() {

    }

    public Album(String name, String albumArt) {

        mName = name;
        mAlbumArt = albumArt;
    }
}
