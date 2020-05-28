package com.shaxi.Model;

import com.shaxi.Dates.ConfigData;
import com.qa.base.PostClient;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest {
    @Test
    public void   logontest() throws IOException {
        PostClient postClient=new PostClient();
        String  host=ConfigData.host;
        String url=host+"/basic/login";
        String json="{\"username\":\"61102\",\"password\":\"5cb50ca6ab678ddc1a8d35f9958d48ad055bb5430171bf52b6972bba83b50ea43dfc345bf42579dd41443b1622af432995aaa53ec50d4ea680977e2643737e3864d7110045d1e11bae4c2745a2b542f1136f50bb38cd686eccd04e8ead2ff867c7985bf40dddfa215f93e5abc490e597831000397dd49d46f4313de34f49f503\"}";

        HttpResponse httpResponse=postClient.postWithParams(url,json);
        HttpEntity enty=httpResponse.getEntity();
        Header[] headers=httpResponse.getAllHeaders();
//        System.out.println(httpResponse.getLocale());
          for (int i = 0; i <headers.length ; i++) {
           System.out.println(headers[i].getName()+":"+headers[i].getValue());
        }
        Header[] headers2=httpResponse.getHeaders("Set-Cookie");
       System.out.println(headers2[1].getValue());
//        String cookie=headers2[1].getValue();
//        String[] strs=cookie.split("; ");
//        System.out.println(strs[0]);
//        String temp=strs[0];
//        String PSDSESSION=temp.split("=")[1];
//        System.out.println(PSDSESSION);

        int code=postClient.getCode();
        String str=postClient.getResponse();

        Assert.assertEquals(200,code,"返回状态码不正确");
        System.out.println(str);
    }



}
