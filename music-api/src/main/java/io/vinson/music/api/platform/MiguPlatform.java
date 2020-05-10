package io.vinson.music.api.platform;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.vinson.music.api.domain.MusicInfo;
import io.vinson.music.api.domain.RequestBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: jiangweixin
 * @date: 2020/5/8
 */
public class MiguPlatform extends AbstractPlatform {

    public static final int TYPE_SINGER = 1;
    public static final int TYPE_SONG = 2;
    public static final int TYPE_UNKNOWN = 3;
    public static final int TYPE_ALBUM = 4;
    public static final int TYPE_PLAYLIST = 5;
    public static final int TYPE_MV = 6;
    public static final int TYPE_LYRIC = 7;

    @Override
    public RequestBody handleRequestBody(String keyword) {
        RequestBody requestBody = new RequestBody();
        requestBody.setMethod("GET");
        requestBody.setUrl("http://m.music.migu.cn/migu/remoting/scr_search_tag");

        JsonObject params = new JsonObject();
        params.addProperty("keyword", keyword);
        params.addProperty("type", TYPE_SONG);
        params.addProperty("pgc", "1");
        params.addProperty("rows", "20");
        requestBody.setParams(params);
        return requestBody;
    }

    @Override
    public List<MusicInfo> formatSearchResult(String res) {
        List<MusicInfo> list = new ArrayList<>();
        JsonParser parse = new JsonParser();  //创建json解析器

        JsonObject json = (JsonObject) parse.parse(res);

        JsonArray array = json.get("musics").getAsJsonArray();

        for(int i = 0; i < array.size(); i++) {
            JsonObject subJson = array.get(i).getAsJsonObject();
            MusicInfo musicInfo = new MusicInfo();
            musicInfo.setSource("migu");
            musicInfo.setId(subJson.get("id").getAsString());
            musicInfo.setName(subJson.get("songName").getAsString());
            musicInfo.setAddr(subJson.get("mp3").isJsonNull() ? "" : subJson.get("mp3").getAsString());
            musicInfo.setLyricId(subJson.get("lyrics").getAsString());
            musicInfo.setUrlId(subJson.get("id").getAsString());
            musicInfo.setPicId(subJson.get("albumId").getAsString());
            musicInfo.setAlbum(subJson.get("albumName").getAsString());
            musicInfo.setArtist(new ArrayList<>());
            musicInfo.getArtist().add(subJson.getAsJsonObject().get("singerName").getAsString());
            list.add(musicInfo);
            System.out.println(musicInfo);
        }
        return list;
    }
}
