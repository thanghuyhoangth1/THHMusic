package hmusic.music.hoang.com.thhmusic.service;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.io.IOException;
import java.util.List;

import hmusic.music.hoang.com.thhmusic.R;
import hmusic.music.hoang.com.thhmusic.data.model.Track;
import hmusic.music.hoang.com.thhmusic.screen.main.MainActivity;
import hmusic.music.hoang.com.thhmusic.utils.constants.MusicUtils;

public class PlayMusicService extends Service implements MediaPlayer.OnPreparedListener {
    private MediaPlayer mMediaPlayer;
    private List<Track> mPlayList;
    public static final String ACTION_PLAY = "play";
    public static final String ACTION_PAUSE = "pause";
    public static final String ACTION_RESUME = "resume";
    public static final String ACTION_NEXT = "next";
    public static final String ACTION_PREVIOUS = "previous";
    public static final String ACTION_STOP = "stop";
    public static final String BUNDLE_PLAY_MUSIC = "playmusic";
    public static final String INTENT_TRACK = "track";
    public static final String INTENT_POSITION_TRACK = "positiontrack";
    public static final String MUSIC_STATE_PLAYING = "stateplay";
    public static final String MUSIC_STATE_STOPPING = "statestop";
    public static final String PLAY_MODE_LOOP_1 = "loop one";
    public static final String PLAY_MODE_LOOP_ALL = "loop all";
    public static final String PLAY_MODE_NON_LOOP = "non loop";
    private Notification mNotification;
    private String mState;
    private int mPositionTrack;
    private MusicListener mMusicListener;
    private IBinder mIBinder = new LocalBinder();
    private String mPlayMode;


    @Override
    public void onCreate() {
        mMediaPlayer = new MediaPlayer();
        super.onCreate();
    }

    public void setMusicListener(MusicListener musicListener) {
        mMusicListener = musicListener;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mIBinder;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        handleIntent(intent);
        return START_STICKY;
    }

    private void handleIntent(Intent intent) {
        Bundle bundle = intent.getExtras();
        mPositionTrack = bundle.getInt(INTENT_POSITION_TRACK);
        Track track = intent.getParcelableExtra(INTENT_TRACK);
        playMusic(track);
    }

    public List<Track> getPlayList() {
        return mPlayList;
    }

    public void setPlayList(List<Track> playList) {
        mPlayList = playList;
    }

    private void playMusic(Track track) {

        if (mMediaPlayer == null) return;
        mMediaPlayer.reset();
        mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mMediaPlayer.setDataSource(MusicUtils.createUri(track.getURI()));
            mMediaPlayer.prepareAsync();
            mMediaPlayer.setOnPreparedListener(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        startForeground(101, getNotification());
    }

    public void pause() {
        mMediaPlayer.pause();
        mState = MUSIC_STATE_STOPPING;
        mMusicListener.onMusicPause();
    }

    public void resume() {
        if (mMediaPlayer == null) return;
        mMediaPlayer.start();
        mState = MUSIC_STATE_PLAYING;
        mMusicListener.onMusicResume();
    }

    public void next() {
        if (mPlayList == null) return;
        mPositionTrack++;
        playMusic(mPlayList.get(mPositionTrack));
    }

    public void previous() {
        if (mPlayList == null) return;
        mPositionTrack--;
        playMusic(mPlayList.get(mPositionTrack));
    }

    private Notification getNotification() {

        @SuppressLint({"NewApi", "LocalSuppress"}) Notification notification = new Notification.Builder(this)
                .setSmallIcon(R.drawable.ic_launcher)
                .setContentTitle("Đường đến vinh quang")
                .setContentText("Bức tường")
                .setStyle(new Notification.MediaStyle())
                .build();
        return notification;
    }

    public void bindSuccess() {
        if (mPlayList == null) return;
        mMusicListener.onBindSuccess(mPlayList.get(mPositionTrack), mState);
    }

    public String getState() {
        return mState;
    }

    public void setState(String state) {
        mState = state;
    }

    public int getPositionTrack() {
        return mPositionTrack;
    }

    public void setPositionTrack(int positionTrack) {
        mPositionTrack = positionTrack;
    }

    @Override
    public void onPrepared(MediaPlayer mediaPlayer) {
        mMediaPlayer.start();
        mState = MUSIC_STATE_PLAYING;
        mMusicListener.onMusicStart(mPlayList.get(mPositionTrack));
    }

    public class LocalBinder extends Binder {
        public PlayMusicService getService() {
            return PlayMusicService.this;
        }
    }
}
