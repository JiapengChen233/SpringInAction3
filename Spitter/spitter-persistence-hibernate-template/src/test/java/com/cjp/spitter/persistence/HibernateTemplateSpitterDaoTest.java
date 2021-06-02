package com.cjp.spitter.persistence;

import com.cjp.spitter.domain.Spitter;
import com.cjp.spitter.domain.Spittle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:persistence-context.xml",
        "classpath:dataSource-context2.xml"
})
public class HibernateTemplateSpitterDaoTest {

    @Autowired
    private HibernateTemplateSpitterDao spitterDao;

    @Test
    public void testAddSpitter() {
        insertSpitter("username", "password", "fullname", "email", false);
    }

    @Test
    public void testGetSpitterById() {
        Spitter spitterIn = insertSpitter("username", "password", "fullname", "email", false);
        Spitter spitterOut = spitterDao.getSpitterById(spitterIn.getId());
        assertEquals(spitterIn, spitterOut);
    }

    @Test
    public void getFindAllSpitters() {
        insertSpitter("username", "password", "fullname", "email", false);
        insertSpitter("username", "password", "fullname", "email", false);
        List<Spitter> allSpitters = spitterDao.findAllSpitters();
        for (Spitter spitter : allSpitters) {
            System.out.println(spitter);
        }
    }

    @Test
    public void testAddSpittle() {
        Spitter spitter = insertSpitter("username", "password", "fullname", "email", false);
        Spittle spittle = insertSpittle(spitter, "text", new Date());
        spitterDao.addSpittle(spittle);
    }

    @Test
    public void testSaveSpittle() {
        Spittle spittleById = spitterDao.getSpittleById(0);
        spittleById.setPostedTime(new Date());
        spitterDao.saveSpittle(spittleById);
    }

    @Test
    public void testGetRecentSpittle() {
        List<Spittle> recentSpittle = spitterDao.getRecentSpittle();
        for (Spittle spittle : recentSpittle) {
            System.out.println(spittle);
        }
    }

    @Test
    public void testGetSpittlesByUsername() {
        Spitter spitter = new Spitter();
        spitter.setUsername("artnames");
        List<Spittle> spittlesByUsername = spitterDao.getSpittlesByUsername(spitter);
        for (Spittle spittle : spittlesByUsername) {
            System.out.println(spittle);
        }
    }

    @Test
    public void testDeleteSpittle() {
        Spittle spittleById = spitterDao.getSpittleById(0);
        spitterDao.deleteSpittle(spittleById.getId());
    }

    private Spitter insertSpitter(String username, String password, String fullname, String email, boolean updateByEmail) {
        Spitter spitter = new Spitter();
        spitter.setUsername(username);
        spitter.setPassword(password);
        spitter.setFullName(fullname);
        spitter.setEmail(email);
        spitter.setUpdateByEmail(updateByEmail);
        spitterDao.addSpitter(spitter);
        assertNotNull(spitter.getId());
        return spitter;
    }

    private Spittle insertSpittle(Spitter spitter, String text, Date postedTime) {
        Spittle spittle = new Spittle();
        spittle.setSpitter(spitter);
        spittle.setText(text);
        spittle.setPostedTime(postedTime);
        return spittle;
    }

}
