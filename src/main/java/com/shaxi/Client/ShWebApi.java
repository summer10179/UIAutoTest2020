package com.shaxi.Client;

public class ShWebApi {

    private String url;
    private String Cookies;

    public ShWebApi(){

}
    public String  getSession(){
        return  Cookies;
    }
    public  ShWebApi setCookie( String Cookies){
        this.Cookies=Cookies;
        return this;
    }

}
