package hmusic.music.hoang.com.thhmusic.utils.constants;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import hmusic.music.hoang.com.thhmusic.data.model.Album;
import hmusic.music.hoang.com.thhmusic.data.model.Artist;
import hmusic.music.hoang.com.thhmusic.data.model.Track;
import hmusic.music.hoang.com.thhmusic.data.model.User;
import hmusic.music.hoang.com.thhmusic.screen.offline.adapter.AlbumAdapter;
import io.reactivex.internal.operators.flowable.FlowableOnErrorReturn;

public class MusicUtils {
    public static String createQueryGenre(String genre) {
        return "soundcloud%3Agenres%3A" + genre;
    }

    public static List<Track> getLocalMusic(Context context) {
        List<Track> tracks = new ArrayList<>();
        String[] projection = {
                MediaStore.Audio.Media._ID,
                MediaStore.Audio.Media.ARTIST,
                MediaStore.Audio.Media.ARTIST_KEY,
                MediaStore.Audio.Media.TITLE,
                MediaStore.Audio.Media.DATA,
                MediaStore.Audio.Media.DISPLAY_NAME,
                MediaStore.Audio.Media.DURATION
        };

        String selection = MediaStore.Audio.Media.IS_MUSIC + " != 0";
        Uri URL = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        Cursor cursor = context.getContentResolver().query(URL, projection, selection, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String title = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE));
            long duration = cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media.DURATION));
            String uri = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));
            String artist = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST));
            String artistkey = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST_KEY));
            Track track = new Track();
            track.setTitle(title);
            track.setDuration(duration);
            track.setDownloadable(false);
            track.setURI(uri);
            User user = new User();
            user.setArtist(artist);
            user.setArtistKey(artistkey);
            track.setUser(user);
            tracks.add(track);
            cursor.moveToNext();
        }
        return tracks;
    }

    public static List<Artist> getAllArtis(Context context) {
        List<Artist> artistList = new ArrayList<>();
        String[] projection = {
                MediaStore.Audio.Artists.ARTIST,
                MediaStore.Audio.Artists._ID,
                MediaStore.Audio.Artists.NUMBER_OF_TRACKS,
        };
        Uri URL = MediaStore.Audio.Artists.EXTERNAL_CONTENT_URI;
        Cursor cursor = context.getContentResolver().query(URL, projection, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String name = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Artists.ARTIST));
            String artisKey = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Artists._ID));
            int countTrack = cursor.getInt(cursor.getColumnIndex(MediaStore.Audio.Artists.NUMBER_OF_TRACKS));
            Artist artist = new Artist();
            artist.setName(name);
            Uri artistAlbumURI = MediaStore.Audio.Albums.EXTERNAL_CONTENT_URI;
            String[] albumprojection = {
                    MediaStore.Audio.Albums.ALBUM_ART
            };
            Cursor albumCursor = context.getContentResolver().query(artistAlbumURI,
                    albumprojection,
                    MediaStore.Audio.Albums.ARTIST + " like ? ", new String[]{name},
                    null);
            Log.d("kiemtra", albumCursor.getCount() + "");
            if (albumCursor.getCount() > 1) {
                albumCursor.moveToFirst();
                artist.setArtisArt(albumCursor.getString(0));
            } else {
                artist.setArtisArt(null);
            }
            artist.setArtistKey(artisKey);
            artist.setCountTrack(countTrack);
            artistList.add(artist);
            cursor.moveToNext();
        }
        return artistList;
    }

    public static List<Album> getAllAlbum(Context context) {
        List<Album> albums = new ArrayList<>();
        String[] projection = {
                MediaStore.Audio.Albums.ALBUM_ART,
                MediaStore.Audio.Albums.ALBUM,
                MediaStore.Audio.Albums.NUMBER_OF_SONGS
        };
        Uri uri = MediaStore.Audio.Albums.EXTERNAL_CONTENT_URI;
        Cursor cursor = context.getContentResolver().query(uri, projection, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String name = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Albums.ALBUM));
            int count = cursor.getInt(cursor.getColumnIndex(MediaStore.Audio.Albums.NUMBER_OF_SONGS));
            String albumArt = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Albums.ALBUM_ART));
            albums.add(new Album(name, albumArt, count));
            cursor.moveToNext();
        }
        return albums;
    }
}
