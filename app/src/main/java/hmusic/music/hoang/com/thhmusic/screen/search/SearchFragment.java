package hmusic.music.hoang.com.thhmusic.screen.search;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import hmusic.music.hoang.com.thhmusic.MainApplication;
import hmusic.music.hoang.com.thhmusic.R;
import hmusic.music.hoang.com.thhmusic.data.model.Track;
import hmusic.music.hoang.com.thhmusic.screen.BaseFragment;
import hmusic.music.hoang.com.thhmusic.screen.OnRecyclerViewClickListener;
import hmusic.music.hoang.com.thhmusic.screen.main.MainActivity;
import hmusic.music.hoang.com.thhmusic.screen.search.adapter.SearchResultAdapter;
import hmusic.music.hoang.com.thhmusic.service.PlayMusicService;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

public class SearchFragment extends BaseFragment implements SearchContract.View,
        SearchView.OnQueryTextListener,
        OnRecyclerViewClickListener<Track> {
    private SearchView mSearchView;
    private RecyclerView mRecyclerResult;
    private ProgressBar mProgressBar;
    private PublishSubject<String> mSubject;
    private CompositeDisposable mCompositeDisposable;
    private MainActivity mParentActivity;

    @Inject
    SearchContract.Presenter mPresenter;

    @Override
    protected void addEvent() {
        mSearchView.setOnQueryTextListener(this);
    }

    @Override
    protected void initComps(View rootView, Bundle savedInstanceState) {
        findView(rootView);
        DaggerSearchComponent.builder()
                .appComponent(((MainApplication) getActivity().getApplication()).getAppComponent())
                .searchModule(new SearchModule())
                .build().inject(this);
        mPresenter.setView(this);
        Disposable disposable = mSubject.subscribeOn(Schedulers.io()).
                debounce(1000, TimeUnit.MILLISECONDS)
                .filter(new Predicate<String>() {
                    @Override
                    public boolean test(String s) throws Exception {
                        return s.isEmpty() ? false : true;
                    }
                })
                .distinctUntilChanged()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        mPresenter.search(s);
                    }
                });
        mCompositeDisposable.add(disposable);
    }

    private void findView(View rootView) {
        mCompositeDisposable = new CompositeDisposable();
        mSubject = PublishSubject.create();
        mSearchView = rootView.findViewById(R.id.searchview);
        mRecyclerResult = rootView.findViewById(R.id.recycler_result);
        mProgressBar = rootView.findViewById(R.id.progressbar);
        mParentActivity = (MainActivity) getActivity();
    }

    @Override
    public int getResource() {
        return R.layout.fragment_search;
    }

    @Override
    public void showProgressBar() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void showResult(List<Track> list) {
        SearchResultAdapter searchResultAdapter = new SearchResultAdapter(getActivity(), list, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerResult.setAdapter(searchResultAdapter);
        mRecyclerResult.setLayoutManager(layoutManager);
    }

    @Override
    public void showError(Throwable throwable) {
        Toast.makeText(getActivity(), throwable.getMessage(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        mSubject.onComplete();
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        mSubject.onNext(s);
        return false;
    }

    @Override
    public void onClick(List<Track> list, int pos) {
        Intent intent = new Intent(getActivity(), PlayMusicService.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(PlayMusicService.INTENT_TRACK, list.get(pos));
        bundle.putInt(PlayMusicService.INTENT_POSITION_TRACK, pos);
        intent.putExtras(bundle);
        getActivity().startService(intent);
        if (mParentActivity != null) {
            mParentActivity.setMusicPlayList(list);
        }
    }
}
