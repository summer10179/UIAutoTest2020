package com.qa.restclient;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class RestClientDemo {
    //GET  请求方法
    public CloseableHttpResponse get(String url) throws IOException {
        //创建一个可关闭的httpclient对象
        CloseableHttpClient httpclient= HttpClients.createDefault();
        //创建一个httpget对象
        HttpGet httpget=new HttpGet(url);
        //执行请求，相当于点击发送按钮，赋值给Httpresponse对象接受
        CloseableHttpResponse httpresponse=httpclient.execute(httpget);
        return httpresponse;
    }
    //get带请求头的方法
    public CloseableHttpResponse get(String url, HashMap<String,String> headermap) throws IOException {
        CloseableHttpClient httpclient=HttpClients.createDefault();
        HttpGet httpget=new HttpGet(url);
        //加载i请求头到httpget对象
        for(Map.Entry<String,String> entry:headermap.entrySet()){
            httpget.addHeader(entry.getKey(),entry.getValue());
        }
        CloseableHttpResponse httpResponse = httpclient.execute(httpget);

        return httpResponse;
    }
    //POST方法
    public CloseableHttpResponse post(String url,String entityString,HashMap<String,String> hwadermap) throws IOException {
        CloseableHttpClient httpclient=HttpClients.createDefault();
        HttpPost httppost=new HttpPost(url);
        httppost.setEntity(new StringEntity(entityString));
        for(Map.Entry<String,String> entry:hwadermap.entrySet()){
            httppost.addHeader(entry.getKey(),entry.getValue());
        }
   CloseableHttpResponse httpResponse=httpclient.execute(httppost);
        return httpResponse;

    }
}
