package TestUi.PracticeTest.Client;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class RestfulClient {

    CloseableHttpClient httpclient= HttpClients.createDefault();
    HttpGet httpGet;
    HttpPost httpPost;
    CloseableHttpResponse httpResponse;
    int responseCode;
    JSONObject responseBody;
    HashMap<String, String> responseHeads;

    public void doPutRequest(){
        //todo
    }

    public void doDeleteRequest(){
        //todo
    }


    /**
     * json格式参数post请求
     * @param url
     * @param jsonDate
     * @param headers
     */
    /** 适用所有post的请求 **/
    /** 发送json请求 */
    public void   doPostRequest(String url, List<NameValuePair> params, String json, HashMap<String, String> headers) {
//        CloseableHttpClient httpClient = HttpClients.createDefault();
        httpPost = new HttpPost(url);
        try {

//            设置请求主体格式
            try {
                httpPost.setEntity(new UrlEncodedFormEntity(params,"UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            Set<String> set= headers.keySet();

            for (Iterator<String> iterator= set.iterator();iterator.hasNext();){
                String key = iterator.next();
                String value=headers.get(key);
                httpPost.addHeader(key,value);
            }

            if(json.length() != 0) {
                // json传递
                StringEntity postingString = new StringEntity(json, "utf-8");
                httpPost.setEntity(postingString);
            }

            httpResponse=httpclient.execute(httpPost);
        }catch (Exception e){
            e.getMessage();
        }finally {
            try {
                httpclient.close();
            }catch (Exception e){
                System.out.println("httpclient执行异常："+e.getMessage());
            }
        }
    }



    /**
     * 通过httpclient获取post请求的反馈
     * @param url
     * @param params
     * @param headers
     */
    public void doPostRequest(String url, List<NameValuePair> params,
                              HashMap<String, String> headers) {

//      创建请求对象
        httpPost =new HttpPost(url);

//      设置请求主体格式
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(params,"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

//      设置请求头信息
        Set<String> set= headers.keySet();

        for (Iterator<String> iterator= set.iterator();iterator.hasNext();){
            String key = iterator.next();
            String value=headers.get(key);
            httpPost.addHeader(key,value);
        }
        try {
            httpResponse=httpclient.execute(httpPost);
        } catch (IOException e) {
            System.out.println("httpclient执行doPostRequest异常："+e.getMessage());
        }
    }

    /**
     * 通过httpclient获取post请求的反馈
     * @param url
     * @param
     * @param headers
     */
    public void doGetRequest(String url,
                              HashMap<String, String> headers) {

//      创建请求对象
        httpGet =new HttpGet(url);

//      设置请求头信息
        Set<String> set= headers.keySet();

        for (Iterator<String> iterator= set.iterator();iterator.hasNext();){
            String key = iterator.next();
            String value=headers.get(key);
            httpGet.addHeader(key,value);
        }
        try {
            httpResponse=httpclient.execute(httpGet);
        } catch (IOException e) {
            System.out.println("httpclient执行doPostRequest异常："+e.getMessage());
        }
    }

    /**
     * 通过httpclient获取请求的反馈
     * @param url
     */
    public void doGetRequest(String url)  {
        httpGet=new HttpGet(url);
        try {
            httpResponse=httpclient.execute(httpGet);
        } catch (IOException e) {
            System.out.println("httpclient执行doGetRequest异常："+e.getMessage());
        }
    }

    /**
     * 以JSON格式获取到反馈的主体
     * @return
     */
    public JSONObject getBodyInJSON() {
        HttpEntity entity;
        String entityToString = null;
        if (httpResponse!= null){

            entity = httpResponse.getEntity();
            try {
                entityToString = EntityUtils.toString(entity);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                responseBody = JSON.parseObject(entityToString);
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("===============================================\n");
            System.out.println("This is your response body ==> " + responseBody);

        }else {
            responseBody=null;
        }
        return responseBody;
    }

    /**
     * 以String格式获取到反馈的主体
     * @return
     * @throws IOException
     */
    public String getBody()  {
        HttpEntity entity;
        String entityToString = null;
        if (httpResponse!=null){
            entity = httpResponse.getEntity();
            try {
                entityToString = EntityUtils.toString(entity);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("===============================================\n");
            System.out.println("This is your response body ==> " + entityToString);
        }else {
            entityToString=null;
        }

        return entityToString;
    }

    /**
     * 以哈希图的方式获取到反馈头部
     * @return
     */
    public HashMap<String,String> getHeaders(){
        Header[] headers=httpResponse.getAllHeaders();
        responseHeads= new HashMap<String,String>();
        for (Header header:headers){
            responseHeads.put(header.getName(),header.getValue());
        }
        System.out.println("===============================================\n");
        System.out.println("This is your response header ==> " + responseHeads);

        return responseHeads;
    }

    /**
     * 获取反馈状态码
     * @return
     */
    public int getResponseCode(){

        responseCode=httpResponse.getStatusLine().getStatusCode();
        System.out.println("===============================================\n");
        System.out.println("This is your response code ==> " + responseCode);

        return responseCode;
    }

    public void shutDownConnection(){
        try {
            httpclient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
