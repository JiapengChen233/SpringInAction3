package com.cjp.spitter.service;

import com.cjp.spitter.domain.Spitter;
import com.cjp.spitter.domain.Spittle;
import org.springframework.security.access.annotation.Secured;

import java.util.List;

public interface SpitterService {
    void saveSpitter(Spitter spitter);

    Spitter getSpitter(long id);

    Spitter getSpitter(String username);

    List<Spitter> getAllSpitters();

    Spittle getSpittleById(long id);

    void saveSpittle(Spittle spittle);

    void deleteSpittle(long id);

    List<Spittle> getRecentSpittles(int count);

    List<Spittle> getSpittlesForSpitter(Spitter spitter);

    @Secured("ROLE_ADMIN")
    List<Spittle> getSpittlesForSpitter(String username);

    void startFollowing(Spitter follower, Spitter followee);
}
