package hmusic.music.hoang.com.thhmusic.screen;

public interface BasePresenter<T> {
    void onStart();

    void onStop();

    void setView(T view);
}
