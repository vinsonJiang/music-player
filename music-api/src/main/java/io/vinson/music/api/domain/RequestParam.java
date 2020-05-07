package io.vinson.music.api.domain;

import java.util.Map;

/**
 * @author: jiangweixin
 * @date: 2020/5/7
 */
public class RequestParam {

    private String method;

    private String url;

    private Map<String, String> body;

    private String encode;

    private String format;

    public String getMethod() {
        return method;
    }

    public RequestParam setMethod(String method) {
        this.method = method;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public RequestParam setUrl(String url) {
        this.url = url;
        return this;
    }

    public Map<String, String> getBody() {
        return body;
    }

    public RequestParam setBody(Map<String, String> body) {
        this.body = body;
        return this;
    }

    public String getEncode() {
        return encode;
    }

    public RequestParam setEncode(String encode) {
        this.encode = encode;
        return this;
    }

    public String getFormat() {
        return format;
    }

    public RequestParam setFormat(String format) {
        this.format = format;
        return this;
    }
}
