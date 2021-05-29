package com.cjp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:spring-aop-context2.xml"
})
public class SpringAOPTest2 {

    @Autowired
    private ApplicationContext ctx;

    @Test
    public void testAopAround() {
        Performer performer = (Performer) ctx.getBean("eddie");
        performer.perform();
    }

    @Test
    public void testInjectNewFunction() {
        Contestant performer = (Contestant) ctx.getBean("eddie");
        performer.receiveAward();
    }
}
