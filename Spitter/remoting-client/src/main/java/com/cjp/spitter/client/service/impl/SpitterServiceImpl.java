package com.cjp.spitter.client.service.impl;

import com.cjp.spitter.client.jaxws.Spittle;
import com.cjp.spitter.client.service.SpitterService;

import com.cjp.spitter.client.jaxws.Spitter;
import com.cjp.spitter.client.jaxws.SpitterServiceEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SpitterServiceImpl implements SpitterService {

    @Autowired
    private SpitterServiceEndpoint spitterService;

    @Override
    public void addSpittle(Spittle spittle) {
        spitterService.addSpittle(spittle);
    }

    @Override
    public void deleteSpittle(long spittleId) {
        spitterService.deleteSpittle(spittleId);
    }

    @Override
    public List<Spittle> getRecentSpittles(int spittleCount) {
        return spitterService.getRecentSpittles(spittleCount);
    }

    @Override
    public List<Spittle> getSpittlesForSpitter(Spitter spitter) {
        return spitterService.getSpittlesForSpitter(spitter);
    }
}
