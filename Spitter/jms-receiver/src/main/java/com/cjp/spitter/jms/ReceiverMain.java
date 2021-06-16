package com.cjp.spitter.jms;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ReceiverMain {

    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("message-context.xml");
    }
}
