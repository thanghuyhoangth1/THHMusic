package hmusic.music.hoang.com.thhmusic.screen.main.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import hmusic.music.hoang.com.thhmusic.R;
import hmusic.music.hoang.com.thhmusic.screen.offline.OfflineFragment;
import hmusic.music.hoang.com.thhmusic.screen.online.OnlineFragment;

public class MainAdapter extends FragmentPagerAdapter {
    private List<Fragment> mListFragment;
    private List<String> mListTitle;
    private Context mContext;

    public MainAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
        creatFragment();
        creatTitle();
    }

    private void creatTitle() {
        mListTitle = new ArrayList<>();
        mListTitle.add(mContext.getString(R.string.title_online));
        mListTitle.add(mContext.getString(R.string.title_offline));
    }

    private void creatFragment() {
        mListFragment = new ArrayList<>();
        mListFragment.add(new OnlineFragment());
        mListFragment.add(new OfflineFragment());
    }

    @Override
    public Fragment getItem(int i) {
        return mListFragment.get(i);
    }

    @Override
    public int getCount() {
        return mListFragment.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mListTitle.get(position);
    }
}
