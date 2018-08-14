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
    private String mPlayLoopMode;
    private boolean mIsShufferMode;


    @Override
    public void onCreate() {
        mMediaPlayer = new MediaPlayer();
        mIsShufferMode = false;
        mPlayLoopMode = PLAY_MODE_LOOP_ALL;
        mState = MUSIC_STATE_STOPPING;
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
        switch (mPlayLoopMode) {
            case PLAY_MODE_LOOP_1:
                handleNextLoop1();
                break;
            case PLAY_MODE_LOOP_ALL:
                handleLoopNextAll();
                break;
            case PLAY_MODE_NON_LOOP:
                handleNextNonLoop();
                break;
        }

    }

    private void handleNextNonLoop() {
        if (mPositionTrack == (mPlayList.size() - 1)) {
            stopMusic();
        }
    }

    public Track getCurrentTrack() {
        return mPlayList != null ? mPlayList.get(mPositionTrack) : null;
    }

    private void handleLoopNextAll() {
        if (mPlayList == null) return;
        mPositionTrack++;
        if (mPositionTrack == mPlayList.size()) {
            mPositionTrack = 0;
        }
        playMusic(mPlayList.get(mPositionTrack));

    }

    private void handleNextLoop1() {
        playMusic(mPlayList.get(mPositionTrack));
    }

    public void previous() {
        if (mPlayList == null) return;
        mPositionTrack--;
        playMusic(mPlayList.get(mPositionTrack));
    }

    void stopMusic() {
        stopSelf();
        stopForeground(true);
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
        if (mPlayList == null) {
            mMusicListener.onBindSuccess(null, mState, mIsShufferMode, mPlayLoopMode);
            return;
        }
        mMusicListener.onBindSuccess(mPlayList.get(mPositionTrack), mState, mIsShufferMode, mPlayLoopMode);
    }

    public String getState() {
        return mState;
    }

    public int getCurrentPosition() {
        return mMediaPlayer.getCurrentPosition();
    }

    public void seek(int pos) {
        mMediaPlayer.seekTo(pos);
        mMediaPlayer.start();
        mMusicListener.onMusicSeek();

    }

    public int getDuration() {
        return mMediaPlayer == null ? 0 : mMediaPlayer.getDuration();
    }


    public String getPlayLoopMode() {
        return mPlayLoopMode;
    }

    public void setPlayLoopMode(String playLoopMode) {
        mPlayLoopMode = playLoopMode;
        mMusicListener.onLoopModeChange(playLoopMode);
    }

    public boolean isShufferMode() {
        return mIsShufferMode;
    }

    public void setShufferMode(boolean shufferMode) {
        mIsShufferMode = shufferMode;
        mMusicListener.onShuffleChange(shufferMode);
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
