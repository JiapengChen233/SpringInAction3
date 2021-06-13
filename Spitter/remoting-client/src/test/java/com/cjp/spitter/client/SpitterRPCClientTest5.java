package com.cjp.spitter.client;

import com.cjp.spitter.client.jaxws.Spitter;
import com.cjp.spitter.client.jaxws.Spittle;
import com.cjp.spitter.client.service.SpitterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:jaxws-client-context.xml"
})
public class SpitterRPCClientTest5 {

    @Autowired
    private SpitterService spitterService;

    @Test
    public void test() {
        Spitter spitter = new Spitter();
        spitter.setUsername("artnames");
        List<Spittle> spittles = spitterService.getSpittlesForSpitter(spitter);
        for (Spittle spittle : spittles) {
            System.out.println(spittle);
        }
    }
}
