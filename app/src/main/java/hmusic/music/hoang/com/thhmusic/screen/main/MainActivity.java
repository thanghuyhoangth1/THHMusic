package hmusic.music.hoang.com.thhmusic.screen.main;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import hmusic.music.hoang.com.thhmusic.R;
import hmusic.music.hoang.com.thhmusic.screen.BaseActivity;
import hmusic.music.hoang.com.thhmusic.screen.main.adapter.MainAdapter;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private ImageView mImageSearch;
    private Toolbar mToolbar;
    private BottomSheetBehavior mBottomSheetBehavior;
    private View mBottomSheetCollapsedView;
    private ImageView mImageDownload;
    private ImageView mImageShare;
    private ImageView mImagePrevious;
    private ImageView mImageNext;
    private ImageView mImagePlayPause;

    @Override
    protected void addEvent() {
        mImageSearch.setOnClickListener(this);
        mBottomSheetCollapsedView.setOnClickListener(this);
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
        setSupportActionBar(mToolbar);

        MainAdapter mainAdapter = new MainAdapter(this, getSupportFragmentManager());
        mViewPager.setAdapter(mainAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mBottomSheetBehavior = BottomSheetBehavior.from(mBottomSheetCollapsedView);
        mBottomSheetBehavior.setPeekHeight(210);
        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
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
        }
    }


}
