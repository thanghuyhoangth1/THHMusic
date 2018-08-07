package hmusic.music.hoang.com.thhmusic.screen;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract  class BaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView=inflater.inflate(getResource(),container,false);
        initComps(rootView,savedInstanceState);
        addEvent();
        return rootView;
    }

    protected abstract void addEvent();

    protected abstract void initComps(View rootView, Bundle savedInstanceState);

    public abstract int getResource();
}
