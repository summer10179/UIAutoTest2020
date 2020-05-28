package com.shaxi.TestCase;

import com.shaxi.Dates.ConfigData;
import com.qa.base.PostClient;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestLogON {

        @Test
        public void  dispatchingTest() throws IOException {

            String host= ConfigData.host1;
            PostClient postClient=new PostClient();
            String url=host+"basic/login";
            String json="{\"username\":\"61102\",\"password\":\"5cb50ca6ab678ddc1a8d35f9958d48ad055bb5430171bf52b6972bba83b50ea43dfc345bf42579dd41443b1622af432995aaa53ec50d4ea680977e2643737e3864d7110045d1e11bae4c2745a2b542f1136f50bb38cd686eccd04e8ead2ff867c7985bf40dddfa215f93e5abc490e597831000397dd49d46f4313de34f49f503\"}";
            //发送请求
            HttpResponse httpResponse=postClient.postWithParams(url,json);

            //响应结果以及断言
            int code=httpResponse.getStatusLine().getStatusCode();
            System.out.println(code);
            String response= EntityUtils.toString(httpResponse.getEntity());
            System.out.println(response);






        }
    }


