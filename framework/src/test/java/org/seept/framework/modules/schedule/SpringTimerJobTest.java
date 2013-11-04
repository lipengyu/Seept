package org.seept.framework.modules.schedule;

import org.junit.Test;
import org.seept.framework.test.springtest.TransactionalTestCase;
import org.springframework.test.context.ContextConfiguration;

/**
 * @author: Quan
 * @Description:
 */
@ContextConfiguration(locations = {"/applicationContext.xml","/schedule/applicationContext-springcron.xml"})
public class SpringTimerJobTest extends TransactionalTestCase {

    /**
     * 测试调度方式;
     */
    @Test
    public void testSchedule() throws Exception  {

        Thread.sleep(300000);

        System.out.println("==============testSchedule");
    }
}
