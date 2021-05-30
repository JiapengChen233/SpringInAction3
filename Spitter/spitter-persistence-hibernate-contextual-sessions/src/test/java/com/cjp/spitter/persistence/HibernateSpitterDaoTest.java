package com.cjp.spitter.persistence;

import com.cjp.spitter.domain.Spitter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:test-persistence-context.xml",
        "classpath:test-dataSource-context2.xml",
        "classpath:test-transaction-context.xml"
})
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class HibernateSpitterDaoTest {

    @Autowired
    private HibernateSpitterDao hibernateSpitterDao;

    @Test
    public void testAddSpitter() {
        insertSpitter("username", "password", "fullname", "email", false);
    }

    @Test
    public void testGetSpitterById() {
        Spitter spitterIn = insertSpitter("username", "password", "fullname", "email", false);
        Spitter spitterOut = hibernateSpitterDao.getSpitterById(spitterIn.getId());
        assertEquals(spitterIn, spitterOut);
    }

    @Test
    public void getFindAllSpitters() {
        insertSpitter("username", "password", "fullname", "email", false);
        insertSpitter("username", "password", "fullname", "email", false);
        List<Spitter> allSpitters = hibernateSpitterDao.findAllSpitters();
        for (Spitter spitter : allSpitters) {
            System.out.println(spitter);
        }
    }

    @Test
    public void testSaveSpitter() {
        insertSpitter("username", "password", "fullname", "email", false);
        Spitter spitterOut = hibernateSpitterDao.getSpitterById(0);
        spitterOut.setUsername("username2");
        hibernateSpitterDao.saveSpitter(spitterOut);
    }

    private Spitter insertSpitter(String username, String password, String fullname, String email, boolean updateByEmail) {
        Spitter spitter = new Spitter();
        spitter.setUsername(username);
        spitter.setPassword(password);
        spitter.setFullName(fullname);
        spitter.setEmail(email);
        spitter.setUpdateByEmail(updateByEmail);
        hibernateSpitterDao.addSpitter(spitter);
        assertNotNull(spitter.getId());
        return spitter;
    }
}
