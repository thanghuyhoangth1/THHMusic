package hmusic.music.hoang.com.thhmusic.screen;

import android.support.v7.widget.RecyclerView;

public interface OnBindDataChildRecycler<T> {
    void onBindData(RecyclerView recyclerView, T data);
}
