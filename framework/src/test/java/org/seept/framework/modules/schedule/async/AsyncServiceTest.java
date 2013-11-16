package org.seept.framework.modules.schedule.async;

import org.junit.Test;
import org.seept.framework.test.springtest.TransactionalTestCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;

/**
 * @author : lihaoquan
 */

@ContextConfiguration(locations = {"/applicationContext.xml","/schedule/applicationContext-asyn.xml"})
public class AsyncServiceTest extends TransactionalTestCase {

    @Autowired
    @Qualifier("AsyncService")
    private AsyncService asyncService;

    @Test
    public void doSomething() throws Exception{
         System.out.println("开始");
         asyncService.update();
         System.out.println("结束");

         Thread.sleep(50000);
    }
}
