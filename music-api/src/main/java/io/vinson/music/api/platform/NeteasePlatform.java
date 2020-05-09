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
public class NeteasePlatform extends AbstractPlatform {

    @Override
    public RequestBody handleRequestBody(String keyword) {
        RequestBody requestBody = new RequestBody();
        requestBody.setMethod("POST");
        requestBody.setUrl("http://music.163.com/api/cloudsearch/pc");

        JsonObject params = new JsonObject();
        params.addProperty("s", keyword);
        params.addProperty("type", "1");
        params.addProperty("limit", "20");
        params.addProperty("total", "true");
        params.addProperty("offset", "0");
        requestBody.setParams(params);
        requestBody.setEncode("netease_AESCBC");
        requestBody.setFormat("result.songs");
        return requestBody;
    }


    @Override
    public List<MusicInfo> formatSearchResult(String res) {
        List<MusicInfo> list = new ArrayList<>();
        JsonParser parse = new JsonParser();  //创建json解析器

        JsonObject json = (JsonObject) parse.parse(res);

        JsonArray array = json.get("result").getAsJsonObject().get("songs").getAsJsonArray();

        for(int i = 0; i < array.size(); i++) {
            JsonObject subJson = array.get(i).getAsJsonObject();
            MusicInfo musicInfo = new MusicInfo();
            musicInfo.setSource("netease");
            musicInfo.setId(subJson.get("id").getAsString());
            musicInfo.setName(subJson.get("name").getAsString());
            musicInfo.setLyricId(subJson.get("id").getAsString());
            musicInfo.setUrlId(subJson.get("id").getAsString());
            JsonObject al = subJson.get("al").getAsJsonObject();
            musicInfo.setPicId(al.get("pic_str") != null ? al.get("pic_str").getAsString() : al.get("pic").getAsString());
            musicInfo.setAlbum(al.get("name").getAsString());

            JsonArray ar = subJson.get("ar").getAsJsonArray();
            musicInfo.setArtist(new ArrayList<>());
            for(int j = 0; j < ar.size(); j++) {
                musicInfo.getArtist().add(ar.get(j).getAsJsonObject().get("name").getAsString());
            }
            list.add(musicInfo);
            System.out.println(musicInfo);
        }
        return list;
    }

}
