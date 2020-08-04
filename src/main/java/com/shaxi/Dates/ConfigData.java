package com.shaxi.Dates;

import com.qa.base.GetPSDSESSION;
import org.testng.annotations.Test;

public class ConfigData {
       public  static String  host="http://172.19.188.179:8070/";
//       设置静态常量数据
       public static String  host1="http://172.19.201.40:9080/shxjc-server/";
       public static String Cookies="PSDSESSION=e82b3984-6122-4d93-bf4b-111fb9871d20; EUNOMIASESSIONID=df4aa5e4-5460-4379-b311-cd757b82be37";
public void gerCookie(){
       GetPSDSESSION getPSDSESSION1=new GetPSDSESSION();
       String str=getPSDSESSION1.getPSDSESSION();
       System.out.println(str);
}
}
