package io.vinson.music.api.platform;

import io.vinson.music.api.domain.MusicInfo;

import java.util.List;

/**
 * @author: jiangweixin
 * @date: 2020/5/7
 */
public interface Platform {

    public List<MusicInfo> search(String keyword);

    public void song(String id);

    public void lyric(String id);

}
