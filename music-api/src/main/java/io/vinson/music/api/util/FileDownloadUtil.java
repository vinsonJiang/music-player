package io.vinson.music.api.util;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author: jiangweixin
 * @date: 2020/5/8
 */
public class FileDownloadUtil {

    public static void download(String urlAddr, String filePath) {
        try {
            URL url = new URL(urlAddr); // 创建URL
            URLConnection urlConn = url.openConnection();
            urlConn.connect();
            HttpURLConnection httpConn =(HttpURLConnection)urlConn;
            if(httpConn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                System.out.println("connect fail");
                return;
            }

            InputStream input = httpConn.getInputStream();
            File storeFile = new File(filePath);
            FileOutputStream output = new FileOutputStream(storeFile);
            byte b[] = new byte[1024];
            int i = 0;
            while((i = input.read(b)) != -1){
                output.write(b, 0, i);
            }
            output.flush();
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
