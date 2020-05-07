package io.vinson.music.api.util;

import java.util.Map;

/**
 * @author: jiangweixin
 * @date: 2020/5/8
 */
public class UrlBuilder {

    private StringBuilder hostBuilder;

    private Boolean hasParam;

    private Boolean canAddParam;

    private UrlBuilder(String host){
        this.hostBuilder = new StringBuilder(host);
        this.hasParam = false;
        this.canAddParam = true;
    }

    public static UrlBuilder builder(String host){
        return new UrlBuilder(host);
    }

    public UrlBuilder addParam(String key, String value){
        if (!canAddParam){
            throw new IllegalStateException("url builder error, not allow add param");
        }

        if (hasParam){
            hostBuilder.append("&" + key + "=" + value);
        }else {
            hostBuilder.append("?" + key + "=" + value);
        }
        this.hasParam=true;
        return this;
    }

    public UrlBuilder addParamMap(Map<String, String> paramMap){
        for(Map.Entry<String, String> entry : paramMap.entrySet()) {
            addParam(entry.getKey(), entry.getValue());
        }
        return this;
    }

    public UrlBuilder addHock(String hock){
        hostBuilder.append("#" + hock);
        canAddParam=false;
        return this;
    }

    public String getUrl(){
        return hostBuilder.toString();
    }
}
