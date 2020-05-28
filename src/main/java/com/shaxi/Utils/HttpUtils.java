package com.shaxi.Utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

import java.io.IOException;

public class HttpUtils{

public HttpResponse postWithCookies(String url, String json, String Cookie) throws IOException {
    HttpPost httpPost = new HttpPost(url);
    HttpClient httpClient=new HttpClient() {
        @Override
        public HttpParams getParams() {
            return null;
        }

        @Override
        public ClientConnectionManager getConnectionManager() {
            return null;
        }

        @Override
        public HttpResponse execute(HttpUriRequest request) throws IOException, ClientProtocolException {
            return null;
        }

        @Override
        public HttpResponse execute(HttpUriRequest request, HttpContext context) throws IOException, ClientProtocolException {
            return null;
        }

        @Override
        public HttpResponse execute(HttpHost target, HttpRequest request) throws IOException, ClientProtocolException {
            return null;
        }

        @Override
        public HttpResponse execute(HttpHost target, HttpRequest request, HttpContext context) throws IOException, ClientProtocolException {
            return null;
        }

        @Override
        public <T> T execute(HttpUriRequest request, ResponseHandler<? extends T> responseHandler) throws IOException, ClientProtocolException {
            return null;
        }

        @Override
        public <T> T execute(HttpUriRequest request, ResponseHandler<? extends T> responseHandler, HttpContext context) throws IOException, ClientProtocolException {
            return null;
        }

        @Override
        public <T> T execute(HttpHost target, HttpRequest request, ResponseHandler<? extends T> responseHandler) throws IOException, ClientProtocolException {
            return null;
        }

        @Override
        public <T> T execute(HttpHost target, HttpRequest request, ResponseHandler<? extends T> responseHandler, HttpContext context) throws IOException, ClientProtocolException {
            return null;
        }
    };
    httpPost.addHeader("Content-type", "application/json");
    httpPost.addHeader("Content-type", Cookie);

    StringEntity postingString = new StringEntity(json);
    httpPost.setEntity(postingString);

    HttpResponse httpResponse = httpClient.execute(httpPost);
    HttpEntity entity;

    return httpResponse;
}
}