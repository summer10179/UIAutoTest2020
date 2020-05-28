package com.shaxi.TestCase;


import com.shaxi.Dates.ConfigData;
import com.shaxi.Utils.DisPatchingUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestSpotCheckManage {
    HttpClient httpClient = new DefaultHttpClient();
    DisPatchingUtils disPatchingUtils = new DisPatchingUtils();

    String host = ConfigData.host1;
    String url = host + "pro/checkPlan/inserspotplan";

    String Cookie = ConfigData.Cookies;

    @Test
    public void spotCheckMan() {
        //参数设置，参数正常情况下
        String json = "{\"PLAN_NO\":\"\",\"PLAN_ORG_NO\":\"61102\",\"PLAN_TYPE\":\"01\",\"SPOT_TYPE\":\"02\",\"SPOT_WAY\":\"01\",\"QUANT_SPEC_VALUE\":2,\"SPOT_CYCLE\":\"02\",\"SPOT_BEG_TIME\":\"2020-04-22\",\"SPOT_THEME_NO\":\"ZT0001\",\"SPOT_THEME\":\"客户用电异常\",\"SPOT_CONTENT\":\"抽检内容是\",\"START_EMP\":\"61102\"}";
        try {
            HttpResponse response=disPatchingUtils.login(url, json, Cookie);
            int Code=disPatchingUtils.getCode();
            Assert.assertEquals(Code,200,"返回状态码正确");
            String str=disPatchingUtils.getResponse();
            Assert.assertTrue(str.contains("success"));
            System.out.println("正常添加参数正确");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void  TestSpotCheckManagePN(){
        //参数设置，空校验
        String json = "{\"PLAN_NO\":\"\",\"PLAN_ORG_NO\":\"\",\"PLAN_TYPE\":\"01\",\"SPOT_TYPE\":\"02\",\"SPOT_WAY\":\"01\",\"QUANT_SPEC_VALUE\":2,\"SPOT_CYCLE\":\"02\",\"SPOT_BEG_TIME\":\"2020-04-22\",\"SPOT_THEME_NO\":\"ZT0001\",\"SPOT_THEME\":\"客户用电异常\",\"SPOT_CONTENT\":\"抽检内容是\",\"START_EMP\":\"61102\"}";
        try {
            HttpResponse response=disPatchingUtils.login(url, json, Cookie);

            int Code=disPatchingUtils.getCode();
            Assert.assertEquals(Code,200,"返回状态码正确");
            String str=disPatchingUtils.getResponse();
            Assert.assertTrue(str.contains("success"));

            System.out.println("正常添加参数正确");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



