package com.shaxi.Model;
        import com.shaxi.Dates.ConfigData;
        import org.apache.http.Header;
        import org.apache.http.HttpEntity;
        import org.apache.http.HttpResponse;
        import org.apache.http.client.HttpClient;
        import org.apache.http.client.methods.HttpPost;
        import org.apache.http.entity.StringEntity;
        import org.apache.http.impl.client.HttpClients;
        import org.apache.http.util.EntityUtils;

/**
 * @author Tomato
 * @version 创建时间：2020年4月21日 上午10:17:46
 * 类说明
 *重定向类
 */
public class RedictTest1 {
    public static void main(String args[]) {
        try {
            HttpClient client = HttpClients.createDefault();
            login(client);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void login(HttpClient client) throws Exception {
        final String APPLICATION_JSON = "application/json";
        //final String CONTENT_TYPE_TEXT_JSON = "text/json";
        String Cookie= ConfigData.Cookies;
        //String Cookie1= ConfigData.Cookies1;


        String url = "http://172.19.201.40:9080/shxjc-server/pro/Workbench/getTreeThree";
        String js = "{\"P_CODE_VALUE\":\"01\",\"CODE_VALUE\":\"01\"}";

        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Content-Type", "application/json;charset=UTF-8");
        httpPost.setHeader("Cookie",Cookie);
        // httpPost.setHeader("Cookie",Cookie1);

        StringEntity se = new StringEntity(js);
        se.setContentType(APPLICATION_JSON);

        httpPost.setEntity(se);

        HttpResponse response = null;

        response = client.execute(httpPost);

        //----------判断是否重定向开始
        int code = response.getStatusLine().getStatusCode();
        String newuri = "";
        if (code == 302) {
            Header header = response.getFirstHeader("location"); // 跳转的目标地址是在 HTTP-HEAD 中的
            newuri = header.getValue(); // 这就是跳转后的地址，再向这个地址发出新申请，以便得到跳转后的信息是啥。
            System.out.println(newuri);
            System.out.println(code);

            httpPost = new HttpPost(newuri);
            httpPost.setHeader("Content-Type", "application/json;charset=UTF-8");

            se = new StringEntity(js);
            se.setContentType(APPLICATION_JSON);

            httpPost.setEntity(se);
            httpPost.setHeader("Cookie",Cookie);

            response = client.execute(httpPost);
            code = response.getStatusLine().getStatusCode();
            System.out.println("login接口的返回状态码：" + code);

        }

        //------------重定向结束

        HttpEntity entity = response.getEntity();
        String s2 = EntityUtils.toString(entity, "UTF-8");
        System.out.println(s2);


    }


    public static class TestSpotCheckManage {
    }
}
