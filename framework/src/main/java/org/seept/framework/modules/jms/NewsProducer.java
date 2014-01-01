package org.seept.framework.modules.jms;

import org.springframework.jms.core.JmsTemplate;

import javax.jms.Destination;
import java.util.Map;

/**
 * @author : lihaoquan
 *
 * 新闻消息生成器, 把新闻消息推送到queue或topic中
 */
public class NewsProducer {

    private JmsTemplate jmsTemplate;
    private Destination notifyQueue;
    private Destination notifyTopic;

    /**
     * 发送去队列
     */
    public void sendToQueue(final Map<String,String> messages) {
        sendNews(messages,notifyQueue);
    }

    /**
     *发送到订阅中
     */
    public void sendToTopic(final Map<String,String> messages) {
        sendNews(messages,notifyTopic);
    }

    /**
     * 发送新闻
     * @param messages
     * @param destination
     */
    private void sendNews(Map<String,String> messages,Destination destination) {
        jmsTemplate.convertAndSend(destination,messages);
    }


    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void setNotifyQueue(Destination notifyQueue) {
        this.notifyQueue = notifyQueue;
    }

    public void setNotifyTopic(Destination notifyTopic) {
        this.notifyTopic = notifyTopic;
    }
}
