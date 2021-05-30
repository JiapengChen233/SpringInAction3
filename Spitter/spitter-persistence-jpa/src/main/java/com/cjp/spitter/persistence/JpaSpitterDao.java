package com.cjp.spitter.persistence;

import com.cjp.spiter.persistence.SpitterDao;
import com.cjp.spitter.domain.Spitter;
import com.cjp.spitter.domain.Spittle;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class JpaSpitterDao implements SpitterDao {

    private static final String RECENT_SPITTLES = "select s from Spittle s";
    private static final String ALL_SPITTERS = "select s from Spitter s";
    private static final String SPITTER_FOR_USERNAME = "select s from Spitter s where s.username =:username";
    private static final String SPITTLS_FOR_USERNAME = "select s from Spittle s where s.spitter.username =:username";
    private static final String SPITTLS_DELETE_BY_ID = "delete from spittle where id =:id";

    @PersistenceContext
    private EntityManager em;

    @Override
    public void addSpitter(Spitter spitter) {
        em.persist(spitter);
    }

    @Override
    public void saveSpitter(Spitter spitter) {
        em.merge(spitter);
    }

    @Override
    public Spitter getSpitterById(long id) {
        return em.find(Spitter.class, id);
    }

    @Override
    public List<Spittle> getRecentSpittle() {
        return em.createQuery(RECENT_SPITTLES).getResultList();
    }

    @Override
    public void saveSpittle(Spittle spittle) {
        em.merge(spittle);
    }

    @Override
    public List<Spittle> getSpittlesByUsername(Spitter spitter) {
        return em.createQuery(SPITTLS_FOR_USERNAME).setParameter("username", spitter.getUsername()).getResultList();
    }

    @Override
    public Spitter getSpitterByUsername(String username) {
        return (Spitter) em.createQuery(SPITTER_FOR_USERNAME).setParameter("username", username).getSingleResult();
    }

    @Override
    public void deleteSpittle(long id) {
        em.createNativeQuery(SPITTLS_DELETE_BY_ID).setParameter("id", id);
    }

    @Override
    public Spittle getSpittleById(long id) {
        return em.find(Spittle.class, id);
    }

    @Override
    public List<Spitter> findAllSpitters() {
        return em.createQuery(ALL_SPITTERS).getResultList();
    }

}
