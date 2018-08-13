package hmusic.music.hoang.com.thhmusic.screen.main;

import android.Manifest;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.media.Image;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import hmusic.music.hoang.com.thhmusic.R;
import hmusic.music.hoang.com.thhmusic.data.model.Track;
import hmusic.music.hoang.com.thhmusic.screen.BaseActivity;
import hmusic.music.hoang.com.thhmusic.screen.BaseRecyclerViewAdapter;
import hmusic.music.hoang.com.thhmusic.screen.main.adapter.MainAdapter;
import hmusic.music.hoang.com.thhmusic.service.MusicListener;
import hmusic.music.hoang.com.thhmusic.service.PlayMusicService;

public class MainActivity extends BaseActivity implements View.OnClickListener, MusicListener {
    private ImageView mImageSearch;
    private BottomSheetBehavior mBottomSheetBehavior;
    private View mBottomSheetCollapsedView;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private ImageView mImageDownload;
    private ImageView mImageShare;
    private ImageView mImagePrevious;
    private ImageView mImageNext;
    private ImageView mImagePlayPause;
    private Toolbar mToolbar;
    private ImageView mImageVolume;
    private ImageView mImageFavorite;
    private ImageView mImageSuffe;
    private ImageView mImagePreviousExpandable;
    private ImageView mImagePlayPauseExpandable;
    private ImageView mImageNextExpandable;
    private ImageView mImageLoop;
    private TextView mTextTitle;
    private TextView mTextArtist;
    private TextView mTextStartTime;
    private TextView mTextEndTime;
    private PlayMusicService mPlayMusicService;
    private boolean mIsBound = false;

    @Override
    protected void addEvent() {
        mImageSearch.setOnClickListener(this);
        mBottomSheetCollapsedView.setOnClickListener(this);
        mImagePlayPause.setOnClickListener(this);
        mImagePlayPauseExpandable.setOnClickListener(this);
        mImageNextExpandable.setOnClickListener(this);
        mImageNext.setOnClickListener(this);
        mImagePreviousExpandable.setOnClickListener(this);
        mImagePrevious.setOnClickListener(this);
        mBottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View view, int i) {
                switch (i) {
                    case BottomSheetBehavior.STATE_COLLAPSED:
                        handleCollapsedState();
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED:
                        handleExpandedState();
                        break;
                }
            }

