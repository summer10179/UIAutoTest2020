package com.qa.restclient;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.HashMap;

public class RestClient {
    public void get(String url) throws IOException {
        //创建一个可关闭的HttpClient对象
        CloseableHttpClient httpclient= HttpClients.createDefault();
        //创建一个httpget的请求对象
        HttpGet httpget=new HttpGet(url);
        //执行请求，赋值给httpresponse对象接受
        CloseableHttpResponse httpResponse =httpclient.execute(httpget);
        //拿到http响应状态码，和其他比较
        int responseStstusCode=httpResponse.getStatusLine().getStatusCode();
        System.out.println("response  status code-->"+responseStstusCode);
        //把响应内容存储在字符串对象
        String responseString= EntityUtils.toString(httpResponse.getEntity(),"UTF-8");
        //创建Json对象，把上面字符串序列转化位Json 对象
        JSONObject responseJson= JSON.parseObject(responseString);
        System.out.println("respon json from API-->"+responseJson);
        //获取响应头信息，返回数组
        Header[] headerArray=httpResponse.getAllHeaders();
        //创建一个HashMap对象
        HashMap<String,String> hm=new HashMap<String,String>();
        //增强for循环，遍历headerArray里面的数组，一次将元素添加进来
        for(Header header:headerArray){
            hm.put(header.getName(),header.getValue());
        }
        System.out.println("response headers-->"+hm);

    }



}
