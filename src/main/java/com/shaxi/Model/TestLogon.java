package com.shaxi.Model;



import com.qa.base.PostClient;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 * @author QiaoJiafei
 * @version 创建时间：2016年1月5日 上午10:17:46
 * 类说明
 */
public class TestLogon {

    public static void main(String args[]) {
        try {
            HttpClient client = HttpClients.createDefault();
            login(client);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


        public static void login (HttpClient client) throws Exception {
          //  final String APPLICATION_JSON = "application/json";
            final String CONTENT_TYPE_TEXT_JSON = "text/json";
            PostClient postClient=new PostClient();


            String url = "http://172.19.201.40:9080/shxjc-server/pro/Workbench/getTreeThree";
            String json = "{\"P_CODE_VALUE\":\"01\",\"CODE_VALUE\":\"01\"}";
            String cookie = "JSESSIONID=21970B22B7C9E13025874515BCF5CCD8; PSDSESSION=4f638680-4452-4440-bece-98eeb9f79e61; EUNOMIASESSIONID=54db1d55-c83e-4206-96e6-9ccd4ed42b80";
//          PostClient postClient=new PostClient();
            HttpResponse response=postClient.posWithCookie(url,json,cookie);
//            HttpPost httpPost = new HttpPost(url);
//            httpPost.addHeader("Content-Type", "application/json;charset=UTF-8");
//            httpPost.addHeader("Cookie", "JSESSIONID=21970B22B7C9E13025874515BCF5CCD8; PSDSESSION=4f638680-4452-4440-bece-98eeb9f79e61; EUNOMIASESSIONID=54db1d55-c83e-4206-96e6-9ccd4ed42b80");
//            StringEntity se = new StringEntity(json);
//            se.setContentType(CONTENT_TYPE_TEXT_JSON);
//
//            httpPost.setEntity(se);
//
//            HttpResponse response = null;
//
//           response = client.execute(httpPost);


            //----------判断是否重定向开始
            int code = response.getStatusLine().getStatusCode();
            String newuri = "http://172.19.201.40:9080/shxjc-server/shxjc/index.html";
            if (code == 302) {
                Header header = response.getFirstHeader("location"); // 跳转的目标地址是在 HTTP-HEAD 中的
                newuri = header.getValue(); // 这就是跳转后的地址，再向这个地址发出新申请，以便得到跳转后的信息是啥。
                System.out.println(newuri);
                System.out.println(code);

//                httpPost = new HttpPost(newuri);
//                httpPost.setHeader("Content-Type", "application/json;charset=UTF-8");
//
//                se = new StringEntity(json);
//                se.setContentType(CONTENT_TYPE_TEXT_JSON);
//
//                httpPost.setEntity(se);
//
//                response = client.execute(httpPost);
//                code = response.getStatusLine().getStatusCode();
//                System.out.println("login" + code);
//                String str = EntityUtils.toString(response.getEntity());
//                System.out.println(str);
            }

            //------------重定向结束
//        HttpEntity entity = null;
//        entity = response.getEntity();
//        String s2 = EntityUtils.toString(entity, "UTF-8");
//        System.out.println(s2);


        }


    }

