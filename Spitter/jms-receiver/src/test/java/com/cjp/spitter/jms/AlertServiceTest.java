package com.cjp.spitter.jms;

import com.cjp.spitter.domain.Spittle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:message-context.xml",
        "classpath:test-message-context.xml"
})
public class AlertServiceTest {

    @Autowired
    private AlertServiceReceiver alertServiceReceiver;

    /**
     * 接收消息（阻塞等待）
     */
    @Test
    public void testGetAlert() {
        Spittle spittle = alertServiceReceiver.getAlert();
    }

}
