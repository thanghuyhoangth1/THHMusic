package hmusic.music.hoang.com.thhmusic.screen.main;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import hmusic.music.hoang.com.thhmusic.R;
import hmusic.music.hoang.com.thhmusic.screen.BaseActivity;
import hmusic.music.hoang.com.thhmusic.screen.main.adapter.MainAdapter;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private ImageView mImageSearch;
    private Toolbar mToolbar;


    @Override
    protected void addEvent() {
        mImageSearch.setOnClickListener(this);

    }

    @Override
    protected void initComps(Bundle savedInstanceState) {
        mTabLayout = findViewById(R.id.tabs);
        mViewPager = findViewById(R.id.viewpager);
        mImageSearch = findViewById(R.id.image_search);
        mToolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(mToolbar);

        MainAdapter mainAdapter = new MainAdapter(this, getSupportFragmentManager());
        mViewPager.setAdapter(mainAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
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
        }
    }
}
