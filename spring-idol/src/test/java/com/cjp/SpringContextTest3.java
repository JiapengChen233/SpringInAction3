package com.cjp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:spring-idol-context3.xml"
})
public class SpringContextTest3 {

    @Autowired
    private ApplicationContext ctx;

    @Test
    public void autowireByAnnotation() {
        Performer kenny = (Performer) ctx.getBean("kenny");
        assertNotNull(kenny);
        kenny.perform();
    }

    @Test
    public void autowireSimpleValueByAnnotation() {
        Config config = (Config) ctx.getBean("config");
        System.out.println("Path is: " + config.getPath());
    }


}