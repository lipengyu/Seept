package org.seept.framework.core.util;

import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;

/**
 * @author: Quan
 * @Description: 消息摘要工具类
 *
 * 支持SHA-1/MD5散列
 */
public class DigestsUtil {

    private static final String SHA1 = "SHA-1";
    private static final String MD5 = "MD5";

    private static SecureRandom random = new SecureRandom();

    /**
     * SHA-1加密
     * @param input
     * @return
     */
    public static byte[] sha1(byte[] input) {
        return null;
    }

    /**
     * MD5加密
     * @param input
     * @return
     */
    public static byte[] md5(InputStream  input) throws IOException {
        return null;
    }


    /**
     * 核心摘要分析方法
     * @return
     */
    private static byte[] digest(byte[] input , int iterations) {
        return null;
    }

    private static byte[] digest(InputStream input, String algorithm) throws IOException{
        return null;
    }
}
