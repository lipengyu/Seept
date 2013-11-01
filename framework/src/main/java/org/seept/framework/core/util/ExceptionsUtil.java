package org.seept.framework.core.util;

/**
 * @author: Quan
 * @Description:
 */
public class ExceptionsUtil {

    /**
     * 把Checked类型的异常转化为UnChecked类型的异常
     * @param e
     * @return
     */
    public static RuntimeException exceptionUnchecked(Exception e) {
        if(e instanceof RuntimeException) {
            return (RuntimeException) e;
        }else {
            return new RuntimeException(e);
        }
    }
}
