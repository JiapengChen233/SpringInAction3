package com.cjp.spitter.jms.rpc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:message-context.xml"
})
public class AlertServiceTest {

    @Autowired
    private AlertService alertService;

    @Test
    public void testSendAlert() {
        alertService.sendAlert();
        System.out.println("test");
    }
}
