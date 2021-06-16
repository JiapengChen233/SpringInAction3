package com.cjp.spitter.jms;

import com.cjp.spitter.domain.Spittle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:message-context.xml",
        "classpath:test-message-context.xml"
})
public class AlertServiceTest {

    @Autowired
    private AlertService alertService;

    /**
     * 发送消息
     */
    @Test
    public void testSendSpittleAlert() {
        Spittle spittle = new Spittle();
        spittle.setId(1L);
        spittle.setText("test");
        spittle.setPostedTime(new Date());
        alertService.sendSpittleAlert(spittle);
    }


}
