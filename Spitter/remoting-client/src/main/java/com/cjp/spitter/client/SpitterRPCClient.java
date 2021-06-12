package com.cjp.spitter.client;

import java.util.List;

import com.cjp.spitter.domain.Spitter;
import com.cjp.spitter.domain.Spittle;
import com.cjp.spitter.service.SpitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SpitterRPCClient {

    @Autowired
    private SpitterService spitterService;

    public List<Spittle> getSpittles(String userName) {
        Spitter spitter = spitterService.getSpitter(userName);
        return spitterService.getSpittlesForSpitter(spitter);
    }

}
