package hmusic.music.hoang.com.thhmusic.screen;

import java.util.List;

public interface OnRecyclerViewClickListener<T> {
    void onClick(List<T> list,int pos);
}
