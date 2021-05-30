package com.cjp.spitter.persistence;

import com.cjp.spiter.persistence.SpitterDao;
import com.cjp.spitter.domain.Spitter;
import com.cjp.spitter.domain.Spittle;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HibernateSpitterDao implements SpitterDao {

    private SessionFactory sessionFactory;

    @Autowired
    public HibernateSpitterDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addSpitter(Spitter spitter) {
        currentSession().save(spitter);
    }

    @Override
    public void saveSpitter(Spitter spitter) {
        currentSession().update(spitter);
    }

    @Override
    public Spitter getSpitterById(long id) {
        return (Spitter) currentSession().get(Spitter.class, id);
    }

    @Override
    public List<Spitter> findAllSpitters() {
        return currentSession().createCriteria(Spitter.class).list();
    }

    @Override
    public Spitter getSpitterByUsername(String username) {
        return null;
    }

    @Override
    public List<Spittle> getRecentSpittle() {
        return null;
    }

    @Override
    public void saveSpittle(Spittle spittle) {
    }

    @Override
    public List<Spittle> getSpittlesByUsername(Spitter spitter) {
        return null;
    }

    @Override
    public void deleteSpittle(long id) {
        currentSession().delete(getSpittleById(id));
    }

    @Override
    public Spittle getSpittleById(long id) {
        return (Spittle) currentSession().get(Spittle.class, id);
    }

}
