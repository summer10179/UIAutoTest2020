package com.qa.base;

import org.apache.http.HttpResponse;
import org.testng.annotations.Test;


import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase  {
    public Properties prop;
    public static String host = null;
    public static Prj_Api prj_api;
    public static HttpResponse postClienta;
    public static TestBase testBase;
    public static String url;
    //写一个构造函数
    @Test
        public void   TestBase() {

            try {
                prop = new Properties();
                FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com/qa/config/config.properties");
                prop.load(fis);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            host = prop.getProperty(prj_api.getHost());
            System.out.println(host);
        }
        @Test
    public String getUrlll(){
            url=host+"procMag/sendApp";
            return url;
    }

    }




