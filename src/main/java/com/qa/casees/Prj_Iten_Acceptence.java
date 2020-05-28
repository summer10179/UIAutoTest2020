package com.qa.casees;

import com.qa.base.PostClient;
import org.apache.http.HttpResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Prj_Iten_Acceptence extends PostClient {
    @Test
    public void  Prj_Item_Check() throws IOException {
        PostClient postClient=new PostClient();
        HttpResponse st=postClient.postWithParams("http://172.19.188.179:8070/techprj-server/techprj/framework/item/addProjCheck","{\"prjNo\":\"KJGL20200320123047634\",\"accTime\":\"2020-03-21\",\"accPlace\":\"浙江杭州\",\"accOrgan\":\"朗新\",\"accExpert\":\"王五\",\"accConclusion\":\"01\"}");
        System.out.println(st);
        //Assert.assertTrue(st.contains("success"));
        //Assert.assertTrue(st.contains("ACCID"));

    }
}
