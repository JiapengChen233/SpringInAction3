package com.cjp.spitter.service;

import com.cjp.spiter.persistence.SpitterDao;
import com.cjp.spitter.domain.Spitter;
import com.cjp.spitter.domain.Spittle;

import java.util.Collections;
import java.util.List;

public class SpitterServiceImpl implements SpitterService {

    private SpitterDao spitterDao;

    public SpitterDao getSpitterDao() {
        return spitterDao;
    }

    public void setSpitterDao(SpitterDao spitterDao) {
        this.spitterDao = spitterDao;
    }

    @Override
    public void saveSpitter(Spitter spitter) {
        if (spitter.getId() == null) {
            spitterDao.addSpitter(spitter);
        } else {
            spitterDao.saveSpitter(spitter);
        }
    }

    @Override
    public Spitter getSpitter(long id) {
        return spitterDao.getSpitterById(id);
    }

    @Override
    public Spitter getSpitter(String username) {
        return spitterDao.getSpitterByUsername(username);
    }

    @Override
    public List<Spitter> getAllSpitters() {
        return spitterDao.findAllSpitters();
    }

    @Override
    public Spittle getSpittleById(long id) {
        return spitterDao.getSpittleById(id);
    }

    @Override
    public void saveSpittle(Spittle spittle) {
        spitterDao.saveSpittle(spittle);
    }

    @Override
    public void deleteSpittle(long id) {
        spitterDao.deleteSpittle(id);
    }

    @Override
    public List<Spittle> getRecentSpittles(int count) {
        List<Spittle> recentSpittles = spitterDao.getRecentSpittle();
        Collections.reverse(recentSpittles);
        return recentSpittles.subList(0, Math.min(49, recentSpittles.size()));
    }

    @Override
    public List<Spittle> getSpittlesForSpitter(Spitter spitter) {
        return spitterDao.getSpittlesByUsername(spitter);
    }

    @Override
    public List<Spittle> getSpittlesForSpitter(String username) {
        Spitter spitter = new Spitter();
        spitter.setUsername(username);
        return spitterDao.getSpittlesByUsername(spitter);
    }

    @Override
    public void startFollowing(Spitter follower, Spitter followee) {

    }
}
