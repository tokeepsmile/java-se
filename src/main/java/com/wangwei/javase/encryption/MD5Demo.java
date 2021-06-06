package com.wangwei.javase.encryption;

import org.springframework.util.DigestUtils;

import java.security.MessageDigest;

/**
 * @auther wangwei
 * @date 2019-06-14 11:13
 */
public class MD5Demo {

    private static final String slat = "&%5123***&&%%$$#@";

    public static void main(String[] args) {
        String demo = "wangwei";

        String springMD5 = springmd5Encrypt(demo);

        String javaMD5 = javamd5Encrypt(demo);

        System.out.println("springMD5 :" + springMD5);

        System.out.println("javaMD5 :" + javaMD5);

    }


    public static String springmd5Encrypt(String source){
        source = source + "/" + slat;
        return DigestUtils.md5DigestAsHex(source.getBytes());
    }

    public static String javamd5Encrypt(String source){
        source = source + "/" + slat;

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");

            md.update(source.getBytes("UTF8"));

            byte[] b = md.digest();

            String result = "";
            for (int i = 0; i < b.length; i++) {
                result += Integer.toHexString((0x000000FF & b[i]) | 0xFFFFFF00).substring(6);
            }

            return result;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }
}
