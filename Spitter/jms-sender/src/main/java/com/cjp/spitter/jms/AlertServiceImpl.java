package com.cjp.spitter.jms;

import com.cjp.spitter.domain.Spittle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

@Component
public class AlertServiceImpl implements AlertService {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Override
    public void sendSpittleAlert(Spittle spittle) {
        jmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createObjectMessage(spittle);
            }
        });
    }
}
