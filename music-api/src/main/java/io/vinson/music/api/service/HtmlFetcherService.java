package io.vinson.music.api.service;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.vinson.music.api.domain.RequestBody;
import io.vinson.music.api.util.UrlBuilder;
import org.apache.http.*;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Map;

/**
 * @author: jiangweixin
 * @date: 2020/5/7
 */
public class HtmlFetcherService {
	
	public static String exec(RequestBody requestBody) throws IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String rs = "";
        HttpUriRequest httpRequest;
        if(requestBody.getMethod() == "GET") {
            String url = requestBody.getUrl();
            if(requestBody.getParams() != null) {
                UrlBuilder builder = UrlBuilder.builder(requestBody.getUrl());
                JsonObject jsonObject = requestBody.getParams();
                for(Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
                    builder.addParam(entry.getKey(), entry.getValue().getAsString());
                }
                url = builder.getUrl();
            }
            httpRequest = new HttpGet(url);
        } else {
            StringEntity requestEntity = new StringEntity(requestBody.getParams().toString(), "utf-8");
            HttpPost httpPost = new HttpPost(requestBody.getUrl());
            httpPost.setEntity(requestEntity);
            httpRequest = httpPost;
        }

        httpRequest.addHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.129 Safari/537.36");

        CloseableHttpResponse response = httpclient.execute(httpRequest);
        
        HttpEntity entity = response.getEntity();
        
        if (response.getStatusLine().getStatusCode() == HttpURLConnection.HTTP_OK && entity != null) {
        	rs = EntityUtils.toString(entity, "utf-8");
        }
        
    	response.close();
        httpclient.close();
        return rs;
	}
}