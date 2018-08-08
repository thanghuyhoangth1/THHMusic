package hmusic.music.hoang.com.thhmusic.data.source;

import java.util.List;

import hmusic.music.hoang.com.thhmusic.data.model.Track;

public interface SongDataSource {
    interface Local {

    }

    interface Remote {
        List<Track> getTracs();
    }
}
