package hmusic.music.hoang.com.thhmusic.screen;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.View;

import hmusic.music.hoang.com.thhmusic.R;

public class SearchFragment extends BaseFragment {
    private SearchView mSearchView;
    private RecyclerView mRecyclerResult;

    @Override
    protected void addEvent() {

    }

    @Override
    protected void initComps(View rootView, Bundle savedInstanceState) {
        findView(rootView);
    }

    private void findView(View rootView) {
        mSearchView = rootView.findViewById(R.id.searchview);
        mRecyclerResult = rootView.findViewById(R.id.recycler_result);
    }

    @Override
    public int getResource() {
        return R.layout.fragment_search;
    }
}
