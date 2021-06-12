package com.cjp.spitter.client;

import com.cjp.spitter.domain.Spittle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:hessian-client-context.xml"
})
public class SpitterRPCClientTest2 {

    @Autowired
    private SpitterRPCClient spitterRPCClient;

    @Test
    public void test() {
        List<Spittle> spittles = spitterRPCClient.getSpittles("artnames");
        for (Spittle spittle : spittles) {
            System.out.println(spittle);
        }
    }

}
