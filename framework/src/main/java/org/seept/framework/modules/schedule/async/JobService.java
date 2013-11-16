package org.seept.framework.modules.schedule.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author : lihaoquan
 */
public class JobService {

    Logger logger = LoggerFactory.getLogger(JobService.class);

    @Scheduled(cron = "0/5 * * * * *")
    public void doTask() {

        System.out.println("执行定时调度任务");
    }
}
