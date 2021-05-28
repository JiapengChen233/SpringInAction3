package com.cjp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:spring-idol-context.xml"
})
public class SpringContextTest {

    @Autowired
    private ApplicationContext ctx;

    @Test
    public void createASimpleBean() {
        Performer duke = (Performer) ctx.getBean("duke");
        assertNotNull(duke);
        duke.perform();
    }

    @Test
    public void injectByConstructor() {
        Performer duke = (Performer) ctx.getBean("duke2");
        assertNotNull(duke);
        duke.perform();
    }

    @Test
    public void injectObjectReferenceByConstructor() {
        Performer poeticDuke = (Performer) ctx.getBean("poeticDuke");
        assertNotNull(poeticDuke);
        poeticDuke.perform();
    }

    @Test
    public void createBeanByFactoryMethod() {
        Stage theStage = (Stage) ctx.getBean("theStage");
        assertNotNull(theStage);
    }

    @Test
    public void definePrototype() {
        Ticket ticket = (Ticket) ctx.getBean("ticket");
        Ticket ticket2 = (Ticket) ctx.getBean("ticket");
        assertNotEquals(ticket, ticket2);
    }
}