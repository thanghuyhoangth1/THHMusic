package hmusic.music.hoang.com.thhmusic.screen;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

public abstract class BaseActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getResource());
        initComps(savedInstanceState);
        addEvent();
    }

    protected abstract void addEvent();

    protected abstract void initComps(Bundle savedInstanceState);

    public abstract int getResource();
}
