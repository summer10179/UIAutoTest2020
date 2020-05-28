package com.btv;

;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * @author QiaoJiafei
 * @version 创建时间：2016年1月5日 上午10:17:46
 * 类说明
 */
public class TestLogin {
    public static void main(String args[]) {
        try {
            HttpClient client = HttpClients.createDefault();
            login(client);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void login( HttpClient client) throws Exception{
        final String APPLICATION_JSON = "application/json";
        final String CONTENT_TYPE_TEXT_JSON = "text/json";


        String url = "http://172.16.30.208:8092/svc/login";
        String js = "{\"username\":\"13800000002\",\"password\":\"123456\"}";


        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Content-Type", "application/json;charset=UTF-8");


        StringEntity se = new StringEntity(js);
        se.setContentType(CONTENT_TYPE_TEXT_JSON);

        httpPost.setEntity(se);

        HttpResponse response = null;

        response = client.execute(httpPost);

        //----------判断是否重定向开始
        int code = response.getStatusLine().getStatusCode();
        String newuri="";
        if (code == 302) {
            Header header = response.getFirstHeader("location"); // 跳转的目标地址是在 HTTP-HEAD 中的
            newuri = header.getValue(); // 这就是跳转后的地址，再向这个地址发出新申请，以便得到跳转后的信息是啥。
            System.out.println(newuri);
            System.out.println(code);

            httpPost = new HttpPost(newuri);
            httpPost.setHeader("Content-Type", "application/json;charset=UTF-8");

            se = new StringEntity(js);
            se.setContentType(CONTENT_TYPE_TEXT_JSON);

            httpPost.setEntity(se);

            response = client.execute(httpPost);
            code = response.getStatusLine().getStatusCode();
            System.out.println("login"+code);
        }

        //------------重定向结束
        HttpEntity entity = null;
        entity = response.getEntity();
        String s2 = EntityUtils.toString(entity, "UTF-8");
        System.out.println(s2);


    }



}