package com.qa.casees;

import com.qa.base.PostClient;
import org.apache.http.HttpResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Original_File_CheckSuccess  extends PostClient {
    @Test
    public void Original_File_CheckSuccesstest() throws IOException {
        PostClient postClient=new PostClient();
        HttpResponse st=postClient.postWithParams("http://172.19.188.179:8070/techprj-server/techprj/framework/item/updateFiling","{\"prjNo\":\"KJGL20200320103024752\",\"prjLink\":\"01\",\"verres\":\"01\",\"verdes\":\"审核通过啦\"}");
        System.out.println(st);
        //Assert.assertTrue(st.contains("success"));

    }

}
