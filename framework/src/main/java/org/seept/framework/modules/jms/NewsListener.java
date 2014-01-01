package org.seept.framework.modules.jms;

import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * @author : lihaoquan
 */
public class NewsListener implements MessageListener {


    /**
     * 通过继承的消息处理函数
     * @param message
     */
    @Override
    public void onMessage(Message message) {
        try {

            MapMessage mapMessage = (MapMessage) message;

            if(null!=mapMessage.getString("text")) {
                System.out.println("接收到得消息是:"+mapMessage.getString("text"));
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
