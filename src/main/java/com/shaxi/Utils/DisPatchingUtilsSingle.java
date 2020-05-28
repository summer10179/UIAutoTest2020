package com.shaxi.Utils;

import com.shaxi.Dates.ConfigData;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class DisPatchingUtilsSingle {

     public static void main(String[] args) {

         HttpClient client = new DefaultHttpClient();

//         设置参数
         final String APPLICATION_JSON = "application/json";
         String Cookie = ConfigData.Cookies;
         String host = ConfigData.host1;
         String url = host + "pro/checkPlan/inserspotplan";
         String json = "{\"PLAN_NO\":\"\",\"PLAN_ORG_NO\":\"61102\",\"PLAN_TYPE\":\"01\",\"SPOT_TYPE\":\"02\",\"SPOT_WAY\":\"01\",\"QUANT_SPEC_VALUE\":2,\"SPOT_CYCLE\":\"02\",\"SPOT_BEG_TIME\":\"2020-04-22\",\"SPOT_THEME_NO\":\"ZT0001\",\"SPOT_THEME\":\"客户用电异常\",\"SPOT_CONTENT\":\"抽检内容是\",\"START_EMP\":\"61102\"}";
         HttpPost httpPost = new HttpPost(url);
         httpPost.setHeader("Content-Type", "application/json;charset=UTF-8");
         httpPost.setHeader("Cookie", Cookie);

//      处理请求参数
        StringEntity se = null;
        try {
            se = new StringEntity(json);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        se.setContentType(APPLICATION_JSON);

        httpPost.setEntity(se);

        HttpResponse response = null;

//        执行参数
        try {
            response = client.execute(httpPost);
        } catch (IOException e) {
            e.printStackTrace();
        }


        //----------判断是否重定向开始
//        int code = response.getStatusLine().getStatusCode();
//        String newuri = "";
//        if (code == 302) {
//            Header header = response.getFirstHeader("location"); // 跳转的目标地址是在 HTTP-HEAD 中的
//            newuri = header.getValue(); // 这就是跳转后的地址，再向这个地址发出新申请，以便得到跳转后的信息是啥。
//            System.out.println(newuri);
//            System.out.println(code);
//
//            httpPost = new HttpPost(newuri);
//            httpPost.setHeader("Content-Type", "application/json;charset=UTF-8");
//
//            try {
//                se = new StringEntity(json);
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//            }
//            se.setContentType(APPLICATION_JSON);
//
//            httpPost.setEntity(se);
//            httpPost.setHeader("Cookie", Cookie);
//
//            try {
//                response = client.execute(httpPost);
//
//                System.out.println(response);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            code = response.getStatusLine().getStatusCode();
//            System.out.println("login接口的返回状态码：" + code);
//
//        }

        //------------重定向结束

//         解析结果
        HttpEntity entity = response.getEntity();
        String s2 = null;
        try {
         s2 = EntityUtils.toString(entity, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(s2);


    }
}






