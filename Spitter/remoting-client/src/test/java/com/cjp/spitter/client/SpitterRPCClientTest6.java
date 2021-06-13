package com.cjp.spitter.client;


import com.cjp.spitter.client.jaxws.Spitter;
import com.cjp.spitter.client.jaxws.SpitterService;
import com.cjp.spitter.client.jaxws.SpitterServiceEndpoint;
import com.cjp.spitter.client.jaxws.Spittle;
import org.junit.Test;

import java.util.List;

public class SpitterRPCClientTest6 {

    @Test
    public void test() {
        SpitterService spitterService = new SpitterService();
        SpitterServiceEndpoint spitterServiceEndpointPort = spitterService.getSpitterServiceEndpointPort();
        Spitter spitter = new Spitter();
        spitter.setUsername("artnames");
        List<Spittle> spittles = spitterServiceEndpointPort.getSpittlesForSpitter(spitter);
        for (Spittle spittle : spittles) {
            System.out.println(spittle);
        }
    }
}