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
}
