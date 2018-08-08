package hmusic.music.hoang.com.thhmusic.data.source.remote;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import hmusic.music.hoang.com.thhmusic.data.model.Track;
import hmusic.music.hoang.com.thhmusic.data.source.SongDataSource;

public class SongRemoteDataSource implements SongDataSource.Remote {
    @Inject
    public SongRemoteDataSource() {

    }

    @Override
    public List<Track> getTracs() {
        List<Track> mListTrack = new ArrayList<>();
        mListTrack.add(new Track("Hoang", "Dep", "Trai"));
        mListTrack.add(new Track("Hoang", "Dep", "Trai"));
        mListTrack.add(new Track("Hoang", "Dep", "Trai"));
        return mListTrack;
    }
}
