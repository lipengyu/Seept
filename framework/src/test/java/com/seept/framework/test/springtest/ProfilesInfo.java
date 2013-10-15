package com.seept.framework.test.springtest;

/**
 * @author : lihaoquan
 */
public class ProfilesInfo {

    public static final String ACTIVE_PROFILE = "spring.profiles.active";
    public static final String PRODUCTION = "production";//生产模式
    public static final String DEVELOPMENT = "development";//开发模式
    public static final String TESTING = "test";//测试模型

    public static void setProfileAsSystemProperty(String profile) {
        System.setProperty(ACTIVE_PROFILE, profile);
    }
}
