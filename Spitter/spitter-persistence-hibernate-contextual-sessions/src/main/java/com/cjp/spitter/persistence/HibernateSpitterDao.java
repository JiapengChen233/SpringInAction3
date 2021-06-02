package com.cjp.spitter.persistence;

import com.cjp.spitter.domain.Spitter;
import com.cjp.spitter.domain.Spittle;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class HibernateSpitterDao implements SpitterDao {

    private static final String SQL_SELECT_SPITTLE = "from Spittle s";
    private static final String SQL_SELECT_SPITTLE_BY_USERNAME = SQL_SELECT_SPITTLE + ", Spitter s2 where s.spitter.id = s2.id and s2.username=?";

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
        return (Spitter) currentSession().get(Spitter.class, username);
    }

    @Override
    public List<Spittle> getRecentSpittle() {
        return currentSession().createCriteria(Spittle.class).list();
    }

    @Override
    public void addSpittle(Spittle spittle) {
        currentSession().save(spittle);
    }

    @Override
    public void saveSpittle(Spittle spittle) {
        currentSession().update(spittle);
    }

    @Override
    public List<Spittle> getSpittlesByUsername(Spitter spitter) {
        Query query = currentSession().createQuery(SQL_SELECT_SPITTLE_BY_USERNAME);
        query.setParameter(0, spitter.getUsername());
        List list = query.list();
        List<Spittle> resList = new ArrayList<>();
        for (Object o : list) {
            Object[] object = (Object[]) o;
            if (object[0] instanceof Spittle) {
                Spittle spittle = (Spittle) object[0];
                resList.add(spittle);
            }
        }
        return resList;
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
