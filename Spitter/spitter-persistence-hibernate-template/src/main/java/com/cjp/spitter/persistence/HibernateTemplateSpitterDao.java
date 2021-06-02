package com.cjp.spitter.persistence;

import com.cjp.spitter.domain.Spitter;
import com.cjp.spitter.domain.Spittle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class HibernateTemplateSpitterDao implements SpitterDao {

    private static final String SQL_SELECT_SPITTLE = "from Spittle s";
    private static final String SQL_SELECT_SPITTLE_BY_USERNAME = SQL_SELECT_SPITTLE + ", Spitter s2 where s.spitter.id = s2.id and s2.username=?";

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public void addSpitter(Spitter spitter) {
        hibernateTemplate.saveOrUpdate(spitter);
    }

    @Override
    public void saveSpitter(Spitter spitter) {
        hibernateTemplate.update(spitter);
    }

    @Override
    public Spitter getSpitterById(long id) {
        return hibernateTemplate.get(Spitter.class, id);
    }

    @Override
    public List<Spitter> findAllSpitters() {
        return hibernateTemplate.loadAll(Spitter.class);
    }

    @Override
    public Spitter getSpitterByUsername(String username) {
        return hibernateTemplate.get(Spitter.class, username);
    }

    @Override
    public List<Spittle> getRecentSpittle() {
        return hibernateTemplate.loadAll(Spittle.class);
    }

    @Override
    public void saveSpittle(Spittle spittle) {
        hibernateTemplate.update(spittle);
    }

    @Override
    public void addSpittle(Spittle spittle) {
        hibernateTemplate.saveOrUpdate(spittle);
    }

    @Override
    public List getSpittlesByUsername(Spitter spitter) {
        List list = hibernateTemplate.find(SQL_SELECT_SPITTLE_BY_USERNAME, spitter.getUsername());
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
        hibernateTemplate.delete(getSpittleById(id));
    }

    @Override
    public Spittle getSpittleById(long id) {
        return hibernateTemplate.get(Spittle.class, id);
    }
}
