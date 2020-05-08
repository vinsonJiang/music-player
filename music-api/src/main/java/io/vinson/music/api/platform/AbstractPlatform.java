package io.vinson.music.api.platform;

import io.vinson.music.api.domain.MusicInfo;
import io.vinson.music.api.domain.RequestBody;
import io.vinson.music.api.service.HtmlFetcherService;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * @author: jiangweixin
 * @date: 2020/5/8
 */
public abstract class AbstractPlatform implements Platform {

    @Override
    public List<MusicInfo> search(String keyword) {
        RequestBody requestBody = handleRequestBody(keyword);
        try {
            String res = HtmlFetcherService.exec(requestBody);
            List<MusicInfo> result = formatSearchResult(res);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }

    @Override
    public void song(String id) {

    }

    @Override
    public void lyric(String id) {

    }


    public abstract RequestBody handleRequestBody(String keyword);

    public abstract List<MusicInfo> formatSearchResult(String res);

}
