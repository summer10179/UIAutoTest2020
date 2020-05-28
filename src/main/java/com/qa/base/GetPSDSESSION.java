package com.qa.base;

import com.shaxi.Dates.ConfigData;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.impl.client.DefaultHttpClient;

public class GetPSDSESSION {

    public String   getPSDSESSION(){
        PostClient postClient=new PostClient();
        String session= ConfigData.Cookies;
        String host=ConfigData.host1;
        String url=host+"basic/login";
        String json="{\"username\":\"61102\",\"password\":\"5cb50ca6ab678ddc1a8d35f9958d48ad055bb5430171bf52b6972bba83b50ea43dfc345bf42579dd41443b1622af432995aaa53ec50d4ea680977e2643737e3864d7110045d1e11bae4c2745a2b542f1136f50bb38cd686eccd04e8ead2ff867c7985bf40dddfa215f93e5abc490e597831000397dd49d46f4313de34f49f503\"}";
        DefaultHttpClient httpclient=new DefaultHttpClient();
        HttpResponse httpResponse=postClient.postWithParams(url,json);
   //    httpResponse.getCookie();

       Header[] headers2=httpResponse.getHeaders("Set-Cookie");

        System.out.println(headers2);
        System.out.println(headers2.toString());
       String cookie=headers2[1].getValue();
        String[] strs=cookie.split("; ");
        System.out.println(strs[0]);
        String temp=strs[0];
        String PSDSESSION=temp.split("=")[1];
        System.out.println(PSDSESSION);
        String Cookie=session+temp;
        System.out.println(session);
        System.out.println(temp);
        return Cookie;

    }



}
