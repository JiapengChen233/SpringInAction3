package com.cjp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:spring-aop-context.xml"
})
public class SpringAOPTest {

    @Autowired
    private ApplicationContext ctx;

    @Test
    public void testAopBeforeAndAfter() {
        Performer performer = (Performer) ctx.getBean("eddie");
        performer.perform();
    }
}
