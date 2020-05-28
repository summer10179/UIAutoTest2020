package com.shaxi.Utils;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import static com.qa.base.PostClient.httpResponse;


public class DisPatchingUtils {
       HttpResponse httpResponse;
       public HttpResponse login(String url, String json, String Cookie) throws Exception {


        HttpClient client = new DefaultHttpClient();
        final String APPLICATION_JSON = "application/json";
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Content-Type", "application/json;charset=UTF-8");
        httpPost.setHeader("Cookie", Cookie);


        StringEntity postingString = null;
        try {
            postingString = new StringEntity(json);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        httpPost.setEntity(postingString);

        try {
           httpResponse = client.execute(httpPost);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return httpResponse;
    }
    public int getCode(){

        int code=httpResponse.getStatusLine().getStatusCode();
        return  code;
    }
    public String getResponse(){
        String response= null;
        try {
            response = EntityUtils.toString(httpResponse.getEntity());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  response;
    }

}






