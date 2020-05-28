package com.qa.tests;

import com.alibaba.fastjson.JSON;
import com.qa.base.PostClient;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

public class JsonObtain {
    PostClient postClient=new PostClient();

    public String  Jsontest() throws IOException {
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

}
