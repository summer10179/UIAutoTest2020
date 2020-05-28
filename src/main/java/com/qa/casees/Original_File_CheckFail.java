package com.qa.casees;

import com.qa.base.PostClient;
import org.apache.http.HttpResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Original_File_CheckFail extends PostClient {
    @Test
    public void Original_File_CheckFailtest() throws IOException {
        PostClient postClient=new PostClient();
        HttpResponse st=postClient.postWithParams("http://172.19.188.179:8070/techprj-server/techprj/framework/item/updateFiling","{{\"prjNo\":\"KJGL20200319114637307\",\"prjLink\":\"01\",\"verres\":\"02\",\"verdes\":\"哈哈\"}");
        System.out.println(st);
        //Assert.assertTrue(st.contains("success"));

    }

}
