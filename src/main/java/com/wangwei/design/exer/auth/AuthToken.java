package com.wangwei.design.exer.auth;

import java.util.Date;
import java.util.Map;
import java.util.Objects;

/**
 * @Author wangwei
 * @Date 2020/12/15 下午4:46
 * @Version 1.0
 * 1 把 URL、AppID、密码、时间戳拼接为一个字符串；
 * 2 对字符串通过加密算法加密生成 token；
 * 3 将 token、AppID、时间戳拼接到 URL 中，形成新的 URL；
 * 4 解析 URL，得到 token、AppID、时间戳等信息；
 * 5 从存储中取出 AppID 和对应的密码；
 * 6 根据时间戳判断 token 是否过期失效；
 * 7 验证两个 token 是否匹配
 */
public class AuthToken {
    private static final long EXPIRED_TIME_INTERVAL = 10 * 60 * 1000L;
    private String token;
    private long createTime;

    public AuthToken(String token, long createTime) {
        this.token = token;
        this.createTime = createTime;
    }


    public static AuthToken create(String baseUrl, long createTime, Map<String, String> params){
        return null;
    }

    public String getToken(){
        return token;
    }

    public boolean isExpired(){
        long time = new Date().getTime();
        return this.createTime > time + EXPIRED_TIME_INTERVAL;
    }

    public boolean match(AuthToken authToken){
        return Objects.equals(this.token, authToken.getToken());
    }

    public static void main(String[] args) {
        //int minute = (int) LocalDateTime.now().getLong(ChronoField.);
        long time = new Date().getTime();
        System.out.println(time);
    }
}
