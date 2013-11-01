package org.seept.framework.core.util;

import org.apache.commons.lang3.Validate;

import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.SecureRandom;

/**
 * @author: Quan
 */
public class DigestsUtil {

    private static final String SHA1 = "SHA-1";
    private static final String MD5 = "MD5";

    private static SecureRandom random = new SecureRandom();

    /**
     * 生成随机的Byte[]作为salt.
     *
     * @param numBytes byte数组的大小
     */
    public static byte[] generateSalt(int numBytes) {
        Validate.isTrue(numBytes > 0, "numBytes argument must be a positive integer (1 or larger)", numBytes);

        byte[] bytes = new byte[numBytes];
        random.nextBytes(bytes);
        return bytes;
    }

    /**
     * @param input
     * @return
     */
    public static byte[] sha1(byte[] input) {
        return digest(input,SHA1,null,1);
    }

    public static byte[] sha1(byte[] input, byte[] salt) {
        return digest(input, SHA1, salt, 1);
    }

    public static byte[] sha1(byte[] input, byte[] salt, int iterations) {
        return digest(input, SHA1, salt, iterations);
    }

    /**
     * 对文件进行sha1散列.
     */
    public static byte[] sha1(InputStream input) throws IOException {
        return digest(input, SHA1);
    }

    /**
     * @param input
     * @return
     */
    public static byte[] md5(InputStream  input) throws IOException {
        return digest(input, MD5);
    }


    /**
     * 通过算法algorithm(MD5/SHA-1) 对字符串进行散列处理.
     * @return
     */
    private static byte[] digest(byte[] input , String algorithm,byte[] salt, int iterations) {
        try {

            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            if(salt!=null) {
                messageDigest.update(salt);
            }
            byte[] result = messageDigest.digest(input);

            for(int i = 1; i< iterations; i++) {
                messageDigest.reset();
                result = messageDigest.digest(input);
            }
            return result;
        }catch (Exception e) {
            throw ExceptionsUtil.exceptionUnchecked(e);
        }
    }

    private static byte[] digest(InputStream input, String algorithm) throws IOException{
        try {

            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            /**
             * 初始化8M
             */
            int bufferLength = 8 * 1024;
            byte[] buffer = new byte[bufferLength];

            int read = input.read(buffer, 0, bufferLength);
            while (read > -1) {
                messageDigest.update(buffer, 0, read);
                read = input.read(buffer, 0, bufferLength);
            }
            return messageDigest.digest();
        }catch (Exception e) {
            throw ExceptionsUtil.exceptionUnchecked(e);
        }
    }
}
