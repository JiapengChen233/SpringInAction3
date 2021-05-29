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
        "classpath:spring-idol-context4.xml"
})
public class SpringContextTest4 {

    @Autowired
    private ApplicationContext ctx;

    @Autowired
    private Instrumentalist kenny;

    @Test
    public void autoScanByAnnotation() {
        assertNotNull(kenny);
        kenny.perform();
    }

}