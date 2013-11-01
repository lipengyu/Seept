package org.seept.framework.core.util;

import org.junit.Test;

/**
 * @author: Quan
 * @Description:
 *
 * 消息摘要工具类单元测试
 */
public class DigestsUtilTest {

    @Test
    public void digestStringTest() {

        String input = "lihaoquan";
        byte[] result1 = DigestsUtil.sha1(input.getBytes());

        System.out.println("result1 ==="+result1.toString());
        System.out.println("result1(Hex)==="+EncodesUtil.encodeHex(result1));

        System.out.println("\n");

        byte[] salt = DigestsUtil.generateSalt(8);
        System.out.println("salt ==="+salt.toString());
        System.out.println("salt(Hex)==="+EncodesUtil.encodeHex(salt));

        System.out.println("\n");

        byte[] result = DigestsUtil.sha1(input.getBytes(),salt,1024);
        System.out.println("result ==="+result.toString());
        System.out.println("result(Hex)==="+EncodesUtil.encodeHex(result));
    }
}
