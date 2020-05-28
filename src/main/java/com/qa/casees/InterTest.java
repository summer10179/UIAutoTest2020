package com.qa.casees;

import com.qa.base.PostClient;
import javafx.scene.layout.Priority;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class InterTest extends PostClient {
    public InterTest interTest;

    public String  AddPrjTest() throws IOException {
        String json = "{\"PRJNAME\":\"科技项目成果\",\"BGNTIME\":\"2020-02\",\"ENDTIME\":\"2020-06\",\"PRJTYPE\":\"02\",\"PRJTYPENAME\":\"\",\"BUSIDEPT\":\"02\",\"BUSIDEPTNAME\":\"\",\"PRJMANAGER\":\"张经理\",\"PLANAMT\":\"200\",\"FINANBUDGET\":\"190\",\"TENDERFINISHTIME\":\"2020-03-19\",\"CONTRACTSIGNTIME\":\"2020-03-25\",\"AIMS\":[{\"NAME1\":\"研究xxxxx\",\"NAME2\":\"通过XXX，掌握iXXXX\"}],\"COMPOS\":[{\"NAME1\":\"XXXX公司\",\"NAME2\":\"王笑笑\",\"NAME3\":\"18187267876\"}],\"PATS\":[{\"STLEVCODE\":\"01\",\"NAME1\":\"专利\",\"NAME2\":\"02\",\"NAME3\":\"2020-10\"}],\"PAPERS\":\"\",\"STANDS\":\"\",\"BOOKS\":\"\",\"RESERS\":\"\",\"ACHIES\":\"\",\"anPATS\":1,\"anPAPERS\":0,\"anBOOKS\":0,\"anRESERS\":0,\"anACHIES\":0,\"anSTANDS\":0,\"anCOMPOS\":1}";
        String url = "http://172.19.188.179:8070/techprj-server/techprj/framework/prjent/addPrj";
        postClient.postWithParams(url, json);
        int code = postClient.getCode();
        String res = postClient.getResponse();

        Assert.assertEquals(code, 200, "响应状态码正确");
        Assert.assertTrue(res.contains("success"), "响应不包含成功");
        System.out.println("保存项目测试通过====");
        System.out.println(res);
        return res;

    }
    @Test(priority = 2)

    public void getPrjTest() throws IOException {

        url="http://172.19.188.179:8070/techprj-server/techprj/framework/prjent/sendApp";
        String json="{\"PRJID\":171,\"PRJNO\":\"KJGL20200321175810899\",\"PERSONNO\":\"KJCS1\",\"PERSONNAME\":\"科技管理员\"}";
        postClient.postWithParams(url,json);
        int code=postClient.getCode();
        String str=postClient.getResponse();
        //Assert.assertTrue(str.contains("TOTAL"));
        Assert.assertEquals(code,200,"状态码返回不正确");
        System.out.println("======查询页面接口正确");
        System.out.println(str);
    }
}
