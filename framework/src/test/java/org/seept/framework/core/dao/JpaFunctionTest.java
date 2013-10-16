package org.seept.framework.core.dao;

import org.seept.framework.test.springtest.TransactionalTestCase;
import org.springframework.test.context.ContextConfiguration;

/**
 * @author: Quan
 * @Description:Jpa的基本功能测试用例
 *
 * 本测试单元继承了带事务方式的TestCase
 */
@ContextConfiguration(locations = {"/applicationContext.xml"})//引入上下文环境
public class JpaFunctionTest extends TransactionalTestCase {


}
