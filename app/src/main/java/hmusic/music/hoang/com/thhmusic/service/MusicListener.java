package hmusic.music.hoang.com.thhmusic.service;

import hmusic.music.hoang.com.thhmusic.data.model.Track;

public interface MusicListener {
    void onMusicStart(Track track);

    void onMusicStop();

    void onMusicPause();

    void onMusicResume();

    void onBindSuccess(Track track, String state);
}
