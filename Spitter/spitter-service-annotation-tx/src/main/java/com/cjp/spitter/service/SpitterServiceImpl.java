package com.cjp.spitter.service;

import com.cjp.spiter.persistence.SpitterDao;
import com.cjp.spitter.domain.Spitter;
import com.cjp.spitter.domain.Spittle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class SpitterServiceImpl implements SpitterService {

     @Autowired
    private SpitterDao spitterDao;

    @Override
    public void saveSpitter(Spitter spitter) {
        if (spitter.getId() == null) {
            spitterDao.addSpitter(spitter);
        } else {
            spitterDao.saveSpitter(spitter);
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    @Override
    public Spitter getSpitter(long id) {
        return spitterDao.getSpitterById(id);
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    @Override
    public Spitter getSpitter(String username) {
        return spitterDao.getSpitterByUsername(username);
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    @Override
    public List<Spitter> getAllSpitters() {
        return spitterDao.findAllSpitters();
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
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

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    @Override
    public List<Spittle> getRecentSpittles(int count) {
        List<Spittle> recentSpittles = spitterDao.getRecentSpittle();
        Collections.reverse(recentSpittles);
        return recentSpittles.subList(0, Math.min(49, recentSpittles.size()));
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    @Override
    public List<Spittle> getSpittlesForSpitter(Spitter spitter) {
        return spitterDao.getSpittlesByUsername(spitter);
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
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
