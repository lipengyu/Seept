package org.seept.framework.modules.schedule.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author : lihaoquan
 */

@Service("AsyncService")
public class AsyncService {

    @Async
    public void update() {

        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("执行更新操作......");
    }
}
