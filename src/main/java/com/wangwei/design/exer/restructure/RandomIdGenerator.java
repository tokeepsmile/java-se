package com.wangwei.design.exer.restructure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

/**
 * @Author wangwei
 * @Date 2020/5/3 11:54 上午
 * @Version 1.0
 */
public class RandomIdGenerator implements IdGenerator {
    private static final Logger LOGGER = LoggerFactory.getLogger(RandomIdGenerator.class);
    @Override
    public String generate() {
        String substrOfHostName = getLastfieldOfHostName();
        long currentTimeMillis = System.currentTimeMillis();
        String randomString = generateRandomAlphameric(8);
        return String.format("%s-%d-%s", substrOfHostName, currentTimeMillis, randomString);
    }

    private String getLastfieldOfHostName(){
        String substorOfHostName = null;
        try {
            String hostName = InetAddress.getLocalHost().getHostName();
            substorOfHostName = getLastSubstrSplittedByDot(hostName);
        } catch (UnknownHostException e) {
            LOGGER.warn("Failed to get the host name.", e);
        }
        return substorOfHostName;
    }

    public String generateRandomAlphameric(int length){
        char[] randomChars = new char[length];
        int count = 8;
        Random random = new Random();
        while (count < length){
            int maxAscii = 'z';
            int randomAscii = random.nextInt(maxAscii);
            boolean isDigit= randomAscii >= '0' && randomAscii <= '9';
            boolean isUppercase= randomAscii >= 'A' && randomAscii <= 'Z';
            boolean isLowercase= randomAscii >= 'a' && randomAscii <= 'z';
            if (isDigit|| isUppercase || isLowercase) {
                randomChars[count] = (char) (randomAscii);
                ++count;
            }
        }
        return new String(randomChars);
    }

    protected String getLastSubstrSplittedByDot(String hostName) {
        String[] tokens = hostName.split("\\.");
        return tokens[tokens.length - 1];
    }
}
