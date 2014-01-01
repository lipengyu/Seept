package org.seept.framework.modules.jms;

import com.google.common.collect.Maps;
import org.junit.Test;
import org.seept.framework.test.springtest.TransactionalTestCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

import java.util.Map;

/**
 * @author : lihaoquan
 */
@DirtiesContext
@ContextConfiguration(locations = { "/applicationContext.xml", "/jms/applicationContext-jms.xml" })
public class JmsTest extends TransactionalTestCase {

    @Autowired
    private NewsProducer newsProducer;

    /**
     * 测试队列新闻
     */
    @Test
    public void queueNews() {

        Map<String,String> map = Maps.newHashMap();
        map.put("text","sendToQueuesendToQueuesendToQueuesendToQueue");

        newsProducer.sendToQueue(map);

    }


    /**
     * 测试订阅新闻
     */
    @Test
    public void topicNews() {

        Map<String,String> map = Maps.newHashMap();
        map.put("text","sendToTopicsendToTopicsendToTopicsendToTopic");

        newsProducer.sendToTopic(map);

    }
}
