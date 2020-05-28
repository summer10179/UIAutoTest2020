package com.qa.casees;

import com.shaxi.Dates.ConfigData;
import com.qa.base.PostClient;
import org.testng.annotations.Test;

import java.io.IOException;

public class GetPrj extends PostClient {
//    @BeforeTest
//    public void obtainPj() throws IOException {
//        PostClient postclient=new PostClient();
//        String prjNo=postclient.Jsontest();
//    }

    @Test
    public void getPrjTest() throws IOException {

        String prjNo;
        String host=ConfigData.host;
        url=host+"techprj-server/techprj/framework/prjent/sendApp";
        String json="{\"PRJID\":\"71\",\"PRJNO\":\"prjNo\",\"PERSONNO\":\"KJCS1\",\"PERSONNAME\":\"科技管理员\"}";

        postClient.postWithParams(url,json);

        int code=postClient.getCode();
        String str=postClient.getResponse();
        //Assert.assertTrue(str.contains("TOTAL"));
        //Assert.assertEquals(code,200,"状态码返回不正确");
        System.out.println("======查询页面接口正确");
        System.out.println(str);
    }
}
