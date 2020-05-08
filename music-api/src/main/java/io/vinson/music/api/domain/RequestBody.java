package io.vinson.music.api.domain;

import com.google.gson.JsonObject;

import java.util.Map;

/**
 * @author: jiangweixin
 * @date: 2020/5/7
 */
public class RequestBody {

    private String method;

    private String url;

    private JsonObject params;

    private String encode;

    private String format;

    public String getMethod() {
        return method;
    }

    public RequestBody setMethod(String method) {
        this.method = method;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public RequestBody setUrl(String url) {
        this.url = url;
        return this;
    }

    public JsonObject getParams() {
        return params;
    }

    public RequestBody setParams(JsonObject params) {
        this.params = params;
        return this;
    }

    public String getEncode() {
        return encode;
    }

    public RequestBody setEncode(String encode) {
        this.encode = encode;
        return this;
    }

    public String getFormat() {
        return format;
    }

    public RequestBody setFormat(String format) {
        this.format = format;
        return this;
    }
}
