package org.seept.framework.modules.schedule;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.apache.commons.lang3.Validate;
import org.springframework.scheduling.support.TaskUtils;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author: Quan
 * @Description: 使用基于JDK的Timer的作业调度方式
 */
public class JdkBasicJob implements Runnable {


    private int interval = 0;//执行的时间间隔

    private int initialDelay = 0;//初始化延迟

    private int shutdownTimeout = Integer.MAX_VALUE;

    private ScheduledExecutorService scheduledExecutorService;

    @PostConstruct
    public void start() throws Exception {
        System.out.println("jdk basic 上下文初始化 ...");

        Validate.isTrue(interval>0);

        //设置运行任务
        Runnable runnableTask = TaskUtils.decorateTaskWithErrorHandler(this,null,true);

        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor(new ThreadFactoryBuilder().setNameFormat(
                "JdkBasicJob-%1$d").build());

        scheduledExecutorService.scheduleAtFixedRate(runnableTask, initialDelay, interval, TimeUnit.SECONDS);
    }

    @PreDestroy
    public void stop() throws Exception {
        System.out.println("jdk basic 上下文结束 ... ");
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
        //crawlerScanner.executeByJdk();
        System.out.println("-----------executeByJdk");
    }


    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public int getInitialDelay() {
        return initialDelay;
    }

    public void setInitialDelay(int initialDelay) {
        this.initialDelay = initialDelay;
    }

    public int getShutdownTimeout() {
        return shutdownTimeout;
    }

    public void setShutdownTimeout(int shutdownTimeout) {
        this.shutdownTimeout = shutdownTimeout;
    }
}
