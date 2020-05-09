package io.vinson.music.api.platform;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.vinson.music.api.domain.MusicInfo;
import io.vinson.music.api.domain.RequestBody;
import io.vinson.music.api.service.HtmlFetcherService;
import io.vinson.music.api.util.encode.Base64Util;
import io.vinson.music.api.util.encode.MD5Util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: jiangweixin
 * @date: 2020/5/8
 *
 */
public class KugouPlatform extends AbstractPlatform {

    @Override
    public RequestBody handleRequestBody(String keyword) {
        RequestBody requestBody = new RequestBody();
        requestBody.setMethod("GET");
        requestBody.setUrl("http://mobilecdn.kugou.com/api/v3/search/song");

        JsonObject params = new JsonObject();
        params.addProperty("keyword", keyword);
        params.addProperty("page", "1");
        params.addProperty("pagesize", "20");
        params.addProperty("api_ver", "1");
        params.addProperty("area_code", "1");
        params.addProperty("correct", "1");
        params.addProperty("plat", "2");
        params.addProperty("tag", "1");
        params.addProperty("sver", "5");
        params.addProperty("showtype", "10");
        params.addProperty("version", "8990");
        requestBody.setParams(params);
        return requestBody;
    }

    @Override
    public List<MusicInfo> formatSearchResult(String res) {
        List<MusicInfo> list = new ArrayList<>();
        JsonParser parse = new JsonParser();  //创建json解析器

        JsonObject json = (JsonObject) parse.parse(res);

        JsonObject j = new JsonObject();

        JsonArray array = json.get("data").getAsJsonObject().get("info").getAsJsonArray();

        for(int i = 0; i < array.size(); i++) {
            JsonObject subJson = array.get(i).getAsJsonObject();
            MusicInfo musicInfo = new MusicInfo();
            musicInfo.setSource("kugou");
            musicInfo.setId(subJson.get("hash").getAsString());
            musicInfo.setName(subJson.get("songname").getAsString());
            musicInfo.setLyricId(subJson.get("hash").getAsString());
            musicInfo.setUrlId(subJson.get("hash").getAsString());
            musicInfo.setPicId(subJson.get("hash").getAsString());
            musicInfo.setAlbum(subJson.get("album_name").getAsString());

            musicInfo.setArtist(new ArrayList<>());
            musicInfo.getArtist().add(subJson.get("singername").getAsString());
            list.add(musicInfo);
            System.out.println(musicInfo);
        }
        return list;
    }


    public void url(String id) {
        RequestBody requestBody = new RequestBody();
        requestBody.setMethod("POST");
        requestBody.setUrl("http://media.store.kugou.com/v1/get_res_privilege");

        JsonObject params = new JsonObject();
        params.addProperty("relate", "1");
        params.addProperty("userid", "0");
        params.addProperty("vip", "1");
        params.addProperty("appid", "1000");
        params.addProperty("token", "");
        params.addProperty("behavior", "download");
        params.addProperty("area_code", "1");
        params.addProperty("clientver", "8990");
        JsonArray element = new JsonArray();
        JsonObject resource = new JsonObject();
        resource.addProperty("id", 0);
        resource.addProperty("type", "audio");
        resource.addProperty("hash", id);
        element.add(resource);
        params.add("resource", element);
        requestBody.setParams(params);
        try {
            String res = HtmlFetcherService.exec(requestBody);

            System.out.println(res);
            JsonParser parse = new JsonParser();  //创建json解析器
            JsonObject json = (JsonObject) parse.parse(res);

            int max = 0;
            String url = "";

            JsonArray relateGoods = json.get("data").getAsJsonArray().get(0).getAsJsonObject().get("relate_goods").getAsJsonArray();

            for (int i = 0; i < relateGoods.size(); i++) {
                JsonElement vo = relateGoods.get(i);
                int bitRate = vo.getAsJsonObject().get("info").getAsJsonObject().get("bitrate").getAsInt();
                if(bitRate > max) {
                    RequestBody reqUrlBody = new RequestBody();
                    reqUrlBody.setMethod("GET");
                    reqUrlBody.setUrl("http://trackercdn.kugou.com/i/v2/");

                    JsonObject urlParams = new JsonObject();
                    urlParams.addProperty("hash", vo.getAsJsonObject().get("hash").getAsString());
                    urlParams.addProperty("key", MD5Util.encode(vo.getAsJsonObject().get("hash").getAsString() + "kgcloudv2"));
                    urlParams.addProperty("pid", "3");
                    urlParams.addProperty("behavior", "play");
                    urlParams.addProperty("cmd", "25");
                    urlParams.addProperty("version", "8990");
                    reqUrlBody.setParams(urlParams);

                    res = HtmlFetcherService.exec(reqUrlBody);
                    System.out.println(res);
                    json = (JsonObject) parse.parse(res);

                    if(json.get("url") != null) {
                        max = json.get("bitRate").getAsInt() / 1000;
                        url = json.get("url").getAsJsonArray().get(0).getAsString();
                    }
                }
            }

            System.out.println(url);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void lyric(String id) {
        RequestBody requestBody = new RequestBody();
        requestBody.setMethod("GET");
        requestBody.setUrl("http://krcs.kugou.com/search");

        JsonObject params = new JsonObject();
        params.addProperty("keyword", "%20-%20");
        params.addProperty("ver", "1");
        params.addProperty("hash", id);
        params.addProperty("client", "mobi");
        params.addProperty("man", "yes");
        requestBody.setParams(params);
        try {
            String res = HtmlFetcherService.exec(requestBody);

            JsonParser parse = new JsonParser();  //创建json解析器
            JsonObject json = (JsonObject) parse.parse(res);

            RequestBody reqLyricBody = new RequestBody();
            reqLyricBody.setMethod("GET");
            reqLyricBody.setUrl("http://lyrics.kugou.com/download");

            JsonObject reqLyricParams = new JsonObject();
            reqLyricParams.addProperty("charset", "utf8");
            reqLyricParams.addProperty("ver", "1");
            reqLyricParams.addProperty("accesskey", json.get("candidates").getAsJsonArray().get(0).getAsJsonObject().get("accesskey").getAsString());
            reqLyricParams.addProperty("id", json.get("candidates").getAsJsonArray().get(0).getAsJsonObject().get("id").getAsString());
            reqLyricParams.addProperty("client", "mobi");
            reqLyricParams.addProperty("fmt", "lrc");
            reqLyricParams.addProperty("man", "yes");
            reqLyricBody.setParams(reqLyricParams);
            res = HtmlFetcherService.exec(reqLyricBody);
            json = (JsonObject) parse.parse(res);
            String base64Lyric = json.get("content").getAsString();
            String lyricStr = Base64Util.decode(base64Lyric);
            System.out.println(lyricStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
