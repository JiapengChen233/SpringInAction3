package com.cjp.spitter.persistence;

import com.cjp.spiter.persistence.SpitterDao;
import com.cjp.spitter.domain.Spitter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.jdbc.SimpleJdbcTestUtils.countRowsInTable;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:test-persistence-context3.xml",
        "classpath:test-dataSource-context.xml"
})
public class JdbcSpitterDaoTest {

    @Autowired
    private SimpleJdbcTemplate jdbcTemplate;

    @Autowired
    private SpitterDao spitterDao;

    @Test
    public void testAddSpitter() {
        assertEquals(0, countRowsInTable(jdbcTemplate, "spitter"));
        insertSpitter("username", "password", "fullname", "email", false);
        assertEquals(1, countRowsInTable(jdbcTemplate, "spitter"));
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
    public void testSaveSpitter() {
        insertSpitter("username", "password", "fullname", "email", false);
        Spitter spitterOut = spitterDao.getSpitterById(0);
        spitterOut.setUsername("username2");
        spitterDao.saveSpitter(spitterOut);
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
}
