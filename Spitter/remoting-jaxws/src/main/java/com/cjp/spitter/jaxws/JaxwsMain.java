package com.cjp.spitter.jaxws;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JaxwsMain {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "remote-service-context.xml",
                "service-context.xml",
                "persistence-context.xml",
                "dataSource-context.xml");
    }
}
