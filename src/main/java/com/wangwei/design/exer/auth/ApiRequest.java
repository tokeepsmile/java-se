package com.wangwei.design.exer.auth;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author wangwei
 * @Date 2020/12/15 下午4:46
 * @Version 1.0
 */
public class ApiRequest {
    private String baseUrl;
    private String token;
    private String appId;
    private long timestamp;

    public ApiRequest(String baseUrl, String token, String appId, long timestamp) {
        this.baseUrl = baseUrl;
        this.token = token;
        this.appId = appId;
        this.timestamp = timestamp;
    }

    public static ApiRequest createFromFullUrl(String url){
        return null;
    }

    public static ApiRequest buildFromUrl(String url){
        return null;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public static void main(String[] args) throws UnknownHostException {
        String url = "https://time.geekbang.org/column/?id=123&appid=test&pwd=123456&ts=15555";

        String hostName = InetAddress.getLocalHost().getHostName();
        System.out.println(hostName);

        System.out.println((char)57);

    }
}
