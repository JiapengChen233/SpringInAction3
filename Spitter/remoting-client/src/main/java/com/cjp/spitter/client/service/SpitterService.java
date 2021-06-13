package com.cjp.spitter.client.service;


import com.cjp.spitter.client.jaxws.Spitter;
import com.cjp.spitter.client.jaxws.Spittle;

import java.util.List;

public interface SpitterService {

    void addSpittle(Spittle spittle);

    void deleteSpittle(long spittleId);

    List<Spittle> getRecentSpittles(int spittleCount);

    List<Spittle> getSpittlesForSpitter(Spitter spitter);

}