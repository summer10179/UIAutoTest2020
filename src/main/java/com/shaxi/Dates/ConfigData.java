package com.shaxi.Dates;

import com.qa.base.GetPSDSESSION;
import org.testng.annotations.Test;

public class ConfigData {
       public  static String  host="http://172.19.188.179:8070/";
//       设置静态常量数据
       public static String  host1="http://172.19.201.40:9080/shxjc-server/";
       public static String Cookies="PSDSESSION=41d8def2-2e17-4522-9ead-d17f46a64980; EUNOMIASESSIONID=96e63ac7-e732-4a9c-8a3a-5e4bdbaadb15";
       public static String Cookies1="JSESSIONID=21970B22B7C9E13025874515BCF5CCD8; PSDSESSION=b03bb0c7-3568-47b9-9dd8-5d329e6f4e42";
@Test
public void gerCookie(){
       GetPSDSESSION getPSDSESSION1=new GetPSDSESSION();
       String str=getPSDSESSION1.getPSDSESSION();
       System.out.println(str);
}
}
