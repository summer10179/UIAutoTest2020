package com.qa.base;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.ObjectArrayCodec;
import com.alibaba.fastjson.JSONObject;
import com.qa.restclient.RestClient;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class PostClient {

    HttpGet httpGet;
    HttpPost httpPost;
    public static HttpResponse httpResponse = null;
    public static HttpResponse httpResponse1 = null;

    TestBase testBase;
    String host;

    RestClient restClient;
    Properties prop;
    int responseCode;
    JSONObject responseBody;
    HashMap<String, String> responseHeads;
    public static PostClient postClient = new PostClient();
    CloseableHttpClient httpClient = HttpClients.createDefault();
    public static String url;

    public HttpResponse postWithParams(String url, String json)  {


        HttpPost httpPost = new HttpPost(url);
        httpPost.addHeader("Content-type", "application/json");
        //httpPost.addHeader("Cookie",Cookie);



        StringEntity postingString = null;
        try {
            postingString = new StringEntity(json);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        httpPost.setEntity(postingString);

        try {
            httpResponse = httpClient.execute(httpPost);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return httpResponse;


    }

    public int getCode() throws IOException {

        int code = httpResponse.getStatusLine().getStatusCode();

        return code;
    }

    public String getResponse() throws IOException {
        String response = EntityUtils.toString(httpResponse.getEntity());

        return response;
    }


    public JSONObject getBodyInJSON(String url, String json) throws IOException {

        HttpPost httpPost = new HttpPost(url);

        httpPost.addHeader("Content-type", "application/json");
        StringEntity postingString = new StringEntity(json);
        httpPost.setEntity(postingString);

        HttpResponse httpResponse = httpClient.execute(httpPost);
        HttpEntity entity;
        String entityToString = null;
        if (httpResponse != null) {

            entity = httpResponse.getEntity();
            try {
                entityToString = EntityUtils.toString(entity);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                responseBody = JSON.parseObject(entityToString);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("===============================================\n");
            System.out.println( responseBody);

        } else {
            responseBody = null;
        }
        return responseBody;
    }

    public JSONObject getBodyInJSON1(String url, String json) throws IOException {

        HttpPost httpPost = new HttpPost(url);

        httpPost.addHeader("Content-type", "application/json");
        StringEntity postingString = new StringEntity(json);
        httpPost.setEntity(postingString);

        HttpResponse httpResponse = httpClient.execute(httpPost);
        HttpEntity entity;
        String entityToString = null;
        if (httpResponse != null) {

            entity = httpResponse.getEntity();
            try {
                entityToString = EntityUtils.toString(entity);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                responseBody = JSON.parseObject(entityToString);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("===============================================\n");
            System.out.println(responseBody);

        } else {
            responseBody = null;
        }
        return responseBody.getJSONObject("PRJNO");
    }

    public String  setUp() throws FileNotFoundException {
        testBase = new TestBase();
        host = prop.getProperty("HOST");
        return host;


    }

    public String  AddPrjTest1() throws IOException {
        String json="{\"PRJNAME\":\"科技项目成果\",\"BGNTIME\":\"2020-02\",\"ENDTIME\":\"2020-06\",\"PRJTYPE\":\"02\",\"PRJTYPENAME\":\"\",\"BUSIDEPT\":\"02\",\"BUSIDEPTNAME\":\"\",\"PRJMANAGER\":\"张经理\",\"PLANAMT\":\"200\",\"FINANBUDGET\":\"190\",\"TENDERFINISHTIME\":\"2020-03-19\",\"CONTRACTSIGNTIME\":\"2020-03-25\",\"AIMS\":[{\"NAME1\":\"研究xxxxx\",\"NAME2\":\"通过XXX，掌握iXXXX\"}],\"COMPOS\":[{\"NAME1\":\"XXXX公司\",\"NAME2\":\"王笑笑\",\"NAME3\":\"18187267876\"}],\"PATS\":[{\"STLEVCODE\":\"01\",\"NAME1\":\"专利\",\"NAME2\":\"02\",\"NAME3\":\"2020-10\"}],\"PAPERS\":\"\",\"STANDS\":\"\",\"BOOKS\":\"\",\"RESERS\":\"\",\"ACHIES\":\"\",\"anPATS\":1,\"anPAPERS\":0,\"anBOOKS\":0,\"anRESERS\":0,\"anACHIES\":0,\"anSTANDS\":0,\"anCOMPOS\":1}";
        String url="http://172.19.188.179:8070/techprj-server/techprj/framework/prjent/addPrj";
       GetPSDSESSION  Cookievalue=new GetPSDSESSION();
       String Cookie=Cookievalue.getPSDSESSION();
       postClient.posWithCookie(url,json,Cookie);
       Map maps = (Map)JSON.parse(postClient.getResponse());
      // System.out.println("这个是用JSON类来解析JSON字符串!!!");
       for (Object map : maps.entrySet()){
           System.out.println(((Map.Entry)map).getKey()+" " + ((Map.Entry)map).getValue());
       }
           String ll=maps.get("metParams").toString();
       return ll;
    }

    public String   Jsontest() throws IOException {
        String ff=postClient.AddPrjTest1();
        Map mapl = (Map) JSON.parse(ff);
        System.out.println("解析里面的字符串");
        for (Object map : mapl.entrySet()){
            System.out.println(((Map.Entry)map).getKey()+" " + ((Map.Entry)map).getValue());
        }
        String  u=mapl.get("PRJNO").toString();
        System.out.println(u);
        return u;
    }
    public HttpResponse  posWithCookie(String url, String json,String Cookie) throws IOException {
        HttpPost httpPost = new HttpPost(url);

        httpPost.addHeader("Content-type", "application/json");
        httpPost.addHeader("Content-type", Cookie);
        StringEntity postingString = new StringEntity(json);
        httpPost.setEntity(postingString);

        HttpResponse httpResponse1 = httpClient.execute(httpPost);
        System.out.println("=====");
        return httpResponse1;

    }

    public HttpResponse  postWithCookies(String url, String json,String Cookie,String Cookie1) throws IOException {
        HttpPost httpPost = new HttpPost(url);

        httpPost.addHeader("Content-type", "application/json");
        httpPost.addHeader("Content-type", Cookie);
        httpPost.addHeader("Content-type", Cookie1);

        StringEntity postingString = new StringEntity(json);
        httpPost.setEntity(postingString);

        HttpResponse httpResponse1 = httpClient.execute(httpPost);
        System.out.println("=====");
        return httpResponse1;

    }

}

