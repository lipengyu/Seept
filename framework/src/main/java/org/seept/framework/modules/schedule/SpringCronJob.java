package org.seept.framework.modules.schedule;

import org.apache.commons.lang3.Validate;
import org.seept.framework.modules.nutch.CrawlerScanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author: Quan
 * @Description:
 */
public class SpringCronJob implements Runnable {

    private String cronExpression;

    private int shutdownTimeout = Integer.MAX_VALUE;

    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    @Autowired
    private CrawlerScanner crawlerScanner;

    /**
     * 初始化启动
     */
    @PostConstruct
    public void start() {
        Validate.notBlank(cronExpression);
        threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
        threadPoolTaskScheduler.setThreadNamePrefix("SpringCronJob");
        threadPoolTaskScheduler.initialize();
        threadPoolTaskScheduler.schedule(this, new CronTrigger(cronExpression));
    }

    /**
     * 初始化结束
     */
    @PreDestroy
    public void stop() {
        ScheduledExecutorService scheduledExecutorService = threadPoolTaskScheduler.getScheduledExecutor();
        try{
            scheduledExecutorService.shutdownNow();
            if (!scheduledExecutorService.awaitTermination(shutdownTimeout, TimeUnit.SECONDS)) {
                System.err.println("scheduledExecutorService did not terminated");
            }
        }catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void run() {
        crawlerScanner.executeBySpringCron();
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public int getShutdownTimeout() {
        return shutdownTimeout;
    }

    public void setShutdownTimeout(int shutdownTimeout) {
        this.shutdownTimeout = shutdownTimeout;
    }
}
