package org.seept.framework.modules.nutch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author: Quan
 * @Description: 爬虫扫描器
 */
@Component
public class CrawlerScanner {

    private static Logger logger = LoggerFactory.getLogger(CrawlerScanner.class);

    /**
     * 通过JDK的方式执行
     */
    public void executeByJdk() {
        execute("jdk basic job");
    }

    public void executeBySpringCron() {
        execute("spring cron job by java");
    }

    private void execute(String by) {
        long count = 80;
        logger.info("There are {} crawlers running now , printed by {}.", count, by);
    }
}
