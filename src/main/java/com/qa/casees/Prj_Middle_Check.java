package com.qa.casees;

import com.qa.base.PostClient;
import org.apache.http.HttpResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Prj_Middle_Check extends PostClient {
    @Test
    public void  Prj_MiddleCheck() throws IOException {
        PostClient postClient=new PostClient();
        HttpResponse st=postClient.postWithParams("http://172.19.188.179:8070/techprj-server/techprj/framework/item/addInSpection","{\"prjNo\":\"KJGL20200320123047634\",\"insTime\":\"2020-03-25\",\"insConclusion\":\"32332\"}");
        System.out.println(st);
       // Assert.assertTrue(st.contains("success"));
    }

}
