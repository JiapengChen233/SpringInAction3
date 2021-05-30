package com.cjp.spitter.persistence;

import com.cjp.spiter.persistence.SpitterDao;
import com.cjp.spitter.domain.Spitter;
import com.cjp.spitter.domain.Spittle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HibernateTemplateSpitterDao implements SpitterDao {

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
    public List<Spittle> getRecentSpittle() {
        return hibernateTemplate.loadAll(Spittle.class);
    }

    @Override
    public void saveSpittle(Spittle spittle) {
        hibernateTemplate.update(spittle);
    }

    @Override
    public List<Spittle> getSpittlesByUsername(Spitter spitter) {
        return null;
    }

    @Override
    public Spitter getSpitterByUsername(String username) {
        return null;
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
