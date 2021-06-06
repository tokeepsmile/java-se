package com.wangwei.design.exer;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.util.Random;

/**
 * @Author wangwei
 * @Date 2020/5/3 10:56 上午
 * @Version 1.0
 * 代码是否实现了预期的业务需求？逻辑是否正确？
 * 是否处理了各种异常情况？日志打印是否得当？
 * 是否方便 debug 排查问题？接口是否易用？
 * 是否支持幂等、事务等？
 * 代码是否存在并发问题？是否线程安全？
 * 性能是否有优化空间，比如，SQL、算法是否可以优化？
 * 是否有安全漏洞？比如输入输出校验是否全面
 */

public class IdGenerator {
    private static final Logger logger = LoggerFactory.getLogger(IdGenerator.class);

    public static String generate() {
        String id = "";
        try {
            String hostName = InetAddress.getLocalHost().getHostName();
            String[] tokens = hostName.split("\\.");
            if (tokens.length > 0) {
                hostName = tokens[tokens.length - 1];
            }
            char[] randomChars = new char[8];
            int count = 0;
            Random random = new Random();
            while (count < 8) {
                int randomAscii = random.nextInt(122);
                if (randomAscii >= 48 && randomAscii <= 57) {
                    randomChars[count] = (char)('0' + (randomAscii - 48));
                    count++;
                } else if (randomAscii >= 65 && randomAscii <= 90) {
                    randomChars[count] = (char)('A' + (randomAscii - 65));
                    count++;
                } else if (randomAscii >= 97 && randomAscii <= 122) {
                    randomChars[count] = (char)('a' + (randomAscii - 97));
                    count++;
                }
            }
            id = String.format("%s-%d-%s", hostName,
                    System.currentTimeMillis(), new String(randomChars));
        } catch (Exception e) {
            logger.error("Failed to get the host name.", e);
        }

        return id;
    }

    public static void main(String[] args) {
        IdGenerator.generate();
    }
}