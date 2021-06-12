package com.cjp.spitter.client.rmi;

import com.cjp.spitter.domain.Spittle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:rmi-client-context.xml"
})
public class SpitterRmiClientTest {

    @Autowired
    private SpitterRmiClient spitterRmiClient;

    @Test
    public void test() {
        List<Spittle> spittles = spitterRmiClient.getSpittles("artnames");
        for (Spittle spittle : spittles) {
            System.out.println(spittle);
        }
    }

}
