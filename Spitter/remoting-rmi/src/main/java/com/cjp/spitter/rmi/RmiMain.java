package com.cjp.spitter.rmi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RmiMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "remote-service-context.xml",
                "service-context.xml",
                "persistence-context.xml",
                "dataSource-context.xml");
    }
}
