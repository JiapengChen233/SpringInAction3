package com.cjp.spitter.service;

import com.cjp.spitter.persistence.SpitterDao;
import com.cjp.spitter.domain.Spitter;
import com.cjp.spitter.domain.Spittle;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

public class SpitterServiceImpl implements SpitterService {

    private SpitterDao spitterDao;
    private TransactionTemplate txTemplate;

    public SpitterDao getSpitterDao() {
        return spitterDao;
    }

    public void setSpitterDao(SpitterDao spitterDao) {
        this.spitterDao = spitterDao;
    }

    public TransactionTemplate getTxTemplate() {
        return txTemplate;
    }

    public void setTxTemplate(TransactionTemplate txTemplate) {
        this.txTemplate = txTemplate;
    }

    @Override
    public void saveSpitter(Spitter spitter) {
        txTemplate.execute(new TransactionCallback<Void>() {
            @Override
            public Void doInTransaction(TransactionStatus status) {
                try {
                    if (spitter.getId() == null) {
                        spitterDao.addSpitter(spitter);
                    } else {
                        spitterDao.saveSpitter(spitter);
                    }
                } catch (RuntimeException e) {
                    status.setRollbackOnly();
                    throw e;
                }
                return null;
            }
        });
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
        txTemplate.execute(new TransactionCallback<Void>() {
            @Override
            public Void doInTransaction(TransactionStatus status) {
                try {
                    spitterDao.saveSpittle(spittle);
                } catch (RuntimeException e) {
                    status.setRollbackOnly();
                    throw e;
                }
                return null;
            }
        });
    }

    @Override
    public void deleteSpittle(long id) {
        txTemplate.execute(new TransactionCallback<Void>() {
            @Override
            public Void doInTransaction(TransactionStatus status) {
                try {
                    spitterDao.deleteSpittle(id);
                } catch (RuntimeException e) {
                    status.setRollbackOnly();
                    throw e;
                }
                return null;
            }
        });
    }

    @Override
    public List<Spittle> getRecentSpittles(int count) {
        return spitterDao.getRecentSpittle();
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
