package io.vinson.music.api.service;

import io.vinson.music.api.domain.RequestParam;
import io.vinson.music.api.util.UrlBuilder;
import org.apache.http.*;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author: jiangweixin
 * @date: 2020/5/7
 */
public class HtmlFetcherService {
	
	public static String exec(RequestParam requestParam) throws IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String rs = "";
        HttpUriRequest httpRequest = null;
        if(requestParam.getMethod() == "GET") {
            String url = requestParam.getUrl();
            if(requestParam.getBody() != null) {
                UrlBuilder builder = UrlBuilder.builder(requestParam.getUrl());
                builder.addParamMap(requestParam.getBody());
                url = builder.getUrl();
            }
            httpRequest = new HttpGet(url);
        } else {
            List<NameValuePair> parameters = new ArrayList<NameValuePair>(0);
            for(Map.Entry<String, String> entry : requestParam.getBody().entrySet()) {
                parameters.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
            UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(parameters,"UTF-8");
            HttpPost httpPost = new HttpPost(requestParam.getUrl());
            httpPost.setEntity(formEntity);
            httpRequest = httpPost;
        }

        httpRequest.addHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.129 Safari/537.36");

        CloseableHttpResponse response = httpclient.execute(httpRequest);
        
        HttpEntity entity = response.getEntity();
        
        if (response.getStatusLine().getStatusCode() == 200 && entity != null) {
        	rs = EntityUtils.toString(entity, "utf-8");
        }
        
    	response.close();
        httpclient.close();
        return rs;
	}
}