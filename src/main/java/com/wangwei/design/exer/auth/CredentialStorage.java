package com.wangwei.design.exer.auth;

/**
 * @Author wangwei
 * @Date 2020/2/24 10:36 上午
 * @Version 1.0
 */
public interface CredentialStorage {
    String getPasswordByAppId(String appId);
}
