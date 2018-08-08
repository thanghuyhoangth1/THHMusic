package hmusic.music.hoang.com.thhmusic.data.source.remote;

import java.util.List;

import hmusic.music.hoang.com.thhmusic.data.model.Track;
import hmusic.music.hoang.com.thhmusic.data.source.SongDataSource;

public class SongRepository implements SongDataSource.Remote {
    private SongRemoteDataSource mSongRemoteDataSource;

    public SongRepository(SongRemoteDataSource songRemoteDataSource) {
        mSongRemoteDataSource = songRemoteDataSource;
    }

    @Override
    public List<Track> getTracs() {
        return mSongRemoteDataSource.getTracs();
    }
}
