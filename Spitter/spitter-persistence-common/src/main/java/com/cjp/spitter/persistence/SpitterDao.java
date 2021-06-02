package com.cjp.spitter.persistence;

import com.cjp.spitter.domain.Spitter;
import com.cjp.spitter.domain.Spittle;

import java.util.List;

public interface SpitterDao {

    void addSpitter(Spitter spitter);

    void saveSpitter(Spitter spitter);

    Spitter getSpitterById(long id);

    List<Spitter> findAllSpitters();

    Spitter getSpitterByUsername(String username);

    void deleteSpittle(long id);

    Spittle getSpittleById(long id);

    List<Spittle> getRecentSpittle();

    void addSpittle(Spittle spittle);

    void saveSpittle(Spittle spittle);

    List<Spittle> getSpittlesByUsername(Spitter spitter);

}
