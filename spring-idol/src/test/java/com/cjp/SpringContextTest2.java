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
        "classpath:spring-idol-context2.xml"
})
public class SpringContextTest2 {

    @Autowired
    private ApplicationContext ctx;

    @Test
    public void autowireByName() {
        Performer kenny = (Performer) ctx.getBean("kenny");
        assertNotNull(kenny);
        kenny.perform();
    }

    @Test
    public void autowireByType() {
        Performer kenny = (Performer) ctx.getBean("kenny2");
        assertNotNull(kenny);
        kenny.perform();
    }

    @Test
    public void autowireByConstructor() {
        Performer poeticDuke = (Performer) ctx.getBean("poeticDuke");
        assertNotNull(poeticDuke);
        poeticDuke.perform();
    }
}