package com.cjp.spitter.persistence;

import com.cjp.spitter.domain.Spitter;
import com.cjp.spitter.domain.Spittle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:test-persistence-context.xml",
        "classpath:test-dataSource-context.xml"
})
public class JpaSpitterDaoTest {

    @Autowired
    private JpaSpitterDao jpaSpitterDao;

    @Test
    public void testAddSpitter() {
        Spitter spitter = new Spitter();
        spitter.setUsername("Ronaldo");
        spitter.setPassword("123456");
        spitter.setFullName("RonaldoChen");
        spitter.setEmail("123@gmail.com");
        spitter.setUpdateByEmail(false);
        jpaSpitterDao.addSpitter(spitter);
    }

    @Test
    public void testGetSpitterById() {
        Spitter spitter = jpaSpitterDao.getSpitterById(0L);
        System.out.println(spitter);
    }

    @Test
    public void testFindAllSpitters() {
        List<Spitter> allSpitters = jpaSpitterDao.findAllSpitters();
        for (Spitter spitter : allSpitters) {
            System.out.println(spitter);
        }
    }

    @Test
    public void testGetRecentSpittle() {
        List<Spittle> recentSpittle = jpaSpitterDao.getRecentSpittle();
        for (Spittle spittle : recentSpittle) {
            System.out.println(spittle);
        }
    }

    @Test
    public void testGetSpitterByUsername() {
        Spitter spitter = jpaSpitterDao.getSpitterByUsername("habuma");
        assertNotNull(spitter);
    }

    @Test
    public void testGetSpittlesByUsername() {
        Spitter spitter = new Spitter();
        spitter.setUsername("habuma");
        List<Spittle> spittles = jpaSpitterDao.getSpittlesByUsername(spitter);
        for (Spittle spittle : spittles) {
            System.out.println(spittle);
        }
    }

    @Test
    public void testDeleteSpittleById() {
        jpaSpitterDao.deleteSpittle(1);
    }
}