            @Override
            public void onSlide(@NonNull View view, float v) {

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, PlayMusicService.class);
        bindService(intent, mConnection, BIND_AUTO_CREATE);
    }

    private void handleExpandedState() {
        mImagePlayPause.setVisibility(View.GONE);
        mImagePrevious.setVisibility(View.GONE);
        mImageNext.setVisibility(View.GONE);
        mImageDownload.setVisibility(View.VISIBLE);
        mImageShare.setVisibility(View.VISIBLE);

    }

    private void handleCollapsedState() {
        mImagePlayPause.setVisibility(View.VISIBLE);
        mImagePrevious.setVisibility(View.VISIBLE);
        mImageNext.setVisibility(View.VISIBLE);
        mImageDownload.setVisibility(View.GONE);
        mImageShare.setVisibility(View.GONE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 1) {
            if (grantResults.length == 1 &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(MainActivity.this, "Permision Write File is Granted", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Permision Write File is Denied", Toast.LENGTH_SHORT).show();

            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    public void initPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                //Permisson don't granted
                if (shouldShowRequestPermissionRationale(
                        Manifest.permission.READ_EXTERNAL_STORAGE)) {
                    Toast.makeText(MainActivity.this, "Permission isn't granted ", Toast.LENGTH_SHORT).show();
                }
                // Permisson don't granted and dont show dialog again.
                else {
                    Toast.makeText(MainActivity.this, "Permisson don't granted and dont show dialog again ", Toast.LENGTH_SHORT).show();
                }
                //Register permission
                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);

            }
        }
    }

    @Override
    protected void initComps(Bundle savedInstanceState) {
        initPermission();
        findView();
        setSupportActionBar(mToolbar);

        MainAdapter mainAdapter = new MainAdapter(this, getSupportFragmentManager());
        mViewPager.setAdapter(mainAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mBottomSheetBehavior = BottomSheetBehavior.from(mBottomSheetCollapsedView);
        mBottomSheetBehavior.setPeekHeight(180);
        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        handleCollapsedState();
    }

    private void findView() {
        mTabLayout = findViewById(R.id.tabs);
        mViewPager = findViewById(R.id.viewpager);
        mImageSearch = findViewById(R.id.image_search);
        mImageDownload = findViewById(R.id.image_download);
        mImageShare = findViewById(R.id.image_share);
        mImageNext = findViewById(R.id.image_next);
        mImagePrevious = findViewById(R.id.image_previous);
        mImagePlayPause = findViewById(R.id.image_play_pause);
        mBottomSheetCollapsedView = findViewById(R.id.bottom_sheet);
        mToolbar = findViewById(R.id.tool_bar);
        mTextTitle = findViewById(R.id.text_title);
        mTextArtist = findViewById(R.id.text_artis);
        mImageVolume = findViewById(R.id.image_volume);
        mImageFavorite = findViewById(R.id.image_favorite);
        mTextStartTime = findViewById(R.id.text_start_time);
        mTextEndTime = findViewById(R.id.text_end_time);
        mImageSuffe = findViewById(R.id.image_shuffe);
        mImagePreviousExpandable = findViewById(R.id.image_previous_expandable);
        mImagePlayPauseExpandable = findViewById(R.id.image_play_pause_expandable);
        mImageNextExpandable = findViewById(R.id.image_next_expandable);
        mImageLoop = findViewById(R.id.image_repeat);
    }

    @Override
    public int getResource() {
        return R.layout.activity_main;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.image_search:
                break;
            case R.id.bottom_sheet:
                mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                break;
            case R.id.image_play_pause:
                handlePlayPause();

                break;
            case R.id.image_play_pause_expandable:
                handlePlayPause();
                break;
            case R.id.image_next:
                handleNext();
                break;
            case R.id.image_next_expandable:
                handleNext();
                break;
            case R.id.image_previous:
                handlePrevious();
                break;
            case R.id.image_previous_expandable:
                handlePrevious();
                break;
        }
    }

    private void handlePrevious() {
        if (!mIsBound) return;
        mPlayMusicService.previous();
    }

    private void handleNext() {
        if (!mIsBound) return;
        mPlayMusicService.next();
    }
    private void handlePlayPause() {
        if (mIsBound) {
            switch (mPlayMusicService.getState()) {
                case PlayMusicService.MUSIC_STATE_PLAYING:
                    mPlayMusicService.pause();
                    break;
                case PlayMusicService.MUSIC_STATE_STOPPING:
                    mPlayMusicService.resume();
                    break;
            }
        }
    }


    @Override
    public void onMusicStart(Track track) {
        mImagePlayPause.setImageResource(R.drawable.ic_pause);
        mImagePlayPauseExpandable.setImageResource(R.drawable.ic_pause);
        mTextTitle.setText(track.getTitle());
        mTextArtist.setText(track.getUser().getArtist());
    }

    @Override
    public void onMusicStop() {

    }

    @Override
    public void onMusicPause() {
        mImagePlayPause.setImageResource(R.drawable.ic_play);
        mImagePlayPauseExpandable.setImageResource(R.drawable.ic_play);
    }

    @Override
    public void onMusicResume() {
        mImagePlayPauseExpandable.setImageResource(R.drawable.ic_pause);
        mImagePlayPause.setImageResource(R.drawable.ic_pause);
    }

    @Override
    public void onBindSuccess(Track track, String state) {
        mTextTitle.setText(track.getTitle());
        mTextArtist.setText(track.getUser().getArtist());
        switch (state) {
            case PlayMusicService.MUSIC_STATE_PLAYING:
                mImagePlayPauseExpandable.setImageResource(R.drawable.ic_pause);
                mImagePlayPause.setImageResource(R.drawable.ic_pause);
                break;
            case PlayMusicService.MUSIC_STATE_STOPPING:
                break;
        }
    }

    public void setMusicPlayList(List<Track> tracks) {
        if (mIsBound) {
            mPlayMusicService.setPlayList(tracks);
        }
    }

    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            PlayMusicService.LocalBinder binder = (PlayMusicService.LocalBinder) iBinder;
            mPlayMusicService = binder.getService();
            mIsBound = true;
            Log.d("kiemtra", "runnedmain");
            mPlayMusicService.setMusicListener(MainActivity.this);
            mPlayMusicService.bindSuccess();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };
}
