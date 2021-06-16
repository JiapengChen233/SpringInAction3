package com.cjp.spitter.jms.rpc.lingo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SenderMain {

    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("message-context.xml");
    }
}
