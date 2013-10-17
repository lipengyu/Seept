package org.seept.framework.test.springtest;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/**
 * @author: Quan
 * @Description: 普通的单元测试用例
 *
 * 当应用上下文载入这个类的时候,会激活test-Profiles注册下的bean
 *
 * 本case用于普通的逻辑单元测试
 */
@ActiveProfiles(ProfilesInfo.TESTING)
public class NomalTestCase extends AbstractJUnit4SpringContextTests {

}
