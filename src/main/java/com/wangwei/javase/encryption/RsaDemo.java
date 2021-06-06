package com.wangwei.javase.encryption;


import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.util.Base64Utils;
import org.springframework.util.StringUtils;

import javax.crypto.Cipher;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.*;

import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

/**
 * @auther wangwei
 * @date 2019-05-17 11:10
 */
public class RsaDemo {

    public static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;

    static {
        if (Security.getProperty(BouncyCastleProvider.PROVIDER_NAME) == null) {
            Security.addProvider(new BouncyCastleProvider());
        }
    }

    /**
     * 加密算法RSA
     */
    public static final String KEY_ALGORITHM = "RSA";

    /**
     * 填充方式
     */
    public static final String KEY_ALGORITHM_PADDING = "RSA/ECB/PKCS1Padding";

    /**
     * 密钥位数 1024 2048
     */
    public static final int RAS_KEY_SIZE = 2048;

   public static Map<String, String> generateKeyPair() throws NoSuchAlgorithmException {
       /** RSA算法要求有一个可信任的随机数源 */
       SecureRandom secureRandom = new SecureRandom();

       /** 为RSA算法创建一个KeyPairGenerator对象 */
       KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(KEY_ALGORITHM);

       /** 利用上面的随机数据源初始化这个KeyPairGenerator对象 */
       keyPairGenerator.initialize(RAS_KEY_SIZE, secureRandom);

       /** 生成密匙对 */
       KeyPair keyPair = keyPairGenerator.genKeyPair();

       /** 得到公钥 */
       Key publicKey = keyPair.getPublic();
       byte[] publicKeyBytes = publicKey.getEncoded();
       String pucKey = Base64Utils.encodeToString(publicKeyBytes);

       /** 得到私钥 */
       Key privateKey = keyPair.getPrivate();
       byte[] privateKeyBytes = privateKey.getEncoded();
       String priKey = Base64Utils.encodeToString(privateKeyBytes);

       Map<String, String> keyMap = new HashMap<>(3);
       keyMap.put("publicKey", pucKey);
       keyMap.put("PrivateKey", priKey);

       RSAPublicKey rsaPublicKey = (RSAPublicKey) keyPair.getPublic();
       BigInteger bint = rsaPublicKey.getModulus();
       byte[] bytes = bint.toByteArray();
       String retValue = Base64Utils.encodeToString(bytes);

       keyMap.put("modulus", retValue);

       return keyMap;
   }


    /**
     * 公钥加密
     *
     * @param plaintext 明文
     * @param publicKey 公钥串(base64)
     * @return 密文串(base64)
     * @throws Exception
     */
    public static String encrypt(byte[] plaintext, String publicKey, String charset) throws Exception {
        return encrypt(plaintext, getPublicKey(publicKey), charset);
    }

    /**
     * 公钥加密
     * @param plaintext 明文
     * @param publicKey 公钥
     * @param charsetName
     * @return 密文串(base64)
     * @throws Exception
     */
   public static String encrypt(byte[] plaintext, PublicKey publicKey, String charsetName) throws Exception{
       Charset charset = DEFAULT_CHARSET;
       if (!StringUtils.isEmpty(charsetName))
           charset = Charset.forName(charsetName);

       Key key = publicKey;

       Cipher cipher = Cipher.getInstance(publicKey.getAlgorithm(), BouncyCastleProvider.PROVIDER_NAME);

       cipher.init(Cipher.ENCRYPT_MODE, key);

       byte[] bytes = cipher.doFinal(plaintext);

       return new String(Base64Utils.encode(bytes), charset);

   }


    /**
     * 私钥解密
     *
     * @param ciphertext 密文串(base64)
     * @param privateKey 秘钥
     * @return 明文
     * @throws Exception
     */
    public static byte[] decrypt(String ciphertext, String privateKey, String charset) throws Exception {
        return decrypt(ciphertext, getPrivateKey(privateKey), charset);
    }

    /**
     * 私钥解密
     *
     * @param ciphertext 密文串(base64)
     * @param privateKey 秘钥
     * @return 明文
     * @throws Exception
     */
    public static byte[] decrypt(String ciphertext, PrivateKey privateKey, String charsetName) throws Exception {
        Charset charset = DEFAULT_CHARSET;
        if (!StringUtils.isEmpty(charsetName)) {
            charset = Charset.forName(charsetName);
        }
        Key key = privateKey;
        /** 得到Cipher对象对已用公钥加密的数据进行RSA解密 */
        Cipher cipher = Cipher.getInstance(privateKey.getAlgorithm(), BouncyCastleProvider.PROVIDER_NAME);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] b1 = Base64Utils.decode(ciphertext.getBytes(charset));
        /** 执行解密操作 */
        byte[] b = cipher.doFinal(b1);
        return b;
    }


    /**
     * 获取公钥
     *
     * @param key 公钥串(base64)
     * @throws Exception
     */
    public static PublicKey getPublicKey(String key) throws Exception {
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64Utils.decodeFromString(key));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(keySpec);
        return publicKey;
    }

    /**
     * 私钥
     *
     * @param key 私钥串(base64)
     * @throws Exception
     */
    public static PrivateKey getPrivateKey(String key) throws Exception {
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(Base64Utils.decodeFromString(key));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
        return privateKey;
    }

    public static void main(String[] args) throws Exception {
        PublicKey wangwei = getPublicKey("wangwei");

        System.out.println(Base64Utils.encodeToString(wangwei.getEncoded()));
    }
}
