package com.cjp.spitter.jms;

import com.cjp.spitter.domain.Spittle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.JmsUtils;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;

@Component
public class AlertServiceReceiver {

    @Autowired
    private JmsTemplate jmsTemplate;

    /**
     * 会阻塞直至收到消息或等待超时
     */
    public Spittle getAlert() {
        ObjectMessage receivedMessage = (ObjectMessage) jmsTemplate.receive();
        try {
            return (Spittle) receivedMessage.getObject();
        } catch (JMSException e) {
            throw JmsUtils.convertJmsAccessException(e);
        }
    }
}
