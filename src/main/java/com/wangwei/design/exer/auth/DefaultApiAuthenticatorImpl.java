package com.wangwei.design.exer.auth;

/**
 * @Author wangwei
 * @Date 2020/12/15 下午4:53
 * @Version 1.0
 */
public class DefaultApiAuthenticatorImpl implements ApiAuthenticator {
    @Override
    public void auth(String url) {
        ApiRequest apiRequest = ApiRequest.buildFromUrl(url);
    }

    @Override
    public void auth(ApiRequest apiRequest) {

    }
}
