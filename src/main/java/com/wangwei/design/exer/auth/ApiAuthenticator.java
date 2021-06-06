package com.wangwei.design.exer.auth;


/**
 * @Author wangwei
 * @Date 2020/2/24 10:40 上午
 * @Version 1.0
 */
public interface ApiAuthenticator {

    void auth(String url);

    void auth(ApiRequest apiRequest);
}
