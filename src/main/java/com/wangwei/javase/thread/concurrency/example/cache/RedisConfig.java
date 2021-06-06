package com.wangwei.javase.thread.concurrency.example.cache;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Auther wangwei
 * @Date 2018/4/25 下午4:54
 */
@Component
@ConfigurationProperties(prefix = "redis")
@Data
public class RedisConfig {

    private String host;

    private int port;


}
