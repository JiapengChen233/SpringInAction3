package com.cjp.spitter.service;

import com.cjp.spitter.persistence.SpitterDao;
import com.cjp.spitter.domain.Spitter;
import org.junit.runner.RunWith;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.easymock.EasyMock.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:dataSource-context.xml",
        "classpath:service-context.xml",
})
public class SpitterServiceTest {

    private SpitterServiceImpl spitterService;
    private SpitterDao spitterDao;
    private Spitter newSpitter;
    private Spitter oldSpitter;

    @Before
    public void setup() {
        newSpitter = new Spitter();
        newSpitter.setUsername("testuser");
        newSpitter.setPassword("password");
        newSpitter.setFullName("Michael McTest");

        oldSpitter = new Spitter();
        oldSpitter.setId(12345L);
        oldSpitter.setUsername("olduser");
        oldSpitter.setPassword("letmein");
        oldSpitter.setFullName("Bob O'Test");

        spitterDao = createNiceMock(SpitterDao.class);
        spitterDao.saveSpitter(oldSpitter);
        spitterDao.addSpitter(newSpitter);
        replay(spitterDao);

        spitterService = new SpitterServiceImpl();
        spitterService.setSpitterDao(spitterDao);
    }

    @Test
    public void shouldAddSpitter() {
        spitterService.saveSpitter(newSpitter);
        spitterService.saveSpitter(oldSpitter);
        verify(spitterDao);
    }
}
