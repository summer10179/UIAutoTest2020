package com.shaxi.TestCase;

import com.shaxi.Dates.ConfigData;
import com.shaxi.Utils.DisPatchingUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSpotCheckModify {
    HttpClient httpClient = new DefaultHttpClient();
    DisPatchingUtils disPatchingUtils = new DisPatchingUtils();

    String host = ConfigData.host1;
    String url = host + "pro/checkPlan/inserspotplan";

    String Cookie = ConfigData.Cookies;
    @Test
    public void testSpotMofifyPS(){
        try {
            String json="{\"PLAN_NO\":\"200422002369\",\"PLAN_ORG_NO\":\"61102\",\"PLAN_TYPE\":\"01\",\"SPOT_TYPE\":\"01\",\"SPOT_WAY\":\"01\",\"QUANT_SPEC_VALUE\":10,\"SPOT_CYCLE\":\"02\",\"SPOT_BEG_TIME\":\"2020-04-22\",\"SPOT_THEME_NO\":\"ZT0001\",\"SPOT_THEME\":\"客户用电异常\",\"SPOT_CONTENT\":\"修改参数\",\"START_EMP\":\"61102\"}";
            HttpResponse response=disPatchingUtils.login(url, json, Cookie);
            int Code=disPatchingUtils.getCode();
            Assert.assertEquals(Code,200,"返回状态码正确");
            String str=disPatchingUtils.getResponse();
            System.out.println(str);
            Assert.assertTrue(str.contains("success"));
            System.out.println("修改成功");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    }
