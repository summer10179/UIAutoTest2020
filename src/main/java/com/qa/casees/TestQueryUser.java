package com.qa.casees;

import com.qa.base.GetPSDSESSION;
import org.testng.annotations.Test;

public class TestQueryUser  {

    @Test
    public void queeyUser(){
        GetPSDSESSION getPass =new GetPSDSESSION();
        String cookiePass=getPass.getPSDSESSION();
        System.out.println(cookiePass);

    }
}
